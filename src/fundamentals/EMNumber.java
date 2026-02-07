package fundamentals;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Author: Riley Robert
 *
 * Representation of positive numbers using exponent-mantissa calculation.
 *
 */
public class EMNumber implements Comparable<EMNumber> {
    private final int mantissaSigFigs = 6;

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
        NaturalNumber temp = new NaturalNumber2();
        temp.copyFrom(n);

        for (int i = 0; i < this.mantissaSigFigs && !temp.isZero(); i++) {
            //Marked as magic number, it is not, it's just decimal math.
            this.mantissa *= (1 / (Math.pow(10, -i)) * temp.divideBy10());
            this.exponent++;
        }

        while (!temp.isZero()) {
            temp.divideBy10();
            this.exponent++;
        }
    }

    public EMNumber(int n) {
        int temp = n;
        for (int i = 0; i < this.mantissaSigFigs && temp >= 0; i++) {
            //Marked as magic number, it is not, it's just decimal math.
            this.mantissa *= (1 / (Math.pow(10, -i)) * (temp % 10));
            temp /= 10;
            this.exponent++;
        }

        while (temp >= 0) {
            temp /= 10;
            this.exponent++;
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

    /*
     * Kernel Methods
     */

    public float mantissa() {
        return this.mantissa;
    }

    public int exponent() {
        return this.exponent;
    }

    public void add(EMNumber n) {
        // Trying to make this as fast as possible, don't do anything complex
        // unless necessary

        //If n is too small...
        if (this.exponent - n.exponent < this.mantissaSigFigs) {

            //If n is actually way bigger...
            if (n.exponent - this.exponent > this.mantissaSigFigs) {
                this.mantissa = n.mantissa;
                this.exponent = n.exponent;
            }

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
