package com.filip2801.goodgame.troopsdistribution.model

import spock.lang.Specification

import static com.filip2801.goodgame.troopsdistribution.model.TroopType.*

class RandomTroopDistributionAlgorithmTest extends Specification {

    def algorithm = new RandomTroopDistributionAlgorithm()

    def "should distribute troops randomly for #numberOfAllSoldiers soldiers and #troopTypes troops"() {
        when:
        def troops = algorithm.distribute(troopTypes, numberOfAllSoldiers)

        then:
        println troops
        troopTypes.each {
            assert troops[it] > 0
        }

        troops.values().sum() == numberOfAllSoldiers

        where:
        numberOfAllSoldiers | troopTypes
        100                 | [ARCHERS, SPEARMEN, SWORDSMEN]
        4                   | [ARCHERS, SPEARMEN, SWORDSMEN]
        3                   | [ARCHERS, SPEARMEN, SWORDSMEN]
        1                   | [ARCHERS]
        5                   | [ARCHERS]
    }

    def "should throw exception when there are less soldiers than troop types"() {
        when:
        algorithm.distribute([ARCHERS, SPEARMEN], 1)

        then:
        def exception = thrown(CannotDistributeTroopsException)
        exception.message == "Not enough soldiers"
    }

    def "should throw exception when troop types list is empty"() {
        when:
        algorithm.distribute(troopTypes, 10)

        then:
        def exception = thrown(CannotDistributeTroopsException)
        exception.message == "Troop types is empty"

        where:
        troopTypes << [[], null]
    }

}
