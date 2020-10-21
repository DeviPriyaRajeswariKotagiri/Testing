
# Component - Detailed Design

## Table of Contents
1. [UML Diagrams](#1-uml-diagrams)
2. [Dependent Downstream Services](#2-dependent-downstream-services)
3. [Understanding the Code](#3-understanding-the-code)
4. [References](#4-references)


## 1. UML Diagrams
### Entity Relationship Diagram

Not Applicable

### Entity State Machine Diagram

Not Applicable

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
The service currently performs the following tasks:
1. Interacts with sales order microservice to query the RMS BOM enriched sales order data.
2. Interacts with sales catalog microservice to query the category/product/option set data.

### API URIs

* Local environment: **api/v1/buildinstruction/orders/{orderid}**
* Containerized environment: **api/commerce/buildinstruction/v1/buildinstruction/orders/{orderid}**

### OpenAPI spec (OAS3)
* Local environment: **/swagger-ui/index.html?url=/api/api-docs/**
* Containerized environment: **/swagger-ui/index.html?url=/api/commerce/buildinstruction/api-docs/**           
         
         
## 4. References
| Link | Description | 
| :---- | :----------- |
| [SBB](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/1126793371/SBB+-+Static+Build+Instructions#5.3-Deployment-Diagram(s)) |  Confluence page|
