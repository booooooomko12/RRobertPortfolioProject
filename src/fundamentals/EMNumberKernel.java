package fundamentals;

import components.standard.Standard;

/**
 * Interface for implementing the base methods for exponent-mantissa number
 * notation.
 *
 * @author Riley Robert
 */
public interface EMNumberKernel extends Standard<EMNumber> {
    /**
     * Adds {@code n} to {@code this}.
     *
     * @ensures {@code #this = this + n}
     * @updates this
     * @param n
     *            Number to be added
     */
    void add(EMNumber n);

    /**
     * Subtracts {@code n} from {@code this}.
     *
     * @ensures {@code #this = this - n}
     * @param n
     *            Number to be subtracted.
     */
    void subtract(EMNumber n);

    /**
     * Multiplies {@code  this} by {@code n}.
     *
     * @ensures {@code #this = this * n}
     * @param n
     *            Number to multiply by.
     */
    void multiply(EMNumber n);

    /**
     * Divides {@code this} by {@code n}.
     *
     * @ensures {@code #this = this / n}
     * @param n
     *            Number to divide by.
     */
    void divide(EMNumber n);
}
