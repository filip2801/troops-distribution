package com.filip2801.goodgame.troopsdistribution.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Distributes given soldiers into troops.
 * <p/>
 * Requirements:
 * <ul>
 *   <li>each troop > 0</li>
 *   <li>result non-deterministic</li>
 *   <li>O(1)</li>
 * </ul>
 */
class RandomTroopDistributionAlgorithm implements TroopDistributionAlgorithm {

    private static final Random RANDOM = new Random();

    @Override
    public Map<TroopType, Integer> distribute(Set<TroopType> troopTypes, int numberOfAllSoldiers) {
        validate(troopTypes, numberOfAllSoldiers);

        List<TroopType> types = new ArrayList<>(troopTypes);
        Collections.shuffle(types);

        // each troop must contain at least 1 soldier
        var soldiersToDistributeRandomly = numberOfAllSoldiers - troopTypes.size();

        Map<TroopType, Integer> result = new HashMap<>();
        for (int i = 0; i < troopTypes.size() - 1; i++) {
            var soldiersInTroop = getRandomNumber(soldiersToDistributeRandomly);
            soldiersToDistributeRandomly = soldiersToDistributeRandomly - soldiersInTroop;

            result.put(types.get(i), soldiersInTroop + 1);
        }

        result.put(types.get(troopTypes.size() - 1), soldiersToDistributeRandomly + 1);

        return result;
    }

    private void validate(Set<TroopType> troopTypes, int numberOfAllSoldiers) {
        if (troopTypes == null || troopTypes.isEmpty()) {
            throw new CannotDistributeTroopsException("Troop types is empty");
        }

        if (troopTypes.size() > numberOfAllSoldiers) {
            throw new CannotDistributeTroopsException("Not enough soldiers");
        }
    }

    private int getRandomNumber(int bound) {
        return bound > 0 ? RANDOM.nextInt(bound) : 0;
    }

}
