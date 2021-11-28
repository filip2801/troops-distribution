package com.filip2801.goodgame.troopsdistribution

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@SpringBootTest
class TroopsDistributionApplicationTests extends Specification {

	@Autowired
	WebApplicationContext context

	def "should start application"() {
		expect: 'application started'
		context != null
	}

}
