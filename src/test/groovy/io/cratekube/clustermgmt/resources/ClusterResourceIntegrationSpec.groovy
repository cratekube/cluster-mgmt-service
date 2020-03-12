package io.cratekube.clustermgmt.resources

import io.cratekube.clustermgmt.BaseIntegrationSpec

import static org.hamcrest.Matchers.notNullValue
import static spock.util.matcher.HamcrestSupport.expect

class ClusterResourceIntegrationSpec extends BaseIntegrationSpec {

  def 'should get response when executing GET'() {
    when:
    def result = baseRequest('').get()

    then:
    expect result, notNullValue()
  }
}
