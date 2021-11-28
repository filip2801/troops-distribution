package com.filip2801.goodgame.troopsdistribution.web

import com.filip2801.goodgame.troopsdistribution.domain.TroopType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TroopDistributionControllerTest extends Specification {

    @Autowired
    RestTemplate restTemplate

    @LocalServerPort
    int port
    @Value('${server.servlet.context-path:/}')
    String contextPath

    def "should distribute troops"() {
        given:
        def numberOfSoldiers = 1000000
        def requestPayload = [numberOfSoldiers: numberOfSoldiers]

        when:
        def response = restTemplate.postForEntity(getBaseUrl(), requestPayload, TroopDistributionResource)

        then:
        response.statusCode == HttpStatus.OK

        TroopType.ALL.forEach {
            assert response.body.troops[it] > 0
        }
        response.body.troops.values().sum() == numberOfSoldiers
    }

    def "should get 400 when there is enough soldiers to distribute"() {
        given:
        def numberOfSoldiers = 2
        def requestPayload = [numberOfSoldiers: numberOfSoldiers]

        when:
        restTemplate.postForEntity(getBaseUrl(), requestPayload, TroopDistributionResource)

        then:
        thrown(HttpClientErrorException.BadRequest)
    }

    private String getBaseUrl() {
        "http://localhost:${port}${contextPath}/troop-distributions"
    }

}
