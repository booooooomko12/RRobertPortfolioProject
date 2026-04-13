package gameobjects;

import fundamentals.EMNumber;

/**
 * Necessary funtions for {@code Generator} classes.
 *
 * @author Riley Robert
 * @param <T>
 *            an object classified as a {@code GameObject}.
 */
public interface GeneratorKernel<T extends GameObject> extends Comparable<T> {

    /**
     * Calculates the amount of {@code T} to "create," intended to update
     * {@code T.amount} as opposed to actually creating x Objects.
     *
     * @return generated Calculated amount of {@code T} created
     */
    EMNumber generate();

}
