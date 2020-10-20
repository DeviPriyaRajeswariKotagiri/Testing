
# Component - Detailed Design

## Table of Contents
1. [UML Diagrams](#1-uml-diagrams)
2. [Dependent Downstream Services](#2-dependent-downstream-services)
3. [Understanding the Code](#3-understanding-the-code)
4. [References](#4-references)


## 1. UML Diagrams
### Entity Relationship Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/DeviPriyaRajeswariKotagiri/Testing/master/docs/puml/class-diagram-01.puml)

### Entity State Machine Diagram

![your-UML-diagram-name](https://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/DeviPriyaRajeswariKotagiri/Testing/master/docs/puml/state-diagram-01.puml)

## 2. Dependent Downstream Services
* api-commerce-order - Uses the client of Sales Order service
* api-catalog-sales-client - Uses the client of Sales Catalog service
* core-apaas-app-starters - For starters defined for WAWA

## 3. Understanding the Code
        
The microservice consists of the following modules:

* api - This module contains the exposed end points for the orchestrator microservice.
* app - Spring Boot uses this module to package everything as a deployable container.
* client - This module provides the client for consumers of the orchestrator microservice.
* postman - This module contains the postman collection which can be used to invoke the application flows.
* saga - This module contains the main flow control logic along with compensating actions if required.
           
         
         
## 4. References
| Link | Description | 
| :---- | :----------- |
| [SBB](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/1126793371/SBB+-+Static+Build+Instructions#5.3-Deployment-Diagram(s)) |  Confluence page|
