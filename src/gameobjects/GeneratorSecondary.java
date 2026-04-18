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
public abstract class GeneratorSecondary<T extends GameObject>
        extends GameObject implements GeneratorKernel<T> {

    /*
     * Variables
     */
    /**
     * Intended data from MultiplierStorage.convertToCombinedMap().
     */
    private Multiplier outputMultiplier;

    /*
     * Methods
     */

    /**
     * Getter.
     *
     * @return this.outputMultiplier()
     */
    public Multiplier outpitMultiplier() {
        return this.outputMultiplier;
    }

    /**
     * Sets this.outputMultiplier. Uses transferFrom()
     *
     * @updates this.outputMultiplier
     * @clears m
     * @param m
     */
    public void setOutputMultiplier(Multiplier m) {
        this.outputMultiplier.transferFrom(m);
    }

    @Override
    public final EMNumber generate() {
        EMNumber generated = new EMNumber(this.amount());
        generated.multiply(this.outputMultiplier);
        return generated;
    }

    @Override
    public final void clear() {
        this.setAmount(new EMNumber());
        this.outputMultiplier = new Multiplier(this.type());
    }

    @Override
    public final void transferFrom(T arg0) {
        assert (arg0 instanceof GeneratorSecondary) : ""
                + "Cannot transfer data from non-generator into generator object.";

        // I just checked the typecast ignore the warning
        @SuppressWarnings("unchecked")
        GeneratorSecondary<T> itsAGeneratorTrust = (GeneratorSecondary<T>) arg0;

        this.setType(itsAGeneratorTrust.type());
        this.setAmount(itsAGeneratorTrust.amount());
        this.outputMultiplier = itsAGeneratorTrust.outputMultiplier;
    }

}
