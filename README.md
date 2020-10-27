<img src="docs/images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://google.com/) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://google.com/) [![SonarQube Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://codefresh.io/steps/)

# Name of the Component

## Table of Contents

1. [Introduction](#1-Introduction)
2. [Prerequisites](#2-Prerequisites)
3. [Environment Variables](#3-environment-variables)
4. [Consumed Services](#4-consumed-services)
5. [Logging](#6-logging)
6. [Health Checks](#7-health-checks)
7. [Build & Deployment](#8-build-and-deployment)
8. [Testing Instructions](#9-testing-instructions)

## 1. Introduction

Document README for orch-build-instruction-service.
It contains the build instruction orchestrator microservice which is responsible for orchestration functions related to build instruction.


### See Also
* [Design Reference](docs/DESIGN.md)
* [Support Reference](docs/SUPPORT.md)

### Supporting Team(s)
* <ins>Feature Team5</ins> is the owner of Creating the Standard for README.md.

## 2. Prerequisites
### Tools/Software

* [Java Build System](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328830959/Java)
* [Approved IDE](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/329352164/IDE)
* [Local Integrated Environment](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/447155015/Local+Docker+Desktop+Kubernetes+Istio+Kafka+Mongo+Development)
    
### Wawa Build Time Dependencies

| Project Name         | Version       |  Project URL  |   
|:---------------------|:--------------|:--------------------------------------------------------|      
| api-commerce-order          |  0.0.1-SNAPSHOT      | [ api-commerce-order  ](https://github.com/wawa/api-commerce-order) |
| api-catalog-sales-client       |  0.0.1-SNAPSHOT    | [api-catalog-sales-client](https://github.com/wawa/api-catalog-sales) |
| core-apaas-app-starters       |  0.0.1-SNAPSHOT     | [core-apaas-app-starters](https://github.com/wawa/core-apaas-app-starters/tree/master/starters) |



## 3. Environment Variables

|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|      
|  API_COMMERCE_ORDER_API_BASE_URL    |    Local        |    Build & Runtime       |  Integration Platform    |           |  Scope of this variable changes at run time|


## 4. Consumed Services
| Service             | Discovery Address       |   
|:--------------------|:------------------------|   
|  api-commerce-order           |  [api-commerce-order](https://github.com/wawa/api-commerce-order) |
|  api-catalog-sales-client       | [api-catalog-sales-client](https://github.com/wawa/api-catalog-sales) |

*Discovery address is the name in the Istio service mesh that is used to access a downstream service*


## 5. Logging

 This section should have critical logging messages that can be used to understand the health of this component or aid in the debugging of the component

*[Logging Standard](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/337412190/ST9.1-+Logging+Standard)*


## 6. Health Checks
| Endpoint             | Path               |   Content     |
|:--------------------|:--------------------|---------------|   
|  http://localhost:<port>/api/commerce/buildinstruction/actuator/health      |  /health         |   OK          |
|  http://localhost:<port>/api/commerce/buildinstruction/actuator/info   |  /info          |   OK          |




## 7. Build And Deployment
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
Docker image creation:

* Local Containerized Environment Creation:
```
 docker build -t orch-build-instruction-service:v1 -f Dockerfile-local .
```
* Containerized Environment Creation:
```
docker build . -t orch-build-instruction-service:v1 -f Dockerfile
```

Install on K8S:
```
for Helm version 2.x
-----------------
helm install --name orch-build-instruction-service ./orch-build-instruction-service --values ./orch-build-instruction-service/values-local.yaml  --namespace commerce

For Helm version 3.x
-----------------
helm install orch-build-instruction-service ./orch-build-instruction-service --values ./orch-build-instruction-service/values-local.yaml  --namespace commerce
```

Install on K8S Dev:
```
helm install --name orch-build-instruction-service ./orch-build-instruction-service --values ./orch-build-instruction-service/values-ip-app-dev-01-us-east-1.yaml --namespace commerce
```


### Run In Local Kubernetes
```bash
export $appname=myapp
helm upgrade $appname . --install --recreate-pods --namespace $namespace --version $appversion --values $values
```

## 8. Testing Instructions 
### Unit test cases
There are multiple unit test cases written to cover the different components of the application.

```
mvn clean test
```

