package com.filip2801.goodgame.troopsdistribution.domain;

import java.util.List;
import java.util.Map;

interface TroopDistributionAlgorithm {

    /**
     * Distribute given soldiers into troops
     * @param troopTypes troop types
     * @param numberOfAllSoldiers soldiers to distribute
     * @return distributed soldiers
     */
    Map<TroopType, Integer> distribute(List<TroopType> troopTypes, int numberOfAllSoldiers);

}
