package com.filip2801.goodgame.troopsdistribution.domain;

import java.util.Map;
import java.util.Set;

interface TroopDistributionAlgorithm {

    /**
     * Distribute given soldiers into troops
     * @param troopTypes troop types
     * @param numberOfAllSoldiers soldiers to distribute
     * @return distributed soldiers
     */
    Map<TroopType, Integer> distribute(Set<TroopType> troopTypes, int numberOfAllSoldiers);

}
