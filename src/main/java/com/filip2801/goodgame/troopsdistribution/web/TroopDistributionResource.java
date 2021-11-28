package com.filip2801.goodgame.troopsdistribution.web;

import com.filip2801.goodgame.troopsdistribution.domain.TroopType;

import java.util.Map;

public class TroopDistributionResource {

    private Map<TroopType, Integer> troops;

    TroopDistributionResource() {
    }

    public TroopDistributionResource(Map<TroopType, Integer> troops) {
        this.troops = troops;
    }

    public Map<TroopType, Integer> getTroops() {
        return troops;
    }
}
