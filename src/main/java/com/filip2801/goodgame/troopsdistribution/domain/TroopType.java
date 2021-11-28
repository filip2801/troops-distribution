package com.filip2801.goodgame.troopsdistribution.domain;

import java.util.EnumSet;
import java.util.Set;

public enum TroopType {
    ARCHERS,
    SPEARMEN,
    SWORDSMEN;

    public static final Set<TroopType> ALL = EnumSet.allOf(TroopType.class);

}
