package gameobjects;

import components.standard.Standard;
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
        extends GameObject implements GeneratorKernel<T>,
        Comparable<GeneratorSecondary<T>>, Standard<GeneratorSecondary<T>> {

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
    public Multiplier outputMultiplier() {
        return this.outputMultiplier;
    }

    /**
     * Sets this.outputMultiplier. If this.type == null, this.type will be
     * changed to that of the outputMultiplier. Otherwise this.type() must equal
     * m.assignedObject().
     *
     * @updates this.outputMultiplier
     * @updates this.type IF this.type == null
     * @param m
     */
    public void setOutputMultiplier(Multiplier m) {

        //This ONLY happens if you use newInstance.
        if (this.type() == null) {
            this.setType(m.assignedObject());
            this.outputMultiplier = new Multiplier(m);
        } else {
            assert this.type().equals(m
                    .assignedObject()) : "Cannot assign Multiplier of different type than this.";
            this.outputMultiplier = new Multiplier(m);
        }
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
    public final void transferFrom(GeneratorSecondary<T> arg0) {

        this.setType(arg0.type());
        this.setAmount(arg0.amount());
        this.outputMultiplier = arg0.outputMultiplier;
    }

}
