package gameobjects;

import components.naturalnumber.NaturalNumber;
import fundamentals.EMNumber;

/**
 * An Multiplier specifically designed for The Idle Game to include what
 * {@code Element} this number should multiply. {@code assignedObject} is
 * immutable.
 *
 * @convention <pre>
 * [convention for EMNumber is adhered] and [$this.assignedObject is a
 * value described in GameObjectNames]
 * </pre>
 */
public final class Multiplier extends EMNumber {
    /**
     * Ensures this multiplier only effects objects of same type.
     */
    private GameObjectNames assignedObject;

    /*
     * Yay! Constructors!
     */

    /**
     * Baseline contructor.
     *
     * @param a
     */
    public Multiplier(GameObjectNames a) {
        super();
        this.assignedObject = a;
    }

    /**
     * Creates a copy of m. No values of m are defaulted.
     *
     * @param m
     *            To be copied
     * @restores m
     */
    public Multiplier(Multiplier m) {
        super(m.mantissa(), m.exponent());
        this.assignedObject = m.assignedObject;
    }

    /**
     * Constructor with NaturalNumber.
     *
     * @param n
     * @param a
     */
    public Multiplier(NaturalNumber n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    /**
     * Constructor with int.
     *
     * @param n
     * @param a
     */
    public Multiplier(int n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    /**
     * Constructor with EMNumber.
     *
     * @param n
     * @param a
     */
    public Multiplier(EMNumber n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    /**
     * Constructor with mantissa and exponent, number represented as mantissa *
     * 10^(exponent).
     *
     * @param mantissa
     * @param exponent
     * @param a
     */
    public Multiplier(double mantissa, int exponent, GameObjectNames a) {
        super(mantissa, exponent);
        this.assignedObject = a;
    }

    /**
     * Constructor with double.
     *
     * @param n
     * @param a
     */
    public Multiplier(double n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    /**
     * Returns this.assignedObject().
     *
     * @return this.assignedObject
     */
    public GameObjectNames assignedObject() {
        return this.assignedObject;
    }
}
