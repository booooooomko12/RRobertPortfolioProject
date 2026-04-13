package gameobjects;

import fundamentals.EMNumber;

/**
 * The GameObject representation of currencies, periodic elements, etc.
 */
public class Material extends GameObject {
    /**
     * Prettier name to be displayed for this Material, defaults to this.type.
     */
    private String displayName;

    /**
     * Baseline constructor for Material. Type must be defined.
     *
     * @param type
     */
    public Material(GameObjectNames type) {
        this.setAmount(new EMNumber());
        this.setType(type);
        this.displayName = "" + type.toString();
    }

    /**
     * Constructor for Material with amount = 0.
     *
     * @param type
     * @param displayName
     */
    public Material(GameObjectNames type, String displayName) {
        this.setAmount(new EMNumber());
        this.setType(type);
        this.displayName = displayName;
    }

    /**
     * Fully complete constructor for a Material.
     *
     * @param type
     * @param displayName
     * @param amt
     */
    public Material(GameObjectNames type, String displayName, EMNumber amt) {
        this.setAmount(amt);
        this.setType(type);
        this.displayName = displayName;
    }

    /**
     * Simplified addition method for Materials.
     *
     * this.amount = #this.amount + toAdd
     *
     * @updates this
     * @param toAdd
     *            Number to be added
     *
     */
    public void add(EMNumber toAdd) {
        EMNumber stupidTemp = new EMNumber(this.amount());
        stupidTemp.add(toAdd);
        this.setAmount(stupidTemp);
    }

    /**
     * Simplified subtraction method.
     *
     * Checks if subtraction is valid, if true, subtraction IS performed and
     * returns true, otherwise, subtraction IS NOT performed and returns false.
     *
     * if (this.amount() > toSubtract) then this.amount
     *
     * @updates this
     * @param toSubtract
     * @return this.amount() > toSubtract
     */
    public boolean subtract(EMNumber toSubtract) {
        if (this.amount().compareTo(toSubtract) >= 0) {
            EMNumber stupidTemp = new EMNumber(this.amount());
            stupidTemp.subtract(toSubtract);
            this.setAmount(stupidTemp);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Simplified multiplication method for Materials.
     *
     * this.amount = #this.amount * toMultiply
     *
     * @updates this
     * @param toMultiply
     *            Number to be multiplied
     */
    public void multiply(EMNumber toMultiply) {
        EMNumber stupidTemp = new EMNumber(this.amount());
        stupidTemp.multiply(toMultiply);
        this.setAmount(stupidTemp);
    }

    /**
     * Simplified division method for Materials.
     *
     * this.amount = #this.amount / divisor
     *
     * @updates this
     * @param divisor
     *            Number to be multiplied
     */
    public void divide(EMNumber divisor) {
        EMNumber stupidTemp = new EMNumber(this.amount());
        stupidTemp.divide(divisor);
        this.setAmount(stupidTemp);
    }

    /**
     * Returns this.displayName.
     *
     * @return Come on just read the description
     */
    public String name() {
        return this.displayName;
    }
}
