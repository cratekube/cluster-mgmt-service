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

  def 'CreateManagedResource requires valid params'() {
    when:
    subject.createManagedResource(env, cluster, req)

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

  def 'DeleteManagedResource requires valid params'() {
    when:
    subject.deleteManagedResource(env, cluster, resource)

    then:
    thrown RequireViolation

    where:
    env   | cluster   | resource
    null  | null      | null
    ''    | null      | null
    'env' | null      | null
    'env' | ''        | null
    'env' | 'cluster' | null
    'env' | 'cluster' | ''
  }

  def 'GetManagedResource requires valid params'() {
    when:
    subject.getManagedResource(env, cluster, resource)

    then:
    thrown RequireViolation

    where:
    env   | cluster   | resource
    null  | null      | null
    ''    | null      | null
    'env' | null      | null
    'env' | ''        | null
    'env' | 'cluster' | null
    'env' | 'cluster' | ''
  }

  def 'GetManagedResources requires valid params'() {
    when:
    subject.getManagedResources(env, cluster)

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
