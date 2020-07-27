<img src="docs/images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://google.com/) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://google.com/) [![SonarQube Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://codefresh.io/steps/)

# Domain Service Reference Implementation

## Table of Contents

1. [Introduction](#1.-Introduction)
2. [Pre-requisites](#2.-Prerequisites)
3. [Environment Variables](#3.-Environment-Variables)
4. [Consumed Services](#4.-Consumed-Services)
5. [Event Produced & Consumed](#5.Events-Produced-And-Events-Consumed)
6. [Logging](#6.-Logging)
7. [Health Checks](#7.-Health-Checks)
8. [Build & Deployment](#8.-Build-And-Deployment)
9. [Testing Instructions](#9.-Testing-Instructions)
10. [Design Details](#10.-Design-Details)
11. [Support](#11.-Support)
12. [References](#12.-References)

## 1. Introduction

There are [three different types of microservices defined for Wawa](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/550633706/ABB+-+Microservices). This is a reference implementation of [Wawa Architecture defined business microservice](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/586843021/ABB+-+Business+Service) to achieve standardization and reduce duplication of effort.

This implementation considers Aggregate as an entity which could be replaced by the business entity intended for development. For example, there could be a order service which will act as a business service for order entity.

The domain service currently performs the following tasks:
1. Perform CRUD operations for the business entity using MongoDB or Postgres.
2. Publish events for CRUD operations of the entity using Spring Cloud Stream.
3. Provides a client for the exposed API end points of the domain service using Rest Template.

The microservice consists of the following modules:
* api - This module contains the exposed end points for the microservice.
* app - This module is used by Spring Boot to package everything as a deployable container.
* client - This module provides the client for consumers of the domain microservice.
* db - This module provides the dependency for MongoDB & Postgres.
* domain - This module contains the domain logic for the entity.
* event - This module provides the avro schema for the domain entities.
* postman - This module contains the postman collection which can be used to invoke the application flows. 

Also, the module makes use of spring factories to define the configurations. Example:
```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.wawa.platform.reference.api.ReferenceApiAutoConfiguration
```

### Design References
* [Component Design](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/586843021/ABB+-+Business+Service)

### Outstanding work to be done
* Add unit tests
* Add integration tests
* Add performance tests
* Extend the service for pagination and search
* Extend the service to use custom event bindings

## 2. Prerequisites

### Tools / Software

* [Java Build System](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328830959/Java)
* [Approved IDE](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/329352164/IDE)
* [Local Integrated Environment](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/447155015/Local+Docker+Desktop+Kubernetes+Istio+Kafka+Mongo+Development)

### Wawa Build Time Dependencies

| Project Name         | Version       |  Project URL  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
|  Core APAAS API Starter          |    0.0.1-SNAPSHOT        | [core-apaas-api-starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-api-starter) |
|  Core APAAS Event Publisher Starter          |    0.0.1-SNAPSHOT        | [core-apaas-event-publisher-starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-event-publisher-starter) |
|  Core APAAS Event Subscriber Starter          |    0.0.1-SNAPSHOT        | [core-apaas-event-publisher-starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-event-subscriber-starter) |

### Infrastructure

|Software              | Version       | Comment(s)  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
|  Database XX         |    XX+        |    Database server |
|  Message Bus XX      |    XX+        |    Message bus for inter service communication |

## 3. Environment Variables

|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|      
|  SERVICE_BASE_URL    |    Env        |    Build & Runtime       |  Integration Platform    |           |  Scope of this variable changes at run time|
 |  BUILD_NUMBER           |    Env        |    Build & Runtime       |  Integration Platform    |           |  It is pr_pull_number |         |  BUILD_HASH               |    Env        |    Build & Runtime       |  Integration Platform    |           |  It is github hash    |  
  |  APP_VERSION           |    Env        |    Build & Runtime       |  Application Developer   |           |  The app_version comes from              the helm chart.|
 |   GITHUB_TOKEN          |    Env        |    Build             |  Integration Platform    |This variable allows downloading npm packages published to the GitHub NPM Registry.   |  To be renamed to GIT_PACKAGE_MANAGER_TOKEN   |
|ENABLE_BUILD_DETAILS|Env| Build & Runtime|Application Developer|Control visibility of build and version number in UI application expected value:- true : to show details false : to hide details        |  Yet to be created. It will come from helm chart.|

## 4. Consumed Services
| Service             | Discovery Address       |   
|:--------------------|:------------------------|   
|  Service XX         |  \<Discovery Address>  |
|  Service XX         |  \<Discovery Address>  |

*Discovery address is the name in the Istio service mesh that is used to access a downstream service*

## 5. Events Produced And Events Consumed
| Event               |  Event Schema          |  Description           |
|:--------------------|------------------------|------------------------|
|  Service XX         | [SchemaA](schemas/schema.avro)  | BLAH  |
|  Service XX         | [SchemaA](schemas/schema.avro)  | BLAH  |

## 6. Logging

 This section should have critical logging messages that can be used to understand the health of this component or aid in the debugging of the component

*[Logging Standard](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/337412190/ST9.1-+Logging+Standard)*

## 7. Health Checks
| Endpoint             | Path               |   Content     |
|:--------------------|:--------------------|---------------|   
|  Endpoint Path      |  /healthz           |   OK          |

*Endpoints and the decoder for the current state of the service and any dependent components*

## 8. Build And Deployment
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

## 9. Testing Instructions 
### Unit test cases
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_     that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

```
mvn clean test
```

## 10. Design Details

### Entity Relationship Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/DeviPriyaRajeswariKotagiri/Testing/master/docs/class-diagram-01.puml)

### Entity State Machine Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/DeviPriyaRajeswariKotagiri/Testing/master/docs/statediagram.puml)

### Dependent Downstream Services
Describe the dependent services in your application.

### Application contains 4 configuration files in reference-domain module

* JpaConfiguration - For managing the JPA configuration
* MongoConfiguration - For managing the MongoDB configuration
* ReferenceDomainAutoConfiguration - For managing the common application configuration
* SecretsConfiguration - For managing the secrets configuration. Developer must create blank “secrets.properties” file in “c:\\Temp” folder.

###  Application Profiling

Application Environment property to specify which profiles are active. You can specify the property in any of the usual ways, for example you could include it in your application.properties. Here you can use mongodb or jpa. To run application with MongoDB, we need to put active profiles as "mongodb" in the reference-app-> application.properties file. If we need to work with Postgres DB then we need need to put active profiles as "jpa" in the reference-app-> application.properties file.

###  Code walk through

* The owner of the domain microservice is responsible for providing a client for their consumers as an independent module. This module also contains the VO objects used for the entity while communicating through client.
Reference for create aggregate API client call:

```java
public class ReferenceApiClient {

    public String createAggregate(String aggregateId, String aggregateName) {
        template.postForObject(
                "/aggregate/{aggregateId}/create/{aggregateName}",
                null,
                Object.class,
                aggregateId,
                aggregateName
        );
        return aggregateId;
    }

}
```

* The api module exposes the web logic with the API end points for the domain service. The classes call the command handlers in the domain module.
Reference for create aggregate API:

```java
@RestController
public class CreateAggregateApi {

    @PostMapping("/aggregate/{aggregateId}/create/{aggregateName}")
    public void createAggregate(@PathVariable String aggregateId,
                                      @PathVariable String aggregateName) {
        handler.createAggregate(aggregateId, aggregateName);
    }
}
```

* The domain module implements command design pattern and calls the respective handlers directed by api module. The handler then performs the CRUD operation on the entity.
Reference for create aggregate request:

```java
@Component
public class CreateAggregateCommandHandler {

  @Transactional
  @EventPublisher(keyExpression = "aggregateId")
  public AggregateCreatedEvent createAggregate(String aggregateId, String aggregateName) {
    return Optional
        .of(new Aggregate(aggregateId, aggregateName))
        .map(repository::save)
        .map(a -> AggregateCreatedEvent.newBuilder()
            .setAggregateId(aggregateId)
            .setAggregateName(aggregateName)
            .build())
        .orElseThrow();
  }

}
```

* The handler makes use of the methods exposed by CrudRepository to connect with MongoDB or Postgres and execute the queries:

```java
public interface AggregateRepository extends CrudRepository<Aggregate, String> {
}
```

* The handler methods perform the CRUD operation, maps the response to the avro created events through events module.
This avro object is sent on the Kafka topics through the use of EventPublisher custom annotation.
The current implementation uses the default output topic provided by Spring Cloud stream to send the messages.
This is leveraged through the event publisher starter. For more details about publishing events, refer to the starter documentation.

* The events module contain the avsc files based on the entity objects defined for the business.
These files generate class files at compile time using the following plugin:

```xml
<plugin>
    <groupId>org.apache.avro</groupId>
    <artifactId>avro-maven-plugin</artifactId>
    <version>${avro.version}</version>
    <executions>
        <execution>
            <phase>generate-sources</phase>
            <goals>
                <goal>schema</goal>
                <goal>protocol</goal>
                <goal>idl-protocol</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

* The generated class files are referenced by the domain module to send the events on the topic.


[Please refer SBB for more details on JPA reference implementation as follow:](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/804096109/SBB+-+JPA+reference+implementation+for+Postgres)
1. Run Application on IDE or local docker kubernetes or IP environments.
2. How to work Application with mongodb or PostgreSQL.

## 11. Support

### Deployment Status
One of the ways to check Deployment status is via CodeFresh. You can use Codefresh to deploy docker images directly to the Kubernetes cluster. You can watch the status of the deployment right from the Codefresh UI.
   
Please check references for more information on how to check the deployment status. [Deployment Status on  Codefresh](https://codefresh.io/docs/docs/getting-started/deployment-to-kubernetes-quick-start-guide/)
   
   
### How to view Health Statistics
One of the way to view Health Statistics of your application is by adding Spring Boot Actuator module ,it helps you monitor and manage your Spring Boot application by providing production-ready features like health check-up, auditing, metrics gathering, HTTP tracing etc. Please check references for more information .[How to view Health statistics of a Microservice ](https://www.callicoder.com/spring-boot-actuator/)
  
  
### How to view Logs
You can view logs for a Microservice using Kuberenetes,Amazon S3,Splunk,WinScp etc. Please check references for more information .[View logs on Kubernetes](https://www.sumologic.com/blog/kubectl-logs/)

### Supporting Team(s)

<ins>Engineering Team 2</ins> is the owner of this Reference Implementation.
   
### FAQ

[FAQ]("https://google.com/)
   
## 12. References
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
