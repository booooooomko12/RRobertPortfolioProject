package gameobjects;

import fundamentals.EMNumber;

/**
 * @param <T>
 *            Generates T
 */
public abstract class Generator<T extends GameObject> extends GameObject
        implements GeneratorKernel<T> {

    /*
     * Variables
     */
    /**
     * Intended data from MultiplierStorage.convertToCombinedMap()
     */
    private Multiplier outputMultiplier;

    /*
     * Methods
     */
    @Override
    public final EMNumber generate() {
        EMNumber generated = new EMNumber(this.amount());
        generated.multiply(this.outputMultiplier);
        return generated;
    }

}
