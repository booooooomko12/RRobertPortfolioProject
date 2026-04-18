package gameobjects;

import fundamentals.EMNumber;

/**
 * Simple single-GameObject generator.
 *
 * @convention <pre>
 * [$this.outputMultiplier is a valid Multiplier] and
 * [$this.outputMultiplier.type == $this.type]
 * </pre>
 *
 * @correspondence <pre>
 * this = [a representation of a GameObject "generator"] and
 * [$this.generate() = $this.amount * $this.outputMultiplier]
 * </pre>
 *
 * @param <T>
 *            Generates T
 */
public class Generator1<T extends GameObject> extends GeneratorSecondary<T> {

    //Just used for newInstance, if it breaks that's on the client lol
    /**
     * DON'T USE THIS.
     *
     */
    private Generator1() {
        this.setAmount(new EMNumber());
        this.setType(null);
        this.setOutputMultiplier(new Multiplier((GameObjectNames) null));
    }

    /**
     * Baseline contructor of Synthesizer.
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
     * Contructor of Synthesizer with type and amount.
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
     * Contructor of Synthesizer with type, amount, and an attached Multiplier.
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
    public final int compareTo(T o) {
        return this.amount().compareTo(o.amount());
    }

    @SuppressWarnings("unchecked")
    @Override
    public final T newInstance() {
        // I have no idea how this would fail. This whole function sucks.

        return (T) new Generator1<T>();
    }
}
