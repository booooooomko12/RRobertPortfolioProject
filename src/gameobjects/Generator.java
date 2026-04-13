package gameobjects;

import fundamentals.EMNumber;

/**
 * Baseline Generator representation.
 *
 * Input parameter <T> is a GameObject and Generator itself is a GameObject.
 *
 * @param <T>
 *            Generates T (GameObject)
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
