package gameobjects;

import fundamentals.EMNumber;

/**
 * Simple single-GameObject generator.
 *
 * @param <T>
 *            Generates T
 */
public class Synthesizer<T extends GameObject> extends GeneratorSecondary<T> {

    //Just used for newInstance, if it breaks that's on the client lol
    private Synthesizer() {
        this.setAmount(new EMNumber());
        this.setType(null);
        this.setOutputMultiplier(new Multiplier((GameObjectNames) null));
    }

    public Synthesizer(GameObjectNames type) {
        this.setAmount(new EMNumber());
        this.setType(type);
        this.setOutputMultiplier(new Multiplier(type));
    }

    public Synthesizer(GameObjectNames type, EMNumber amount) {
        this.setAmount(amount);
        this.setType(type);
        this.setOutputMultiplier(new Multiplier(type));
    }

    public Synthesizer(GameObjectNames type, EMNumber amount,
            Multiplier multi) {
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
    public T newInstance() {
        // I have no idea how this would fail. This whole function sucks.

        return (T) new Synthesizer<T>();
    }
}
