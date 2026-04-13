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
     * Amount of this
     */
    private EMNumber amount;

    /**
     * Type of this from GameObjectNames
     */
    private GameObjectNames type;

    public EMNumber amount() {
        return this.amount;
    }

    public void setAmount(EMNumber amt) {
        this.amount = new EMNumber(amt);
    }

    public GameObjectNames type() {
        return this.type;
    }

    public void setType(GameObjectNames type) {
        this.type = type;
    }

}
