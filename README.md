<img src="images/wawa.jpg" width="100" height="100"/>
<details>
<a href="http://google.com" target="null">press</a></details>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://google.com/) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://google.com/) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://google.com/)

# Name of the Component

## Table of Contents

1. [Introduction](#Introduction)
2. [Prerequisites](#Prerequisites)
   1. Tools/Software
   2. Infrastructure
      1. Local
      2. Cloud
3. [Build And Deployment](#Build-And-Deployment)
    1. Local Machine
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
   2. Local Integration Environment
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
   3. Integration Platform
		1. Dependencies
		2. Configuration
			- Environment Variables
			- Data Source
			- Logging
			- Message Bus
		3. Build Instructions
		4. Testing Instructions
		5. Deployment Instructions
4. [Design Details](#Design-Details)
	1. UML Diagrams
	2. Events Produced And Events Consumed
	3. Dependent Downstream Services
5. [Support](#Support)
   1. Deployment status
   2. How to view Health statistics
   3. How to view Logs
   4. Owned by which Team?
6. [References](#References)
    Links to Detailed Design
7. [License](#license)

## Introduction

Provide Description of Component

## Prerequisites
### i. Tools/Software
   #### a. Java
Install Java8(https://www.oracle.com/java/technologies/java8.html)
If you want to build the master branch you will need a Java JDK of minimum version 8.



   #### b. Maven

Install the build tool [Maven](https://maven.apache.org/).

You need to ensure that Maven uses the Java JDK needed for the branch you want to build.

To do so execute

```bash
mvn -version
```

which will tell you what version Maven is using. Refer to the [Maven docs](https://maven.apache.org/configure.html) if you need to configure Maven.

#### c. Git

Install the version control tool [git](https://github.com/wawa/) and clone this repository with

```bash
git clone  https://github.com/wawa/admin-toolstack-config.git
```


#### d. IDE
Provide Integrated development environment used to build the application 
e.g: STS/Eclipse/intellij etc.

### ii. Infrastructure

  **a. Local**

1. GITHub
2. CI/CD Platform
3. Code Quantity Scanning (SonarQube)
4. Docker Container: Install Docker Container to create isolated environments through which you can build, maintain, ship and deploy your application.[More 			Information](https://docs.docker.com/docker-for-windows/)
5. Kubernetes: Install Kubernetes for automating deployment, scaling, and management of containerized applications.[More 			
Information](https://kubernetes.io/docs/setup/)
6. Databases: Install required database for the component design (SQL DB/No-SQL)



 **b. Cloud**

If your application relies on cloud infrastructure e.g. AWS ,you will have to take care of below services:
1. Compute.
2. Storage & Databases.
3. Networking.
4. Messaging.
5. Logging and Monitoring.
	

## Build And Deployment

### i. Local Machine

<details><summary>Local Machine:Build and Deployment</summary>
<p>

#### a. **Dependencies** 
 
  
  [Details of Parent POM](https://google.com)
 
   e.g: org.springframework.boot.spring-boot-starter-parent
  
   
		
#### b. **Configuration**
 **1. Environment Variables**

  
|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|		
|  SERVICE_BASE_URL	   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  Scope of this variable changes at run time|
 |  BUILD_NUMBER 		   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is pr_pull_number |         |  BUILD_HASH	           |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is github hash    |  
  |  APP_VERSION		   |  	Env		   | 	Build & Runtime		  |  Application Developer	 |			 |  The app_version comes from 				the helm chart.|
 |	 GITHUB_TOKEN  		   |  	Env		   | 	Build 			  |  Integration Platform	 |This variable allows downloading npm packages published to the GitHub NPM Registry.	|  To be renamed to GIT_PACKAGE_MANAGER_TOKEN   |
|ENABLE_BUILD_DETAILS|Env| Build & Runtime|Application Developer|Control visibility of build and version number in UI application expected value:- true : to show details false : to hide details        |  Yet to be created. It will come from helm chart.|
	
	
**2. Data Source**

 1. Maven Dependencies
		
	In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies   		 are gathered in    the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
	To find List of Dependencies,Please refer the POM.xml File.

2. application.properties
		
	In Spring Boot, properties are kept in the application.properties file under the classpath.
	The application.properties file is located in the src/main/resources directory. 

3. DataSource Bean

	Supply a DataSource to the JDBC Template so it can configure itself to get database access.
	You can configure the DataSource in the XML file or in a Configuration class.


4. JNDI DataSource

	If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					        Application Server’s built-in features and access it by using JNDI.
	We can do this using the spring.datasource.jndi-name property.

			
**3. Logging**
  Spring Boot uses Apache Commons logging for all internal logging.
  You can use logging options available in Spring Boot like Java Util Logging, Log4j2, and Logback.
  
   
**4. Message Bus**

			 ```Information on messaging infrastructure in the application which allows
			 different systems to communicate through a shared set of interfaces
			 ```
 
#### c. **Build Instructions**

After you have taken care of the [Prerequisites](#prerequisites)
Execute the following

			```bash
			cd openmrs-core
			mvn clean package
			```

#### d. **Testing Instructions**
		
##### Unit test cases
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_     that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

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


### ii. Local Integration Environment
 
<details><summary>Local Integration Environment:Build and Deployment</summary>
<p>
	
#### a. **Dependencies** 

   
 [Details of Parent POM](https://google.com)

e.g: org.springframework.boot.spring-boot-starter-parent
  
  
#### b. **Configuration**
**1. Environment Variables**

  
|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|		
|  SERVICE_BASE_URL	   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  Scope of this variable changes at run time|
 |  BUILD_NUMBER 		   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is pr_pull_number |         |  BUILD_HASH	           |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is github hash    |  
  |  APP_VERSION		   |  	Env		   | 	Build & Runtime		  |  Application Developer	 |			 |  The app_version comes from 				the helm chart.|
 |	 GITHUB_TOKEN  		   |  	Env		   | 	Build 			  |  Integration Platform	 |This variable allows downloading npm packages published to the GitHub NPM Registry.	|  To be renamed to GIT_PACKAGE_MANAGER_TOKEN   |
|ENABLE_BUILD_DETAILS|Env| Build & Runtime|Application Developer|Control visibility of build and version number in UI application expected value:- true : to show details false : to hide details        |  Yet to be created. It will come from helm chart.|
	
	
	
	
 **2. Data Source**
 
 1. Maven Dependencies
		
	In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies   		 are gathered in    the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
	To find List of Dependencies,Please refer the POM.xml File.

2. application.properties
		
	In Spring Boot, properties are kept in the application.properties file under the classpath.
	The application.properties file is located in the src/main/resources directory. 

3. DataSource Bean

	Supply a DataSource to the JDBC Template so it can configure itself to get database access.
	You can configure the DataSource in the XML file or in a Configuration class.


4. JNDI DataSource

	If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					        Application Server’s built-in features and access it by using JNDI.
	We can do this using the spring.datasource.jndi-name property.
		
**3. Logging**
  Spring Boot uses Apache Commons logging for all internal logging.
  You can use logging options available in Spring Boot like Java Util Logging, Log4j2, and Logback.
  
   
**4. Message Bus**

			 ```Information on messaging infrastructure in the application which allows
			 different systems to communicate through a shared set of interfaces
			 ```

#### c. **Build Instructions**
		
		```Build Instructions for Local Integration environment
			```
			
#### d. **Testing Instructions**

All the individual components are combined and tested as a group.

		```
		Test Instructions for Local Integration 
		```




#### e. **Deployment Instructions**

1. Deploy Microservice

	[Deploying a Microservice Via an automated CI/CD Pipeline](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/659751676/SBB+-+BE+Deploy+Microservice)

2. Deploy UI Web App
		
	[Deploying UI Web App](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/660046657/SBB+-+FE+Deploy+UI+Web+App)

3. Deploying a Microservice to Docker Container
		
	[Deploying a Microservice to Docker Container](https://www.javainuse.com/devOps/docker/docker-jar)

</p>
</details>

### iii. Integration Platform

<details><summary>Integration Platform:Build and Deployment</summary>
<p>
	
#### a. **Dependencies** 

[Details of Parent POM](http://google.com)

e.g: org.springframework.boot.spring-boot-starter-parent


		
#### b. **Configuration**
**1. Environment Variables**

  
|Environment Variable Name | Type (Env or Secret)  |  Scope (Build or Runtime)    | Responsible Party for value  | Purpose | Comment(s)  |   
|:-------------------------|:----------------------|:-----------------------------|:-----------------------------|:--------|:------------|		
|  SERVICE_BASE_URL	   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  Scope of this variable changes at run time|
 |  BUILD_NUMBER 		   |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is pr_pull_number |         |  BUILD_HASH	           |  	Env		   | 	Build & Runtime		  |  Integration Platform	 |			 |  It is github hash    |  
  |  APP_VERSION		   |  	Env		   | 	Build & Runtime		  |  Application Developer	 |			 |  The app_version comes from 				the helm chart.|
 |	 GITHUB_TOKEN  		   |  	Env		   | 	Build 			  |  Integration Platform	 |This variable allows downloading npm packages published to the GitHub NPM Registry.	|  To be renamed to GIT_PACKAGE_MANAGER_TOKEN   |
|ENABLE_BUILD_DETAILS|Env| Build & Runtime|Application Developer|Control visibility of build and version number in UI application expected value:- true : to show details false : to hide details        |  Yet to be created. It will come from helm chart.|
	
	
  
**2. Data Source**
 	
 1. Maven Dependencies
		
	In Maven, dependency is another archive—JAR, ZIP, and so on—which your current project needs in order to compile, build, test, and/or to run. The dependencies   		 are gathered in    the pom. When you run a build or execute a maven goal, these dependencies are resolved, and are then loaded from the local repository.
	To find List of Dependencies,Please refer the POM.xml File.

2. application.properties
		
	In Spring Boot, properties are kept in the application.properties file under the classpath.
	The application.properties file is located in the src/main/resources directory. 

3. DataSource Bean

	Supply a DataSource to the JDBC Template so it can configure itself to get database access.
	You can configure the DataSource in the XML file or in a Configuration class.


4. JNDI DataSource

	If we deploy the Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the 					        Application Server’s built-in features and access it by using JNDI.
	We can do this using the spring.datasource.jndi-name property.
	
		
**3. Logging**
  Spring Boot uses Apache Commons logging for all internal logging.
  You can use logging options available in Spring Boot like Java Util Logging, Log4j2, and Logback.
  
   
**4. Message Bus**

			 ```Information on messaging infrastructure in the application which allows
			 different systems to communicate through a shared set of interfaces
			 ```
			 
#### c. **Build Instructions**
		


			```Build Instructions for  Integration environment
			```

#### d. **Testing Instructions**
		
All the individual components are combined and tested as a group.
		```
		 Testing Instructions for  Integration Environment
			```


#### e. **Deployment Instructions**
You can To Deploy a Microservice to AWS Cloud ,Please check references for more information
Container deployment overview

<img src="images/awsdeployment.JPG" width="400" height="400"/>

</p>
</details>

## Design Details
### i. UML Diagrams
UML Diagram for the Component

<img src="images/umldiag.jpg" width="400" height="400"/>

### ii. Events Produced And Events Consumed

Kafka is one of  the ways to achieve publish-subscribe based messaging system in Microservices.
For more information on How to produce and consume events , please check references.

### iii. Dependent Downstream Services
Describe the dependent services in your application.
 



## Support

   ### i . Deployment status
   
   One of the way to check Deployment status is via Jenkins.
   Jenkins can be used to report the status of the deployment.
   
   Please check references for more information on how to check the deployment status.
   
   
   ### ii. How to view Health statistics
  One of the way to view Health Statistics of your application is by adding Spring Boot Actuator module ,it helps you monitor and manage your Spring Boot application by    	   providing production-ready features like health check-up, auditing, metrics gathering,   HTTP tracing etc.
  Please check references for more information on how to view Health Statistics of a Microservice.
  
  
   ### iii. How to view Logs
   You can view logs for a Microservice using Kuberenetes,Amazon S3,Splunk,WinScp etc.
   Please check references for more information on how to view logs.
  

   
   ### iv. Owned by which Team?
 
   Engineering Team3
   
## References

###  Links to Detailed Design


| Name |Link | Comments   | 
|:-----|:----|:-----------|
|Kafka Pub-Sub| https://github.com/Kunalk/spring-kafka-pubsub | |
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




## License

[Engineering Team3](https://wawaappdev.atlassian.net/secure/RapidBoard.jspa?rapidView=280&projectKey=EN3) © [WAWA](https://www.wawa.com/)
