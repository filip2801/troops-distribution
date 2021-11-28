package com.filip2801.goodgame.troopsdistribution.domain;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TroopDistributionService {

    private final TroopDistributionAlgorithm troopDistributionAlgorithm;

    public TroopDistributionService() {
        this.troopDistributionAlgorithm = new RandomTroopDistributionAlgorithm();
    }

    public Map<TroopType, Integer> distributeTroops(int numberOfAllSoldiers) {
        return troopDistributionAlgorithm.distribute(TroopType.ALL, numberOfAllSoldiers);
    }

}
