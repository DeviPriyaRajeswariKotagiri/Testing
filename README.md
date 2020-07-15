<img src="images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://travis-ci.org/openmrs/openmrs-core) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://coveralls.io/github/openmrs/openmrs-core?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://www.codacy.com/app/openmrs/openmrs-core?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=openmrs/openmrs-core&amp;utm_campaign=Badge_Grade)

## Application on Spring Security JWT 
POC to demonstrate the knowledge on Spring Security and JWT

#### Table of Contents

1. [Introduction](#Introduction)
2. [Prerequisites](#prerequisites)
   1. [Tools (to be installed on developer’s machine)](#Tools)
   2. [Infrastructure](#Infrastructure)
     1. [Local](#Local)
     2. [Cloud](#Cloud)
2. [Build & Deployment](#Build & Deployment)
   1. [Local Machine](#Local-Machine)
		1. [Dependencies](#Dependencies)
		2. [Configuration (Build & Runtime)](#Configuration-(Build & Runtime))
			1. [Environment Variables](#Environment-Variables) 
			2. [Data Source](#Data-Source)
			3. [Logging](#Logging)
			4. [Message Bus](#Message-Bus)	
		3. [Build Instructions](#Build-Instructions)
		4. [Testing Instructions](#Testing-Instructions)
		5. [Deployment Instructions](#Deployment-Instructions)
	2. [Local Integration Environment (LIE)](Local Integration Environment (LIE))
		1. [Dependencies](#Dependencies)
		2. [Configuration (Build & Runtime)](#Configuration-(Build & Runtime))
			1. [Environment Variables](#Environment-Variables) 
			2. [Data Source](#Data-Source)
			3. [Logging](#Logging)
			4. [Message Bus](#Message-Bus)	
		3. [Build Instructions](#Build-Instructions)
		4. [Testing Instructions](#Testing-Instructions)
		5. [Deployment Instructions](#Deployment-Instructions)
	3. [Integration Platform](Integration Platform)
		1. [Dependencies](#Dependencies)
		2. [Configuration (Build & Runtime)](#Configuration-(Build & Runtime))
			1. [Environment Variables](#Environment-Variables) 
			2. [Data Source](#Data-Source)
			3. [Logging](#Logging)
			4. [Message Bus](#Message-Bus)	
		3. [Build Instructions](#Build-Instructions)
		4. [Testing Instructions](#Testing-Instructions)
		5. [Deployment Instructions](#Deployment-Instructions)
3. [Design Details](#Design-Details)
	1. [UML Diagrams](#UML-Diagrams)
	2. [Events Produced & Events Consumed](#Events Produced & Events Consumed)
	3. [Dependent Downstream Services](#Dependent Downstream Services)
4. [Support](#Support)
   1. [Deployment status](#Deployment status)
   2. [How to view Health statistics](#How to view Health statistics)
   3. [How to view Logs](#How to view Health statistics)
   4. [Owned by which Team?](#Owned by which Team?)
5. [References](#References)
 1. [Link(s) to Detailed Design](#Link(s) to Detailed Design)
 2. [Link(s) to SBBs used](#Link(s) to SBBs used)
 3. [Link(s) to ABBs used](#Link(s) to ABBs used)
 4. [Link to OAS on Developer Portal](#Link to OAS on Developer Portal)
 5. [Link(s) to On-boarding document](#Link(s) to On-boarding document)
6. [License](#license)

## Introduction

### Prerequisites

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

Install the version control tool [git]https://github.com/wawa/) and clone this repository with

```bash
git clone  https://github.com/wawa/admin-toolstack-config.git
```

### Build Command

After you have taken care of the [Prerequisites](#prerequisites)

Execute the following

```bash
cd openmrs-core
mvn clean package
```


### Deploy

For development purposes you can simply deploy the `openmrs.war` into the application server jetty via

```bash
cd openmrs-core/webapp
mvn jetty:run
```

If all goes well (check the console output) you can access the OpenMRS application at `localhost:8080/openmrs`.

Refer to [Getting Started as a Developer - Maven](https://wiki.openmrs.org/display/docs/Maven) for some more information
on useful Maven commands and build options.

## Navigating the repository

The project tree is set up as follows:

<table>
 <tr>
  <td>api/</td>
  <td>Java and resource files for building the java api jar file.</td>
 </tr>
 <tr>
  <td>web/</td>
  <td>Java and resource files that are used in the webapp/war file.</td>
 </tr>
 <tr>
  <td>webapp/</td>
  <td>files used in building the war file (contains JSP files on older versions).</td>
 </tr>
 <tr>
  <td>pom.xml</td>
  <td>The main maven file used to build and package OpenMRS.</td>
 </tr>  
</table>

## Technology

- **Spring Boot**     - Server side framework
- **JPA**             - Entity framework
- **Lombok**          - Provides automated getter/setters
- **Actuator**        - Application insights on the fly
- **Spring Security** - Spring's security layer
- **Thymeleaf**       - Template Engine
- **Devtools**        - Support Hot-Code Swapping with live browser reload
- **JJWT**            - JWT tokens for API authentication
- **Swagger**         - In-built swagger2 documentation support
- **Docker**          - Docker containers
- **Junit**           - Unit testing framework
- **H2**              - H2 database embedded version



## API Documentation
POC to demonstrate the knowledge on Spring Security and JWT
JWT (shortened from JSON Web Token) is the missing standardization for using tokens to authenticate on the web in general, not only for REST services. Currently, it is in draft status as RFC 7519. It is robust and can carry a lot of information, but is still simple to use even though its size is relatively small. Like any other token, JWT can be used to pass the identity of authenticated users between an identity provider and a service provider (which are not necessarily the same systems). It can also carry all the user’s claim, such as authorization data, so the service provider does not need to go into the database or external systems to verify user roles and permissions for each request; that data is extracted from the token.

### UML Diagram
Detailed UML Diagram for the Application

<img src="images/uml.jpg" width="350" height="350"/>

### Dependent Downstream Services
   - [Spring Security](https://spring.io/guides/topicals/spring-security-architecture)

   - [JWT](https://jwt.io/introduction/)


## Deployments

### Deploy Microservice

[Deploying a Microservice Via an automated CI/CD Pipeline](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/659751676/SBB+-+BE+Deploy+Microservice)

### Deploy UI Web App
[Deploying UI Web App](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/660046657/SBB+-+FE+Deploy+UI+Web+App)

### Deploying a Microservice to Docker Container
[Deploying a Microservice to Docker Container](https://www.javainuse.com/devOps/docker/docker-jar)


## Testing
## Unit test cases
There are multiple unit test cases written to cover the different components of the application. However there is a global application test suite file _**UnitTests.java**_ that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

````
mvn clean test -Dtest=ApplicationUnitTests
````

## Integration test cases
There are multiple integration test cases written to cover the different components of the application. However there is a global application test suite file _**ApplicationTests.java**_ that combines all the test cases in a logical manner to create a complete suite. It can be run from command prompt using the following command -

````
mvn clean test -Dtest=SpringApplicationTests
````


## DataSource configuration
1. Maven Dependencies
<img src="images/pom.JPG" width="550" height="400"/>
2. application.properties
DataSource configuration is provided by external configuration properties ( spring.datasource.* ) in application.properties file.
The properties configuration decouple the configuration from application code. This way, we can import the datasource configurations from even configuration provider systems.
Below given configuration shows sample properties for H2, MySQL, Oracle and SQL server databases.
<img src="images/maven.JPG" width="400" height="400"/>
3. DataSource Bean
Recommended way to create DataSource bean is using DataSourceBuilder class within a class annotated with the @Configuration annotation. The datasource uses the underlying connection pool as well.
<img src="images/jpa.JPG" width="550" height="400"/>
4. JNDI DataSource
If we deploy your Spring Boot application to an Application Server, we might want to configure and manage the DataSource by using the Application Server’s built-in features and access it by using JNDI.
We can do this using the spring.datasource.jndi-name property. e.g.
<img src="images/jndi.JPG" width="800" height="90"/>


## Exception handling
  ### Default spring validation support
       To apply default validation, we only need to add relevant annotations in proper places. i.e.
       1.Annotate model class with required validation specific annotations such as @NotEmpty, @Email etc.
       2.Enable validation of request body by @Valid annotation
  ###  Exception model classes
            import org.springframework.http.HttpStatus;
            import org.springframework.web.bind.annotation.ResponseStatus;

            @ResponseStatus(HttpStatus.NOT_FOUND)
            public class RecordNotFoundException extends RuntimeException 
            {
                public RecordNotFoundException(String exception) {
                    super(exception);
                }
            }
     
  ### Custom ExceptionHandler
         import org.springframework.web.context.request.WebRequest;
         import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

         @SuppressWarnings({"unchecked","rawtypes"})
         @ControllerAdvice
         public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
         {
             @ExceptionHandler(Exception.class)
             public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
                 List<String> details = new ArrayList<>();
                 details.add(ex.getLocalizedMessage());
                 ErrorResponse error = new ErrorResponse("Server Error", details);
                 return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
             }

             @ExceptionHandler(RecordNotFoundException.class)
             public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
                 List<String> details = new ArrayList<>();
                 details.add(ex.getLocalizedMessage());
                 ErrorResponse error = new ErrorResponse("Record Not Found", details);
                 return new ResponseEntity(error, HttpStatus.NOT_FOUND);
             }

             @Override
             protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
                 List<String> details = new ArrayList<>();
                 for(ObjectError error : ex.getBindingResult().getAllErrors()) {
                     details.add(error.getDefaultMessage());
                 }
                 ErrorResponse error = new ErrorResponse("Validation Failed", details);
                 return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
             }
         }
      



## Coding Standards

[Best Coding Standards](https://google.github.io/styleguide/javaguide.html)

[Best practices for effective & efficient agile code reviews](https://queue-it.com/blog/agile-code-review-best-practices/)

## POM Dependencies
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.9.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>io</groupId>
	<artifactId>spring-security-jwt</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-security-jwt</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
 

## Collaboration

Confluence(https://wawaappdev.atlassian.net/secure/Dashboard.jspa)

## License

[Engineering Team3](https://wawaappdev.atlassian.net/secure/RapidBoard.jspa?rapidView=280&projectKey=EN3) © [WAWA](https://www.wawa.com/)


