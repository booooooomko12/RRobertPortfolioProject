package gameobjects;

/**
 * Baseline generator, nothing special.
 *
 * @param <T>
 *            Generates T
 */
public class Synthesizer<T extends GameObject> extends Generator<T> {

    @Override
    public final int compareTo(T o) {
        return this.amount().compareTo(o.amount());
    }

}
