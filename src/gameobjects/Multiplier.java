package gameobjects;

import components.naturalnumber.NaturalNumber;
import fundamentals.EMNumber;

/**
 * An Multiplier specifically designed for The Idle Game to include what
 * {@code Element} this number should multiply. {@code assignedObject} is
 * immutable.
 */
public final class Multiplier extends EMNumber {
    private GameObjectNames assignedObject;

    /*
     * Yay! Constructors!
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
     */
    public Multiplier(Multiplier m) {
        super(m.mantissa(), m.exponent());
        this.assignedObject = m.assignedObject;
    }

    public Multiplier(NaturalNumber n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    public Multiplier(int n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    public Multiplier(EMNumber n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    public Multiplier(double mantissa, int exponent, GameObjectNames a) {
        super(mantissa, exponent);
        this.assignedObject = a;
    }

    public Multiplier(double n, GameObjectNames a) {
        super(n);
        this.assignedObject = a;
    }

    public GameObjectNames assignedObject() {
        return this.assignedObject;
    }
}
