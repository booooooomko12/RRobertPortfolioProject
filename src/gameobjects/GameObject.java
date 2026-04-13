package gameobjects;

import fundamentals.EMNumber;

/**
 * This class exists as a bridge between all "game objects," and not much else.
 */
public abstract class GameObject {

    /*
     * Note: This is the ONE TIME I want to use "protected" because it makes
     * accessing these common variables way easier but whatever, fine,
     * private-not-private it is!
     */

    /**
     * Amount of this.
     */
    private EMNumber amount;

    /**
     * Type of this from GameObjectNames.
     */
    private GameObjectNames type;

    /**
     * @return this.amount
     */
    public EMNumber amount() {
        return this.amount;
    }

    /**
     * Replaces this.amount with amt.
     *
     * @param amt
     */
    public void setAmount(EMNumber amt) {
        this.amount = new EMNumber(amt);
    }

    /**
     *
     * @return this.type
     */
    public GameObjectNames type() {
        return this.type;
    }

    /**
     * Replaces this.type with type.
     *
     * DONT USE THIS FUNCTION UNLESS EXTENDING THIS CLASS; THEY DON'T LET ME USE
     * PROTECTED, IT'S HORRIBLE!
     *
     * @param type
     */
    public void setType(GameObjectNames type) {
        this.type = type;
    }

}
