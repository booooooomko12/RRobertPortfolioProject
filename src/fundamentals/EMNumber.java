package fundamentals;

import components.naturalnumber.NaturalNumber;

/**
 * Author: Riley Robert
 *
 * Representation of positive numbers using exponent-mantissa calculation.
 *
 */
public class EMNumber implements Comparable<EMNumber> {
    private final int mantissaSigFigs = 5;

    /**
     * Stores up to 9.99999. Multiplied by this.exponent.
     */
    private float mantissa;

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

    public EMNumber(float mantissa, int exponent) {
        this.mantissa = mantissa;
        this.exponent = exponent;
    }

    public EMNumber(double mantissa, int exponent) {
        this.mantissa = (float) mantissa;
        this.exponent = exponent;
    }

    /*
     * Kernel Methods
     */

    public float mantissa() {
        return this.mantissa;
    }

    public int exponent() {
        return this.exponent;
    }

    public boolean isZero() {
        return ((Math.abs(this.mantissa()) < 0.00001) && this.exponent == 0);
    }

    public void add(EMNumber n) {
        // Trying to make this as fast as possible, don't do anything complex
        // unless necessary

        //If n is too small...
        if (this.exponent - n.exponent > this.mantissaSigFigs) {
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
                this.mantissa += (float) Math.pow(n.mantissa,
                        exponentDifference);
                if (this.mantissa >= 10) {
                    this.mantissa %= 10;
                    this.exponent++;
                }

                //n is bigger
            } else {
                this.exponent = n.exponent;
                this.mantissa = n.mantissa
                        + (float) Math.pow(this.mantissa, -exponentDifference);
                if (this.mantissa >= 10) {
                    this.mantissa %= 10;
                    this.exponent++;
                }
            }
        }
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

    /*
     * Secondary Methods
     */

}
