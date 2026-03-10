package gameobjects;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;
import fundamentals.GameObjectNames;

public class MultiplierStorage {

    private Set1L<Multiplier> bin;

    /*
     * Yay! Constructors!
     */

    public MultiplierStorage() {
        this.bin = new Set1L<Multiplier>();
    }

    public MultiplierStorage(Multiplier... multis) {
        for (Multiplier m : multis) {
            this.bin.add(m);
        }
    }

    /**
     * Create MultiplierStorage from other MultiplierStorage
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

    public Map<GameObjectNames, Multiplier> convertToCombinedMap(
            boolean additiveMode) {
        Map<GameObjectNames, Multiplier> result = new Map1L<GameObjectNames, Multiplier>();

        if (additiveMode) {
            for (Multiplier m : this.bin) {
                Multiplier valueInMap;
                if (result.hasKey(m.assignedElement())) {
                    valueInMap = result.value(m.assignedElement());
                } else {
                    valueInMap = new Multiplier(m.assignedElement());
                }
                valueInMap.add(m);
                result.replaceValue(m.assignedElement(), valueInMap);

            }
        } else {
            for (Multiplier m : this.bin) {
                Multiplier valueInMap;
                if (result.hasKey(m.assignedElement())) {
                    valueInMap = result.value(m.assignedElement());
                    valueInMap.multiply(m);
                } else {
                    valueInMap = new Multiplier(m.assignedElement());
                    valueInMap.add(m);
                }
                result.replaceValue(m.assignedElement(), valueInMap);

            }
        }

        return result;
    }

    public Map<GameObjectNames, Set<Multiplier>> convertToMap() {
        Map<GameObjectNames, Set<Multiplier>> result = new Map1L<GameObjectNames, Set<Multiplier>>();

        for (Multiplier m : this.bin) {
            if (result.value(m.assignedElement()).size() == 0) {
                Set<Multiplier> tempSet = new Set1L<Multiplier>();
                tempSet.add(m);
                result.add(m.assignedElement(), tempSet);
            } else {
                result.value(m.assignedElement()).add(m);
            }
        }

        return result;
    }
}
