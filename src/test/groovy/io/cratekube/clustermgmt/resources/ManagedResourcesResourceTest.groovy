package io.cratekube.clustermgmt.resources

import io.cratekube.clustermgmt.api.ManagedResourcesApi
import org.valid4j.errors.RequireViolation
import spock.lang.Specification
import spock.lang.Subject

class ManagedResourcesResourceTest extends Specification {
  @Subject ManagedResourcesResource subject
  ManagedResourcesApi resourcesApi

  def setup() {
    resourcesApi = Mock(ManagedResourcesApi)
    subject = new ManagedResourcesResource(resourcesApi)
  }

  def 'ManagedResourcesResource requires valid params'() {
    when:
    new ManagedResourcesResource(null)

    then:
    thrown RequireViolation
  }

  def 'CreateManagedService requires valid params'() {
    when:
    subject.createManagedService(env, cluster, req)

    then:
    thrown RequireViolation

    where:
    env   | cluster   | req
    null  | null      | null
    ''    | null      | null
    'env' | null      | null
    'env' | ''        | null
    'env' | 'cluster' | null
  }

  def 'DeleteManagedService requires valid params'() {
    when:
    subject.deleteManagedService(env, cluster, service)

    then:
    thrown RequireViolation

    where:
    env   | cluster   | service
    null  | null      | null
    ''    | null      | null
    'env' | null      | null
    'env' | ''        | null
    'env' | 'cluster' | null
    'env' | 'cluster' | ''
  }

  def 'GetManagedService requires valid params'() {
    when:
    subject.getManagedService(env, cluster, service)

    then:
    thrown RequireViolation

    where:
    env   | cluster   | service
    null  | null      | null
    ''    | null      | null
    'env' | null      | null
    'env' | ''        | null
    'env' | 'cluster' | null
    'env' | 'cluster' | ''
  }

  def 'GetManagedServices requires valid params'() {
    when:
    subject.getManagedServices(env, cluster)

    then:
    thrown RequireViolation

    where:
    env   | cluster
    null  | null
    ''    | null
    'env' | null
    'env' | ''
  }
}
