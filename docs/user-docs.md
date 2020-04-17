[![License](http://img.shields.io/badge/license-apache%202.0-yellow)](http://choosealicense.com/licenses/apache-2.0/)
[![Sponsored By Cisco](https://img.shields.io/badge/sponsored%20by-Cisco-blue)](https://www.cisco.com/c/en/us/solutions/cloud/multicloud-solutions.html)
[![Coded with Groovy](https://img.shields.io/badge/language-Groovy-green)](https://github.com/apache/groovy)
[![12 Factor App](https://img.shields.io/badge/app-12--factor-yellow)](https://12factor.net/)
[![Shipped with Docker](https://img.shields.io/badge/shipped%20with-docker%2019.03.8-blue)](https://github.com/moby/moby)


## Introduction
This **_cluster management service_** is part of an [MVaP architecture](https://github.com/cratekube/cratekube/blob/master/docs/Architecture.md) that manages Kubernetes cluster creation and initial configuration, deletion and monitoring. The Cluster Management Service will provide everything needed for creating and monitoring a Kubernetes cluster and configuring it post-bootstrap for a customer.

## What does this service do?
This service manages Kubernetes cluster creation and initial configuration, deletion and monitoring. Creation of Kubernetes cluster becomes hassle free with the use of this service. After deploying this service, the APIs can be used to easily create or delete clusters, add or delete resources. Also, there is an API to get the customer kubeconfig, using which, the deployments in the cluster can be managed. The detailed architecture of the service can be found [here](https://github.com/cratekube/cluster-mgmt-service/blob/master/docs/architecture.md).



## How this service can be used
To run this service locally, one may simply fork this repo and clone down to your local machine:
- Visit the [cluster-mgmt-service](https://github.com/cratekube/cluster-mgmt-service)
- Press the `fork` button at the top-right of the page
- Clone down the repo locally:
```html
git clone git@github.com:<yourUsername>/cluster-mgmt-service.git
```
If you were to use this service on a host, you could perform similar steps.  In both cases, you will want to be sure and persist any state data in a volume.  See below for more information.

### Building locally with Docker
We strive to have our builds repeatable across development environments so we also provide a Docker build to generate 
the Dropwizard application container.  The examples below should be executed from the root of the project.

#### Configuration Options
##### First, configure your `/app.yml` file with the following values:

  -  api-keys:
	  - name: api-admin
	  - key:  ```<INSERT API KEY HERE>```
  -  configLocation: ```<path to location where config files need to be stored>```
Other configuration options are also available in the `/app.yml` file. Environment variables such as port values or sshKeyPath can be configured as applicable.
      
	  
##### Run the base docker build:
```bash
docker build -t cluster-mgmt-service:local --target build .
```
Note: This requires docker 19.03.x or above.  Docker 18.09 will throw errors for mount points and the `--target` flag.

##### Build the package target:
```bash
docker build -t cluster-mgmt-service:local --target package .
```
### Running locally with Docker
##### Run the docker application locally on port 8080:
```bash
docker run -p 8080:9000  -d cluster-mgmt-service:local /entrypoint.sh server
```
Notes: 
- 9000 is the application connector port which could be changed in the `/app.yml` file.  
- Bind mounts can be used to persist container state. This service uses a directory to store and manage the state of Clusters and Managed Resources for an environment. This directory is configurable through the environment variable config_location and should be treated as persistent storage as it is the source of truth for Clusters and Managed Resources.

##### Fire up the Swagger specification by visiting the following URL in a browser:
```bash
http://localhost:8080/swagger
```

### Using the API locally
The API has endpoints that allow you to create and manage clusters and resources in it. The api-key has to be passed as an authorization token along with the request header for POST requests.

The resulting operations exist as REST endpoints, which you can simply hit in your browser or with a tool such as [Postman](https://www.postman.com/downloads/).

| HTTP Verb | Endpoint | Payload | Function |
| --- | --- | --- | --- |  
| POST | /environment/{envNamw}/cluster |<code>{"clusterName": "string",\n"hostnames": ["string"]}</code>  | Create a new cluster by specifying its name and hosts |
| GET | /environment/{envName}/cluster/{clusterName} | None  | Get details about a cluster such as its configuration and status of nodes |
| DELETE |/environment/{envName}/cluster/{clusterName}  | None | Delete a specific cluster by its name  |
| GET | /environment/{envName}/cluster/{clusterName}/kubeconfig/customer | None | Get customer kubeconfig for a cluster by its name |
| GET | /environment/{envName}/cluster/{clusterName}/resource | None | Get status of all resources in a cluster by its name |
| POST | /environment/{envName}/cluster/{clusterName}/resource |<code>{"name": "string","config": "string","status": "NOT_STARTED"}</code> | Create a new deployment by cluster name by speciifying the configuration in the payload |
| GET | /environment/{envName}/cluster/{clusterName}/resource/{resourceName} | None | Get the status of a resource or deployment by its name |
| DELETE | /environment/{envName}/cluster/{clusterName}/resource/{resourceName} | None | Delete a resource or deployment by its name

### Using the API client
This application generates a client for the Dropwizard application by using the swagger specification.  The maven asset
is available in JCenter, make sure you include the JCenter repository (https://jcenter.bintray.com/) when pulling this
client.  To use the client provide the following dependency in your project:

Gradle:
```groovy
implementation 'io.cratekube:cluster-mgmt-service:1.0.0'
``` 

Maven:
```xml
<dependency>
  <groupId>io.cratekube</groupId>
  <artifactId>cluster-mgmt-service</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Releases
The [MVaP architecture](https://github.com/cratekube/cratekube/blob/master/docs/Architecture.md) for CrateKube specifies that the [LifeCycle Service Atom Feeds](https://github.com/cratekube/lifecycle-service/blob/7d115fa0b2c5e8ebb0f5e7d91425498aec02d91c/src/test/resources/testapp.yml) are responsible for delegating upgrades to services.  The user can decide when to upgrade by hitting an API call, and the `LifeCycle Service` will handle those upgrades.  This service bootstraps and initializes all CrateKube components for the Kubernetes cluster.

### Manual upgrades from released code
If you wanted to upgrade services manually because you are using a single microservice, our release publications are stored in the form of atom feeds:

| Service | Atom Feed |
| --- | --- |
| cluster-mgmt-service | https://github.com/cratekube/cluster-mgmt-service/releases.atom |
| cloud-mgmt-service | https://github.com/cratekube/cloud-mgmt-service/releases.atom |
| lifecycle-service | https://github.com/cratekube/lifecycle-service/releases.atom |

Service upgrades can be performed by pulling the latest from our upstream master to your fork, and merging in those changes locally.  Then follow the steps listed in "Building locally with Docker" section of this document.