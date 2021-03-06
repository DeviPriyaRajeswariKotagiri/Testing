<img src="docs/images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://google.com/) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://google.com/) [![SonarQube Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://codefresh.io/steps/)

# Fulfillment Domain Service

## Table of Contents

1. [Introduction](#1-introduction)
2. [Pre-requisites](#2-prerequisites)
3. [Environment Variables](#3-environment-variables)
4. [Consumed Services](#4-consumed-services)
5. [Event Produced & Consumed](#5-events-produced-and-events-consumed)
6. [Logging](#6-logging)
7. [Health Checks](#7-health-checks)
8. [Build & Deployment](#8-build-and-deployment)
9. [Testing Instructions](#9-testing-instructions)

## 1. Introduction

There are [three different types of microservices defined for Wawa](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/550633706/ABB+-+Microservices). This is a reference implementation of [Wawa Architecture defined business microservice](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/586843021/ABB+-+Business+Service) to achieve standardization and reduce duplication of effort.

This implementation considers Build InstructionId as an entity which could be replaced by the business entity intended for development. For example, there could be a order service which will act as a business service for order entity.

The domain service currently performs the following tasks:
1. Publish events for CRUD operations of the entity using Spring Cloud Stream.
2. Provides a client for the exposed API end points of the domain service using Rest Template.

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
com.wawa.fulfillment.api.FulfillmentApiAutoConfiguration
```

### See Also
* [Design Reference](docs/DESIGN.md)
* [Support Reference](docs/SUPPORT.md)

### Supporting Team(s)
* <ins>Feature Team 5</ins> is the owner of this Implementation.

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
|  spring-boot-starter-parent  |  2.2.2.RELEASE   |   [spring-boot-starter-parent](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml)  |
|  spring-cloud-dependencies |  Hoxton.RELEASE |  [spring-boot-starter-data-mongodb](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml) |
| fulfillment-event |  0.0.1-SNAPSHOT     | [fulfillment-event](https://github.com/wawa/api-fulfillment-build/blob/master/db/pom.xml) |
| fulfillment-api |  0.0.1-SNAPSHOT   |  [fulfillment-api](https://github.com/wawa/api-fulfillment-build/blob/master/db/pom.xml)  |
| fulfillment-api-client |   0.0.1-SNAPSHOT  |  [fulfillment-api-client](https://github.com/wawa/api-fulfillment-build/blob/master/db/pom.xml)  |
| fulfillment-db  |  0.0.1-SNAPSHOT    |   [fulfillment-db ](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml)  | 
|  fulfillment-domain  |   0.0.1-SNAPSHOT     |   [fulfillment-domain](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml)  | 
|  fulfillment-exception |    0.0.1-SNAPSHOT      |   [fulfillment-exception](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml)  |
| avro-maven-plugin  |  1.9.2 |   [avro-maven-plugin](https://github.com/wawa/api-fulfillment-build/blob/master/pom.xml)  |
| Core APAAS API Starter |  0.0.1-SNAPSHOT |[ Core APAAS API Starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-api-starter)|
| Core APAAS Event Publisher Starter|  0.0.1-SNAPSHOT  |[Core APAAS Event Publisher Starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-event-publisher-starter)|
| Core APAAS Event Subscriber Starter |  0.0.1-SNAPSHOT  | [Core APAAS Event Subscriber Starter](https://github.com/wawa/core-apaas-app-starters/tree/master/core-apaas-event-subscriber-starter) |




### Infrastructure


|Software              | Version       | Comment(s)  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
| Docker Desktop | 2.2.0.0| Docker Desktop and enable Kubernetes|



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
| BuildInstructionCancelledEvent        | [BuildInstructionCancelledEvent ](https://github.com/wawa/api-fulfillment-build/blob/master/event/src/main/avro/buildinstruction-cancelled-event.avsc)  | Event schema for  BuildInstructionCancelledEvent |
|  BuildInstructionCreatedEvent        | [BuildInstructionCreatedEvent](https://github.com/wawa/api-fulfillment-build/blob/master/event/src/main/avro/buildinstruction-created-event.avsc)  | Event schema for  BuildInstructionCreatedEvent  |
|BuildInstructionNameUpdatedEvent  | [BuildInstructionNameUpdatedEvent](https://github.com/wawa/api-fulfillment-build/blob/master/event/src/main/avro/buildinstruction-name-updated-event.avsc) | Event schema for BuildInstructionNameUpdatedEvent |
|  SomeOtherBuildInstructionEvent|  [SomeOtherBuildInstructionEvent](https://github.com/wawa/api-fulfillment-build/blob/master/event/src/main/avro/some-other-buildinstruction-event.avsc) | Event schema for SomeOtherBuildInstructionEvent |


## 6. Logging
Java Logging API is provided by Simple Logging Facade(SLF4J) 
This section should have critical logging messages that can be used to understand the health of this component or aid in the debugging of the component

*[Logging Standard](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/337412190/ST9.1-+Logging+Standard)*

## 7. Health Checks
| Endpoint             | Path               |   Content     |
|:--------------------|:--------------------|---------------|   
|  Endpoint Path      |  /healthz           |   OK          |

*Endpoints and the decoder for the current state of the service and any dependent components*

## 8. Build And Deployment
### Compilation with junit test cases only
```bash
cd myapp
mvn clean package
```

### Compilation with contract test cases only
```bash
cd myapp
mvn clean package -Pcontract-tests -Dpact.provider.version=101 -Dpact.tag=dev -Dpact.provider.tag=dev -Dpact.verifier.publishResults=true -Dpact.broker.host=localhost -Dpact.broker.port=9292
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
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_     that combines all the test cases in a logical manner to create a complete suite.We can also use mocking frameworks like mockito for effective unit testing of JAVA applications. It can be run from command prompt using the following command -

Run all tests in a class
```
mvn clean test -Dtest=xxxxTest
```


Run an individual test
```
mvn clean test -Dtest=xxxxTest#testA
```
