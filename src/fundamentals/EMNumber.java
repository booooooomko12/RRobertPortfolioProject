package fundamentals;

import components.naturalnumber.NaturalNumber;

/**
 * Author: Riley Robert
 *
 * Representation of positive numbers using exponent-mantissa calculation.
 *
 */
public class EMNumber implements Comparable<EMNumber> {
    private final int mantissaSigFigs = 7;
    private final double MANTISSA_MAX = 9.9999999;

    /**
     * Stores values from 0 to 9.9999999. Multiplied by this.exponent.
     */
    private double mantissa;

    /**
     * Represents values in 10^(exponent) format.
     */
    private int exponent;

    /*
     * Yay! Constructors!
     */

    public EMNumber() {
        this.mantissa = 0;
        this.exponent = 0;
    }

    public EMNumber(NaturalNumber n) {
        this.mantissa = 0;
        this.exponent = 0;
        String stringTemp = n.toString();

        for (int i = 0; i < stringTemp.length(); i++) {
            //Marked as magic number, it is not, it's just decimal math.
            if (i <= this.mantissaSigFigs) {
                this.mantissa += ((Math.pow(10, -i))
                        * Integer.parseInt(stringTemp.charAt(i) + ""));
            }

            //Skip the first exponent count, since 0-9 is 10^0
            if (i != 0) {
                this.exponent++;
            }
        }
    }

    public EMNumber(int n) {
        assert n >= 0 : "Cannot intantiate EMNumber with negative value.";
        this.mantissa = 0;
        this.exponent = 0;
        String stringTemp = "" + n;

        for (int i = 0; i < stringTemp.length(); i++) {
            //Marked as magic number, it is not, it's just decimal math.
            if (i <= this.mantissaSigFigs) {
                this.mantissa += ((Math.pow(10, -i))
                        * Integer.parseInt(stringTemp.charAt(i) + ""));
            }

            //Skip the first exponent count, since 0-9 is 10^0
            if (i != 0) {
                this.exponent++;
            }
        }
    }

    public EMNumber(EMNumber n) {
        this.mantissa = n.mantissa;
        this.exponent = n.exponent;
    }

    public EMNumber(double mantissa, int exponent) {
        assert mantissa >= 0 : "Cannot intantiate EMNumber with negative value.";
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public EMNumber(double n) {
        assert n >= 0 : "Cannot intantiate EMNumber with negative value.";
        this.mantissa = n;
        this.fixMantissa();
    }

    /*
     * Private Methods
     */

    /**
     * Fixes the mantissa in the case 0 < this.mantissa < 1 OR 9.99999 <
     * this.mantissa, restoring format and adjusting this.exponent accordingly.
     */
    private void fixMantissa() {
        while (this.mantissa < 1) {
            this.mantissa *= 10;
            this.exponent--;
        }

        while (this.mantissa > this.MANTISSA_MAX) {
            this.mantissa /= 10;
            this.exponent++;
        }
    }

    /*
     * Kernel Methods
     */

    public double mantissa() {
        return this.mantissa;
    }

    public int exponent() {
        return this.exponent;
    }

    public boolean isZero() {
        return ((this.mantissa() < 0.0000001) && this.exponent == 0);
    }

    public void add(EMNumber n) {
        // Trying to make this as fast as possible, don't do anything complex
        // unless necessary

        //Checking for zeros (Math.pow explodes otherwise)
        if (this.isZero()) {
            this.mantissa = n.mantissa;
            this.exponent = n.exponent;
            return;
        }

        //If n is too small...
        if (this.exponent - n.exponent > this.mantissaSigFigs || n.isZero()) {
            return;
        }

        //If n is actually way bigger...
        if (n.exponent - this.exponent > this.mantissaSigFigs) {
            this.mantissa = n.mantissa;
            this.exponent = n.exponent;
            return;
        }

        //If this and n are equal magnitude...
        if (this.exponent == n.exponent) {
            if (this.mantissa + n.mantissa >= 10) {
                {
                    this.mantissa = (this.mantissa + n.mantissa) % 10;
                    this.fixMantissa();
                    this.exponent++;
                }
            } else {
                this.mantissa += n.mantissa;
            }

            //WORST CASE SCENARIO!
        } else {
            int exponentDifference = n.exponent - this.exponent;

            //this is bigger
            if (exponentDifference < 0) {
                this.mantissa += (double) Math.pow(n.mantissa,
                        exponentDifference);
                if (this.mantissa >= 10) {
                    this.mantissa %= 10;
                    this.exponent++;
                    this.fixMantissa();
                }

                //n is bigger
            } else {
                this.exponent = n.exponent;
                this.mantissa = n.mantissa
                        + (double) Math.pow(this.mantissa, -exponentDifference);
                if (this.mantissa >= 10) {
                    this.mantissa %= 10;
                    this.exponent++;
                    this.fixMantissa();
                }
            }
        }
    }

    public void subtract(EMNumber n) {
        assert (this.exponent - n.exponent > 0
                || (this.exponent - n.exponent == 0 && this.mantissa
                        - n.mantissa < 0)) : "Subtraction would cause negative value.";

        // Trying to make this as fast as possible, don't do anything complex
        // unless necessary

        //If n is too small...
        if (this.exponent - n.exponent > this.mantissaSigFigs) {
            return;
        }

        //If this and n are equal magnitude...
        if (this.exponent == n.exponent) {
            if (this.mantissa - n.mantissa < 0) {

                this.mantissa = 10 + (this.mantissa - n.mantissa);
                this.exponent--;

            } else {
                this.mantissa -= n.mantissa;
            }

            //WORST CASE SCENARIO!
            //Thankfully easier than add() due to negative prevention
        } else {
            int exponentDifference = n.exponent - this.exponent;
            this.mantissa += (double) Math.pow(n.mantissa, exponentDifference);
            if (this.mantissa <= 10) {
                this.mantissa = 10 - this.mantissa;
                this.exponent--;
                this.fixMantissa();

                //n is bigger
            }
        }
    }

    /*
     * multiply and divide are not secondary methods due to being WAY faster on
     * their own
     */
    public void multiply(EMNumber n) {
        //I don't care that I'm using a kernel in a kernel, it'd be the exact
        //same code regardless, quit being picky!

        if (this.isZero() || n.isZero()) {
            this.mantissa = 0.0;
            this.exponent = 0;
        } else {
            this.exponent += n.exponent;
            this.mantissa *= n.mantissa;
            this.fixMantissa();
        }
    }

    public void divide(EMNumber n) {
        assert !this.isZero() && !n.isZero() : "ERROR: Division by 0.";

        this.exponent -= n.exponent;
        this.mantissa /= n.mantissa;
        this.fixMantissa();
    }

    @Override
    public int compareTo(EMNumber o) {
        if (this.exponent > o.exponent) {
            return 1;
        } else if (this.exponent < o.exponent) {
            return -1;
        } else {
            if ((this.mantissa - o.mantissa) > 0.00001) {
                return 1;
            } else if ((this.mantissa - o.mantissa) < -0.00001) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%.7f", this.mantissa) + "E" + this.exponent;
    }

    /*
     * Secondary Methods
     */

}
