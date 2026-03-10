package gameobjects;

import components.standard.Standard;
import fundamentals.EMNumber;

/**
 * Necessary funtions for {@code Generator} classes.
 *
 * @author Riley Robert
 * @param <GameObject>
 */
public interface GeneratorKernel<GameObject> extends Standard<GameObject> {

    /**
     * Calculates the amount of {@code GameObjects} to "create," intended to
     * update {@code GameObject.amount} as opposed to actually creating x
     * Objects.
     *
     * @return generated Calculated amount of {@code GameObject} created
     */
    EMNumber generate();

}
