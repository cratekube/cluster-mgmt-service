# Cluster Management Service Design Requirements
## Introduction  
The following requirements are intended to provide guidance and structure for 
implementing a Cluster Management Service. Each requirement has been identified 
as an essential part of the architecture and must be incorporated to maximize 
value to administrators and customers.

## Scope  
These requirements are scoped to encompass both business and technical 
requirements for a Cluster Management Service.  

## Requirements

### Provision Kubernetes clusters
![Generic badge](https://img.shields.io/badge/BUSINESS-MVP-GREEN.svg)  
As a user, I want my cluster to be manageable, so that my cluster 
can be created and configured, because without the ability to manage 
my cluster no changes can be made after it is created.

1.  #### Leverage RKE for direct cluster creation
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-MVP-GREEN.svg)  
    As a user, I want the Cluster Management Service to leverage RKE for direct cluster creation, 
    so that direct cluster creation is reliable, 
    because RKE makes provisioning clusters easily repeatable.  
    - ##### Persistence of RKE state
      ![Generic badge](https://img.shields.io/badge/TECHNICAL-MVP-GREEN.svg)  
      As a user I want the Cluster Management Service to persist RKE state, so that cluster 
      operations can be managed, because without persisting RKE state the cluster will be 
      inaccessible after provisioning. 
      
2.  #### Hosted cluster creation  
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-POSTMVP-YELLOW.svg) 

### Configure Kubernetes clusters  
![Generic badge](https://img.shields.io/badge/BUSINESS-MVP-GREEN.svg)  
As a user I want the Cluster Management Service to configure Kubernetes clusters, 
so that my Kubernetes cluster is ready for use, 
because an non configured Kubernetes cluster is unusable.  

### Tear down provisioned Kubernetes clusters  
![Generic badge](https://img.shields.io/badge/BUSINESS-MVP-GREEN.svg)  
As a user, I want the Cluster Management Service to leverage RKE for direct cluster tear down, 
so that direct cluster tear down is reliable, 
because RKE makes tearing down clusters easily repeatable.  

1.  #### Leverage RKE for direct cluster tear down
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-MVP-GREEN.svg)  
    As a user, I want the Cluster Management Service to leverage RKE for direct cluster tear down, 
    so that direct cluster tear down is reliable, 
    because RKE makes tearing down clusters easily repeatable.
    
2.  #### Hosted cluster tear down  
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-POSTMVP-YELLOW.svg) 
    
### Async for long running tasks  
![Generic badge](https://img.shields.io/badge/TECHNICAL-MVP-GREEN.svg)  
As a user, I want long running tasks to be handled asynchronously, 
so that cloud resources have enough time to be created, 
because creating cloud resources could take a long time and clients will timeout waiting for a synchronous response.  

## Security  
![Generic badge](https://img.shields.io/badge/BUSINESS-MVP-GREEN.svg)  
As a user, I want the Cluster Management Service to be secure, 
so that my resources are protected, 
because without security resources may be manipulated by unauthorized users.   

1.  ### token_authc and token_authz  
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-MVP-GREEN.svg)  
    As a user, I want token authentication and authorization implemented at runtime, 
    so that REST resources are protected, 
    because without security resources may be manipulated by unauthorized users.

### Monitor Kubernetes clusters  
![Generic badge](https://img.shields.io/badge/BUSINESS-POSTMVP-YELLOW.svg)  

### Kubernetes hardening
![Generic badge](https://img.shields.io/badge/BUSINESS-POSTMVP-YELLOW.svg)  

1.  #### Pod security policies  
    ![Generic badge](https://img.shields.io/badge/TECHNICAL-POSTMVP-YELLOW.svg)   
    
--- 

    
        
