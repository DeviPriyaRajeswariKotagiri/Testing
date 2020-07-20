<img src="images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://travis-ci.org/openmrs/openmrs-core) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://coveralls.io/github/openmrs/openmrs-core?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://www.codacy.com/app/openmrs/openmrs-core?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=openmrs/openmrs-core&amp;utm_campaign=Badge_Grade)

# Anonymous Token Generator

## Table of Contents

1. [Introduction](#Introduction)
2. [Prerequisites](#prerequisites)
   1. [Tools/Software](#Tools/Software)
   2. [Infrastructure](#Infrastructure)
      1. [Local](#Local)
      2. [Cloud](#Cloud)
2. [Build And Deployment](#Build-And-Deployment)
   1. [Local Machine](#Local-Machine)
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
	2. [Local Integration Environment](#Local-Integration-Environment)
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
	3. [Integration Platform](#Integration-Platform)
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
3. [Design Details](#Design-Details)
	1. [UML Diagrams](#UML-Diagrams)
	2. [Events Produced And Events Consumed](#Events-Produced-And-Events-Consumed)
	3. [Dependent Downstream Services](#Dependent-Downstream-Services)
4. [Support](#Support)
   1. [Deployment status](#Deployment-status)
   2. [How to view Health statistics](#How-to-view-Health-statistics)
   3. [How to view Logs](#How-to-view-Health-statistics)
   4. [Owned by which Team?](#Owned-by-which-Team?)
5. [References](#References)
    1. [Links to Detailed Design](#Links-to-Detailed-Design)
    2. [Links to SBBs used](#Links-to-SBBs-used)
    3. [Links to ABBs used](#Links-to-ABBs-used)
    4. [Links to OAS on Developer Portal](#Links-to-OAS-on-Developer-Portal)
    5. [Links to On-boarding document](#Links-to-On-boarding-document)
6. [License](#license)

## Introduction
Anonymous Token Generator using Spring Security-To produce detailed design for creating, signing, validating and consuming JWT Tokens, so that Anonymous Customers can Order Online and/or Managing Orders, using web/mobile applications.
## Prerequisites
### Tools/Software
   #### Java

Install Java8 (https://www.oracle.com/java/technologies/java8.html).
If you want to build the master branch you will need a Java JDK of minimum version 8.

   #### Maven

Install the build tool [Maven](https://maven.apache.org/).

You need to ensure that Maven uses the Java JDK needed for the branch you want to build.

To do so execute

```bash
mvn -version
```

which will tell you what version Maven is using. Refer to the [Maven docs](https://maven.apache.org/configure.html) if you need to configure Maven.

   #### Git

Install the version control tool [git](https://github.com/wawa/) and clone this repository with

```bash
git clone  https://github.com/wawa/admin-toolstack-config.git
```

### Infrastructure
 - **Local**
      [ Application Infrastructure ](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/350554432/Application+Infrastructure)
 - **Cloud**
     A key component of the integration platform (IP) is the Amazon cloud (AWS).  Along with infrastructure as a service (IIS) the cloud platform maintains identity and access management (IAM) for their platform to ensure the services used are used in a secure fashion.
   [ Cloud Configuration ](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/325943364/Cloud+Configuration)
## Build And Deployment

### Local Machine

<details><summary>Local Machine:Build and Deployment</summary>
<p>

   #### a. **Dependencies** 
 
  Maven reads the parent POM from your local repository (or proxies like nexus) and creates an 'effective POM' by merging the information from parent and module POM.
   
  Details of Parent POM:
  org.springframework.boot.spring-boot-starter-parent
  
   
		
 #### b. **Configuration**
  - **Environment Variables**
   ##### [Local Machine Environment Variables ](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328799449/Application+Configuration+Management#ApplicationConfigurationManagement-Environmentvariables)
  
|   |   |   |   |   |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |
|   |   |   |   |   |

- **Data Source**
 
  ##### Maven Dependencies
  In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies are gathered in   the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
  
  To find List of Dependencies,Please refer the POM.xml File
 
  ##### application.properties
  
In Spring Boot, properties are kept in the application.properties file under the classpath.
The application.properties file is located in the src/main/resources directory. 
				
 ##### DataSource Bean
 
Supply a DataSource to the JDBC Template so it can configure itself to get database access.
You can configure the DataSource in the XML file or in a Configuration class.

				
##### JNDI DataSource
If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					Application Server’s built-in features and access it by using JNDI.
We can do this using the spring.datasource.jndi-name property.

			
  - **Logging**
  Not Applicable
   
  - **Message Bus**
  Not Applicable
  
 #### c. **Build Instructions**
		After you have taken care of the [Prerequisites](#prerequisites)
		Execute the following

			```bash
			cd openmrs-core
			mvn clean package
			```

#### d. **Testing Instructions**
		
    #### Unit test cases
     There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_ that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

````
mvn clean test -Dtest=ApplicationUnitTests
````


#### e. **Deployment Instructions**

Instructions to deploy a Microservice to  Application Server.

For development purposes you can simply deploy the `* .war` into the application server

   [More Information](http://webhelp.esri.com/arcgisserver/9.2/java/manager/applications/deploying_to_websphere.htm)
   


<img src="images/deploymentlocalintegration.JPG" width="400" height="400"/>

If all goes well (check the console output) you can access the OpenMRS application at `localhost:8080/openmrs`.

Refer to [Getting Started as a Developer - Maven](https://wiki.openmrs.org/display/docs/Maven) for some more information
on useful Maven commands and build options.

</p>
</details>


 ### Local Integration Environment
 
<details><summary>Local Integration Environment:Build and Deployment</summary>
<p>
	
  #### a. **Dependencies** 

  Maven reads the parent POM from your local repository (or proxies like nexus) and creates an 'effective POM' by merging the information from parent and module POM.
   
  Details of Parent POM:
  org.springframework.boot.spring-boot-starter-parent
  
  
 #### b. **Configuration**
  - **Environment Variables**

  
  [Environment Variables ](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328799449/Application+Configuration+Management#ApplicationConfigurationManagement-Environmentvariables)
  
  
  
  
- **Data Source**
 
  ##### Maven Dependencies

   In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies are gathered in   the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
     To find List of Dependencies,Please refer the POM.xml File
 
  ##### application.properties
  
In Spring Boot, properties are kept in the application.properties file under the classpath.
The application.properties file is located in the src/main/resources directory. 
				
 ##### DataSource Bean
 
Supply a DataSource to the JDBC Template so it can configure itself to get database access.
You can configure the DataSource in the XML file or in a Configuration class.

				
##### JNDI DataSource
If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					Application Server’s built-in features and access it by using JNDI.
We can do this using the spring.datasource.jndi-name property.

  - **Logging**
  Not Applicable
 
    
  - **Message Bus**
  Not Applicable

 #### c. **Build Instructions**
		
		```Build Instructions for Local Integration environment
			```
			
#### d. **Testing Instructions**

```Test Instructions for Local Integration environment```

		
#### Unit test cases
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_ that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

````
mvn clean test -Dtest=ApplicationUnitTests
````


- **Deployment Instructions**

#### Deploy Microservice

[Deploying a Microservice Via an automated CI/CD Pipeline](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/659751676/SBB+-+BE+Deploy+Microservice)

#### Deploy UI Web App
[Deploying UI Web App](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/660046657/SBB+-+FE+Deploy+UI+Web+App)

#### Deploying a Microservice to Docker Container
[Deploying a Microservice to Docker Container](https://www.javainuse.com/devOps/docker/docker-jar)

</p>
</details>

### Integration Platform

<details><summary>Integration Platform:Build and Deployment</summary>
<p>
	
   #### a. **Dependencies** 
    Maven reads the parent POM from your local repository (or proxies like nexus) and creates an 'effective POM' by merging the information from parent and module POM.
   
  Details of Parent POM:
  org.springframework.boot.spring-boot-starter-parent


		
 #### b. **Configuration**
  - **Environment Variables**

  
  [ Environment Variables ](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328799449/Application+Configuration+Management#ApplicationConfigurationManagement-Environmentvariables)
  
  
- **Data Source**
 
  ##### Maven Dependencies
  In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies are gathered in   the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
  
  To find List of Dependencies,Please refer the POM.xml File
 
  ##### application.properties
  
In Spring Boot, properties are kept in the application.properties file under the classpath.
The application.properties file is located in the src/main/resources directory. 
				
 ##### DataSource Bean
 
Supply a DataSource to the JDBC Template so it can configure itself to get database access.
You can configure the DataSource in the XML file or in a Configuration class.

				
##### JNDI DataSource
If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					Application Server’s built-in features and access it by using JNDI.
We can do this using the spring.datasource.jndi-name property.

- **Logging**
  Not Applicable
    
-	**Message Bus**
  Not Applicable
 

- **Build Instructions**
		

		

			```Build Instructions for  Integration environment
			```

- **Testing Instructions**
		
		```
		LocaL Test Integration Steps
			```


- **Deployment Instructions**
To Deploy a Microservice to AWS Cloud ,Refer Below
		
[Deploying Microservice to AWS Cloud](https://aws.amazon.com/blogs/compute/deploying-java-microservices-on-amazon-ec2-container-service/)

##### Container deployment overview
<img src="images/awsdeployment.JPG" width="400" height="400"/>

</p>
</details>

## Design Details
### i. UML Diagrams
<img src="images/umldiag.jpg" width="400" height="400"/>

### ii. Events Produced And Events Consumed

Currently there are no Events being Produced or Consumed,For more information please check references.

#### Dependent Downstream Services
Currently for this API ,there are no dependent services,For more information please check references.


## Support

   ### i . Deployment status
   
   Jenkins can be used to report the status of the deployment.
   
   Please check references for more information on how to check the deployment status.
   
   
   ### ii. How to view Health statistics
  Spring Boot Actuator module helps you monitor and manage your Spring Boot application by providing production-ready features like health check-up, auditing, metrics gathering,   HTTP tracing etc.
   Please check references for more information on how to view Health Statistics of a Microservice.
  
  
   ### iii. How to view Logs
   [Amazon S3 Logs](https://docs.datadoghq.com/integrations/amazon_s3/#enable-s3-access-logs)
   
   ### iv. Owned by which Team?
 
   Engineering Team3
   
## References
Includes documents which are linked with JIRA stories
[Links](https://wawaappdev.atlassian.net/secure/RapidBoard.jspa?rapidView=280)
[Event Publisher](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/593334289/Solution+Building+Block+-+Event+Publication)
[Event Subscriber](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/579338621/Solution+Building+Block+-+Event+Subscriber)
[Dependencies](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/762448353/Dependencies+on+EE+Team+s)
[Check Deployment Status](https://www.namecheap.com/blog/visualize-your-deployment-status-with-jenkins/)
[How to view Health statistics of a Microservice](https://www.callicoder.com/spring-boot-actuator/)
### i. Links to Detailed Design
Not Applicable
### ii. Links to SBBs used
[Link(s) to SBBs](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/586613993/P3%2B-%2BSolution%2BBuild%2BBlock%2BRegistry)
### iii. Links to ABBs used
[Link(s) to ABBs](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/508428401/Foundational+Architecture+Building+Blocks)
### iv. Links to OAS on Developer Portal
[Link to OAS on Developer Portal](https://wawaappdev.atlassian.net/wiki/spaces/ENTERPRISE/pages/590742573/System+Developer+Portal+Design)
#### Links to On-boarding document
[Developer On-boarding](https://wawaappdev.atlassian.net/wiki/spaces/MEET/pages/131137606/Developer+onboarding)

## License

[Engineering Team3](https://wawaappdev.atlassian.net/secure/RapidBoard.jspa?rapidView=280&projectKey=EN3) © [WAWA](https://www.wawa.com/)
