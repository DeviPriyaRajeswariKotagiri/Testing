<img src="docs/images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://google.com/) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://google.com/) [![SonarQube Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://google.com/)

# Name of the Component

## Table of Contents

1. [Introduction](#Introduction)
2. [Prerequisites](#Prerequisites)
3. [Dependencies](#Dependencies)
4. [Configuration](#Configuration-Build-And-Runtime-for-Local-LIE-IPDev-IPTest-IPProd)
5. [Build And Deployment](#Build-And-Deployment)
6. [Design Details](#Design-Details)
7. [Support](#Support)
8. [References](#References)
9. [FAQ's](#FAQ's)
10. [License](#license)

## Introduction

Provide Description of Component

## Design References
* [Component Design](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/803242274/Artifact+Management)

## Prerequisites
### <ins>Tools/Software</ins>

* [Java Build System](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328830959/Java)
* [Approved IDE](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/329352164/IDE)
* [Local Integrated Environment](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/447155015/Local+Docker+Desktop+Kubernetes+Istio+Kafka+Mongo+Development)
    
### <ins>Wawa Build Time Dependencies</ins>

| Project Name         | Version       |  Project URL  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
|  Starter XX          |    XX+        | [core-apaas-api-starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-api-starter) |
|  Starter XX          |    XX+        | [core-apaas-json-starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-json-starter) |

### <ins>Infrastructure</ins>

|Software              | Version       | Comment(s)  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
|  Database XX         |    XX+        |    Database server |
|  Message Bus XX      |    XX+        |    Message bus for inter service communication |

## Environment Variables

|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|      
|  SERVICE_BASE_URL    |    Env        |    Build & Runtime       |  Integration Platform    |           |  Scope of this variable changes at run time|
 |  BUILD_NUMBER           |    Env        |    Build & Runtime       |  Integration Platform    |           |  It is pr_pull_number |         |  BUILD_HASH               |    Env        |    Build & Runtime       |  Integration Platform    |           |  It is github hash    |  
  |  APP_VERSION           |    Env        |    Build & Runtime       |  Application Developer   |           |  The app_version comes from              the helm chart.|
 |   GITHUB_TOKEN          |    Env        |    Build             |  Integration Platform    |This variable allows downloading npm packages published to the GitHub NPM Registry.   |  To be renamed to GIT_PACKAGE_MANAGER_TOKEN   |
|ENABLE_BUILD_DETAILS|Env| Build & Runtime|Application Developer|Control visibility of build and version number in UI application expected value:- true : to show details false : to hide details        |  Yet to be created. It will come from helm chart.|

## Consumed Services
| Service             | Discovery Address       |   
|:--------------------|:------------------------|   
|  Service XX         |  \<Discovery Address>  |
|  Service XX         |  \<Discovery Address>  |

*Discovery address is the name in the Istio service mesh that is used to access a downstream service*

## Events Produced And Events Consumed
| Event               |  Event Schema          |  Description           |
|:--------------------|------------------------|------------------------|
|  Service XX         | [SchemaA](schemas/schema.avro)  | BLAH  |
|  Service XX         | [SchemaA](schemas/schema.avro)  | BLAH  |

## Logging

 This section should have critical logging messages that can be used to understand the health of this component or aid in the debugging of the component

*[Logging Standard](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/337412190/ST9.1-+Logging+Standard)*

## Health Checks
| Endpoint             | Path               |   Content     |
|:--------------------|:--------------------|---------------|   
|  Endpoint Path      |  /healthz           |   OK          |

*Endpoints and the decoder for the current state of the service and any dependent components*

## Build And Deployment
### Compilation
```bash
cd myapp
mvn clean package
```

### Run As Application
```bash
java -jar ./myapp.jar
```

### Build Container
```bash
docker build .
```

### Run In Local Kubernetes
```bash
export $appname=myapp
helm upgrade $appname . --install --recreate-pods --namespace $namespace --version $appversion --values $values
```

## Testing Instructions 
### Unit test cases
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_     that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

```
mvn clean test
```

## Design Details
### Entity Relationship Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/spiegel-im-spiegel/plantuml-sample/master/class-diagram-01.puml)

### Entity State Machine Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/spiegel-im-spiegel/plantuml-sample/master/class-diagram-01.puml)

### Dependent Downstream Services
Describe the dependent services in your application.

## Support

   ### i . Deployment status
   
   One of the way to check Deployment status is via CodeFresh.
   You can use Codefresh to deploy docker images directly to the Kubernetes cluster
   You can watch the status of the deployment right from the Codefresh UI.
   
   Please check references for more information on how to check the deployment status.
   [Deployment Status on  Codefresh](https://codefresh.io/docs/docs/getting-started/deployment-to-kubernetes-quick-start-guide/)
   
   
   ### ii. How to view Health statistics
  One of the way to view Health Statistics of your application is by adding Spring Boot Actuator module ,it helps you monitor and manage your Spring Boot application by           providing production-ready features like health check-up, auditing, metrics gathering,   HTTP tracing etc.
  Please check references for more information .[How to view Health statistics of a Microservice ](https://www.callicoder.com/spring-boot-actuator/)
  
  
   ### iii. How to view Logs
   You can view logs for a Microservice using Kuberenetes,Amazon S3,Splunk,WinScp etc.
   Please check references for more information .[View logs on Kubernetes](https://www.sumologic.com/blog/kubectl-logs/)

## Supporting Team(s)
 
* Engineering Team3
   
## FAQ's

[FAQ's]("https://google.com/)
   
## References
| Name |Link | Comments   | 
|:-----|:----|:-----------|
|Events Produced And Events Consumed| https://spring.io/projects/spring-kafka | |
|Dependencies|https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/762448353/Dependencies+on+EE+Team+s | |
|Check Deployment Status|https://www.namecheap.com/blog/visualize-your-deployment-status-with-jenkins/ |  |
|How to view Health statistics of a Microservice |https://www.callicoder.com/spring-boot-actuator/ |  |
|View logs on Kubernetes |https://www.sumologic.com/blog/kubectl-logs/|  |
| Amazon S3 Logs  |https://docs.datadoghq.com/integrations/amazon_s3/#enable-s3-access-logs |  |
|Deploying Microservice to AWS Cloud | https://aws.amazon.com/blogs/compute/deploying-java-microservices-on-amazon-ec2-container-service/  |   |
|Link(s) to SBBs| https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/586613993/P3%2B-%2BSolution%2BBuild%2BBlock%2BRegistry |   |
|Link(s) to ABBs| https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/508428401/Foundational+Architecture+Building+Blocks. |   |
|Link(s) to OAS on Developer Portal| https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/590742573/System+Developer+Portal+Design. |   |
|Link(s) to Developer On-boarding| https://wawaappdev.atlassian.net/wiki/spaces/MEET/pages/131137606/Developer+onboarding.  |   |
|Deploying a Microservice Via an automated CI/CD Pipeline| https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/659751676/SBB+-+BE+Deploy+Microservice |   |
|Deploying a Microservice to Docker Container| https://www.javainuse.com/devOps/docker/docker-jar |   |
|Deployment Status on  Codefresh| https://codefresh.io/docs/docs/getting-started/deployment-to-kubernetes-quick-start-guide/ |     |

