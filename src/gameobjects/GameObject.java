package gameobjects;

import fundamentals.EMNumber;

/**
 * This class exists as a bridge between all "game objects," and not much else.
 */
public abstract class GameObject {
    private EMNumber amount;
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
