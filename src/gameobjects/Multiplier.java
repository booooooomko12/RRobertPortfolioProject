package gameobjects;

import components.naturalnumber.NaturalNumber;
import fundamentals.EMNumber;

/**
 * An Multiplier specifically designed for The Idle Game to include what
 * {@code Element} this number should multiply. {@code assignedElement} is
 * immutable.
 */
public final class Multiplier extends EMNumber {
    private GameObjectNames assignedElement;

    /*
     * Yay! Constructors!
     */

    //please never use this
    public Multiplier() {
        super();
        this.assignedElement = null;
    }

    public Multiplier(GameObjectNames a) {
        super();
        this.assignedElement = a;
    }

    /**
     * Creates a copy of m. No values of m are defaulted.
     *
     * @param m
     *            To be copied
     */
    public Multiplier(Multiplier m) {
        super(m.mantissa(), m.exponent());
        this.assignedElement = m.assignedElement;
    }

    public Multiplier(NaturalNumber n, GameObjectNames a) {
        super(n);
        this.assignedElement = a;
    }

    public Multiplier(int n, GameObjectNames a) {
        super(n);
        this.assignedElement = a;
    }

    public Multiplier(EMNumber n, GameObjectNames a) {
        super(n);
        this.assignedElement = a;
    }

    public Multiplier(double mantissa, int exponent, GameObjectNames a) {
        super(mantissa, exponent);
        this.assignedElement = a;
    }

    public Multiplier(double n, GameObjectNames a) {
        super(n);
        this.assignedElement = a;
    }

    public GameObjectNames assignedElement() {
        return this.assignedElement;
    }
}
