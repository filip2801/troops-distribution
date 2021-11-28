package com.filip2801.goodgame.troopsdistribution.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
public class RandomTroopDistributionAlgorithm implements TroopDistributionAlgorithm {

    private static final Random RANDOM = new Random();

    @Override
    public Map<TroopType, Integer> distribute(List<TroopType> troopTypes, int numberOfAllSoldiers) {
        Map<TroopType, Integer> result = new HashMap<>();

        // each troop must contain at least 1 soldier
        var soldiersToDistributeRandomly = numberOfAllSoldiers - troopTypes.size();

        for (int i = 0; i < troopTypes.size() - 1; i++) {
            var soldiersInTroop = getRandomNumber(soldiersToDistributeRandomly);
            soldiersToDistributeRandomly = soldiersToDistributeRandomly - soldiersInTroop;

            result.put(troopTypes.get(i), soldiersInTroop + 1);
        }

        result.put(troopTypes.get(troopTypes.size() - 1), soldiersToDistributeRandomly + 1);

        return result;
    }

    private int getRandomNumber(int bound) {
        return bound > 0 ? RANDOM.nextInt(bound) : 0;
    }

}
