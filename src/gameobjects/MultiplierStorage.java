package gameobjects;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;

/**
 * A set of multipliers meant to be assigned to various Generator(s) to alter
 * their behavior. Allows for easy conversion between Set<Multiplier> to
 * Map<GameObjectNames, Multiplier>.
 */
public class MultiplierStorage {

    /**
     * Set containing all multipliers.
     */
    private Set1L<Multiplier> bin;

    /*
     * Yay! Constructors!
     */

    /**
     * Baseline MultiplierStorage constructor, empty.
     */
    public MultiplierStorage() {
        this.bin = new Set1L<Multiplier>();
    }

    /**
     * MultiplierStorage constructor which takes 1+ Multipliers to place in
     * this.bin.
     *
     * @param multis
     */
    public MultiplierStorage(Multiplier... multis) {
        for (Multiplier m : multis) {
            // #WorstSetClassEverMade
            if (!this.bin.contains(m)) {
                this.bin.add(m);
            }
        }
    }

    /**
     * Create MultiplierStorage from other MultiplierStorage.
     *
     * @clears transfered
     * @param transfered
     *            MS to transfer from
     */
    public MultiplierStorage(MultiplierStorage transfered) {
        this.bin.transferFrom(transfered.bin);
    }

    /**
     * Create MultiplierStorage from a set of Multipliers.
     *
     * @clears multiSet
     * @param multiSet
     *            Set to transfer from
     *
     */
    public MultiplierStorage(Set<Multiplier> multiSet) {
        this.bin.transferFrom(multiSet);
    }

    /**
     * Converts this.bin from Set(Multiplier) to Map(GameObjectNames,
     * Multiplier) where the value of the map is all multipliers of the same
     * type added/multiplied together to create 1 value, depending on
     * additiveMode.
     *
     * @param additiveMode
     *            Dictates whether or not Multipliers will be combined through
     *            addition or multiplication.
     * @return Map(GameObjectNames, Multiplier)
     */
    public Map<GameObjectNames, Multiplier> convertToCombinedMap(
            boolean additiveMode) {

        //Hilariously impossible line to style correctly.
        Map<GameObjectNames, Multiplier> result = new Map1L<GameObjectNames, Multiplier>();

        if (additiveMode) {
            for (Multiplier m : this.bin) {
                Multiplier valueInMap;
                if (result.hasKey(m.assignedObject())) {
                    valueInMap = result.value(m.assignedObject());
                } else {
                    valueInMap = new Multiplier(m.assignedObject());
                }
                valueInMap.add(m);
                result.replaceValue(m.assignedObject(), valueInMap);

            }
        } else {
            for (Multiplier m : this.bin) {
                Multiplier valueInMap;
                if (result.hasKey(m.assignedObject())) {
                    valueInMap = result.value(m.assignedObject());
                    valueInMap.multiply(m);
                } else {
                    valueInMap = new Multiplier(m.assignedObject());
                    valueInMap.add(m);
                }
                result.replaceValue(m.assignedObject(), valueInMap);

            }
        }

        return result;
    }

    /**
     * Converts this.bin from Set(Multiplier) to Map(GameObjectNames,
     * Set(Multiplier)) where the value of the map is a set of all type-related
     * multipliers.
     *
     * @return Map(GameObjectNames, Set(Multiplier))
     */
    public final Map<GameObjectNames, Set<Multiplier>> convertToMap() {

        //An even funnier, unstylable line.
        Map<GameObjectNames, Set<Multiplier>> result = new Map1L<GameObjectNames, Set<Multiplier>>();

        for (Multiplier m : this.bin) {
            if (result.value(m.assignedObject()).size() == 0) {
                Set<Multiplier> tempSet = new Set1L<Multiplier>();
                tempSet.add(m);
                result.add(m.assignedObject(), tempSet);
            } else {
                result.value(m.assignedObject()).add(m);
            }
        }

        return result;
    }
}
