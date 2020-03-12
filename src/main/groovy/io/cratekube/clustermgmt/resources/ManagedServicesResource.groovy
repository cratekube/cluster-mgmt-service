package io.cratekube.clustermgmt.resources

import groovy.util.logging.Slf4j
import io.cratekube.clustermgmt.api.ManagedResourcesApi
import io.cratekube.clustermgmt.model.ManagedResource
import io.swagger.annotations.Api

import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

import static org.hamcrest.core.IsNull.notNullValue
import static org.valid4j.Assertive.require
import static org.valid4j.matchers.ArgumentMatchers.notEmptyString

@Api
@Path('environment/{envName}/cluster/{clusterName}/service')
@Produces('application/json')
@Consumes('application/json')
@Slf4j
class ManagedServicesResource {
  ManagedResourcesApi services

  @Inject
  ManagedServicesResource(ManagedResourcesApi services) {
    this.services = require services, notNullValue()
  }
  /**
   * Deploys a managed service.
   * <p>If the requested managed service for the cluster is being created a 201 response
   * will be returned with the location header set to the resource.</p>
   * <p>If the cluster does not exist a 404 response will be returned.</p>
   * <p>If a managed service is being created or already exists a 409 response will be returned.</p>
   *
   * @param envName {@code non-empty} environment name
   * @param clusterName {@code non-empty} cluster name
   * @param req {@code non-null} managed service request for the cluster
   * @return 201 response and set location header when a cluster creation is initiated, a 404 if the cluster does not exist or a 409 response if the managed service exists already or creation is in progress
   * @throws io.cratekube.clustermgmt.api.exception.InProgressException if the managed service creation is in progress
   * @throws io.cratekube.clustermgmt.api.exception.AlreadyExistsException if the managed service already exists
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if a cluster does not exist
   */
  @POST
  Response createManagedService(
    @PathParam('envName') String envName,
    @PathParam('clusterName') String clusterName,
    @Valid ManagedResource req
  ) {
    require envName, notEmptyString()
    require clusterName, notEmptyString()
    require req, notNullValue()

    log.debug 'action [create-managed-service]'
    return null
  }

  /**
   * Deletes a managed service.
   * <p>If the requested managed service for the cluster is being deleted a 202 response will be returned.</p>
   *
   * @param envName {@code non-empty} environment name
   * @param clusterName {@code non-empty} cluster name
   * @param serviceName {@code non-empty} managed service name
   * @return a 202 response and set location header when a managed service deletion is initiated, a 404 if the cluster or managed service does not exist or a 409 response if the managed service creation is in progress
   * @throws io.cratekube.clustermgmt.api.exception.InProgressException if the managed service creation is in progress
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if managed service does not exist
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if a cluster does not exist
   */
  @DELETE
  @Path('{serviceName}')
  Response deleteManagedService(
    @PathParam('envName') String envName,
    @PathParam('clusterName') String clusterName,
    @PathParam('serviceName') String serviceName
  ) {
    require envName, notEmptyString()
    require clusterName, notEmptyString()
    require serviceName, notEmptyString()

    log.debug 'action [delete-managed-service]'
    return null
  }

  /**
   * Returns the managed service with state.
   * <p>If the cluster or service cannot be found a 404 NOT FOUND response will be returned.</p>
   *
   * @param envName {@code non-empty} environment name
   * @param clusterName {@code non-empty} cluster name
   * @param serviceName {@code non-empty} managed service name
   * @return the managed service
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if no cluster exists
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if managed service does not exist
   */
  @GET
  @Path('{serviceName}')
  ManagedResource getManagedService(
    @PathParam('envName') String envName,
    @PathParam('clusterName') String clusterName,
    @PathParam('serviceName') String serviceName
  ) {
    require envName, notEmptyString()
    require clusterName, notEmptyString()
    require serviceName, notEmptyString()

    log.debug 'action [get-managed-service]'
    return null
  }

  /**
   * Returns the status for all managed services in a cluster.
   * <p>If the cluster cannot be found a 404 NOT FOUND response will be returned.</p>
   *
   * @param envName {@code non-empty} environment name
   * @param clusterName {@code not-empty} cluster name
   * @return all managed services for a cluster in an environment
   * @throws io.cratekube.clustermgmt.api.exception.NotFoundException if no cluster exists
   */
  @GET
  List<ManagedResource> getManagedServices(
    @PathParam('envName') String envName,
    @PathParam('clusterName') String clusterName
  ) {
    require envName, notEmptyString()
    require clusterName, notEmptyString()

    log.debug 'action [get-managed-services]'
    return []
  }

}
