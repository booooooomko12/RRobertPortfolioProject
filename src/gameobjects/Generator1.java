package gameobjects;

import fundamentals.EMNumber;

/**
 * Simple single-GameObject generator.
 *
 * @param <T>
 *            Generates T
 */
public class Generator1<T extends GameObject> extends GeneratorSecondary<T> {

    //Just used for newInstance, if it breaks that's on the client lol
    /**
     * DON'T USE THIS.
     */
    private Generator1() {
        this.setAmount(new EMNumber());
        this.setType(null);
        this.setOutputMultiplier(new Multiplier((GameObjectNames) null));
    }

    /**
     * Baseline contructor of Generator1.
     *
     * @param type
     *            GameObject type (from GameObjectNames)
     */
    public Generator1(GameObjectNames type) {
        this.setAmount(new EMNumber());
        this.setType(type);
        this.setOutputMultiplier(new Multiplier(type));
    }

    /**
     * Contructor of Generator1 with type and amount.
     *
     * @param type
     *            GameObject type (from GameObjectNames)
     * @param amount
     */
    public Generator1(GameObjectNames type, EMNumber amount) {
        this.setAmount(amount);
        this.setType(type);
        this.setOutputMultiplier(new Multiplier(type));
    }

    /**
     * Contructor of Generator1 with type, amount, and an attached Multiplier.
     *
     * @param type
     *            GameObject type (from GameObjectNames)
     * @param amount
     * @param multi
     *            Multiplier to output:
     *
     *            output = multi * amount
     */
    public Generator1(GameObjectNames type, EMNumber amount, Multiplier multi) {
        this.setAmount(amount);
        this.setType(type);
        Multiplier temp = new Multiplier(multi.mantissa(), multi.exponent(),
                type);

        this.setOutputMultiplier(temp);
    }

    @Override
    public final int compareTo(GeneratorSecondary<T> o) {
        return this.amount().compareTo(o.amount());
    }

    @Override
    public final GeneratorSecondary<T> newInstance() {

        return new Generator1<T>();
    }
}
