package io.cratekube.clustermgmt.resources

import io.cratekube.clustermgmt.api.ClusterApi
import org.valid4j.errors.RequireViolation
import spock.lang.Specification
import spock.lang.Subject

class ClusterResourceSpec extends Specification {
  @Subject ClusterResource resource
  ClusterApi clusters

  def setup() {
    clusters = Mock(ClusterApi)
    resource = new ClusterResource(clusters)
  }

  def 'should require valid constructor parameters'() {
    when:
    new ClusterResource(null)

    then:
    thrown RequireViolation
  }
}
