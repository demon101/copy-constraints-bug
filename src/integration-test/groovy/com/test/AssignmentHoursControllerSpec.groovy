package com.test

import copy.bug.Application
import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Integration
@Stepwise
@Rollback
class AssignmentHoursControllerSpec extends Specification {

    @Shared
    def restClient
    def setupSpec() {
        restClient = new RestBuilder()

    }

    def "creating assignment hours"() {
        when:
        def resp = restClient.post("http://localhost:${Application.serverPort}/api")
        then:
        resp.status == 204
    }
}
