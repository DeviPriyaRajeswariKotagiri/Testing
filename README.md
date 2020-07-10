<img src="images/wawa.jpg" width="100" height="100"/>

[![Build Status](https://travis-ci.org/openmrs/openmrs-core.svg?branch=master)](https://travis-ci.org/openmrs/openmrs-core) [![Coverage Status](https://coveralls.io/repos/github/openmrs/openmrs-core/badge.svg?branch=master)](https://coveralls.io/github/openmrs/openmrs-core?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/a51303ee46c34775a7c31c8d6016da6b)](https://www.codacy.com/app/openmrs/openmrs-core?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=openmrs/openmrs-core&amp;utm_campaign=Badge_Grade)

Wawa, Inc. is an American chain of convenience stores and gas stations located along the East Coast of the United States, operating in Pennsylvania, New Jersey, Delaware, Maryland, Virginia, Washington, D.C., and Florida.

#### Table of Contents

1. [Build](#build)
   1. [Prerequisites](#prerequisites)
   2. [Build Command](#build-command)
   3. [Deploy](#deploy)
2. [Navigating the repository](#navigating-the-repository)
3. [API Documentation](#API-Documentation)
   1. [Developer guides](#developer-guides)
   2. [API Platform](#API-Platform)
5. [Deployments](#Deployments)
6. [Databases](#Databases)
7. [Coding Standards](#Coding-Standards)
   1. [Code](#code)
   2. [Code Reviews](#code-reviews)
8. [POM Dependencies](#POM Dependencies)
9. [Collaboration](#Collaboration)
10. [License](#license)

## Build

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
git clone https://github.com/openmrs/openmrs-core.git
```

### Build Command

After you have taken care of the [Prerequisites](#prerequisites)

Execute the following

```bash
cd openmrs-core
mvn clean package
```

This will generate the OpenMRS application in `webapp/target/openmrs.war` which you will have to deploy into an application server like for example [tomcat](https://tomcat.apache.org/) or [jetty](http://www.eclipse.org/jetty/).

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


## API Documentation

### Developer guides

If you want to contribute please refer to these resources

* [Getting Started as a Developer](https://developer.github.com/v3/guides/getting-started/)
* [How To Configure Your IDE](https://wiki.openmrs.org/display/docs/How-To+Setup+And+Use+Your+IDE)
* [Using GIT](https://docs.github.com/en/github/using-git)

### API Platform

Here is where we will be building out documentation for learning key technologies used in the digital platform.  Key areas include:
API Platform
* [API Platform Overview](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/212926824/API+Platform+Overview)
* [API Platform Onboarding](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/328799337/API+Platform+Onboarding)
* [Integration Platform Design](https://wawaappdev.atlassian.net/wiki/spaces/KM/pages/344495079/Integration+Platform+Design)

## Deployments

### Deploy Microservice

[Deploying a Microservice Via an automated CI/CD Pipeline](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/659751676/SBB+-+BE+Deploy+Microservice)

### Deploy UI Web App
[Deploying UI Web App](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/660046657/SBB+-+FE+Deploy+UI+Web+App)

### Deploying a Microservice to Docker Container
[Deploying a Microservice to Docker Container](https://www.javainuse.com/devOps/docker/docker-jar)

## Databases
[Database Component](https://wawaappdev.atlassian.net/wiki/spaces/EE/pages/662143302/Databases)

## Coding Standards

### Code

[Best Coding Standards](https://google.github.io/styleguide/javaguide.html)

### Code Reviews

[Best practices for effective & efficient agile code reviews](https://queue-it.com/blog/agile-code-review-best-practices/)

## POM Dependencies


## Collaboration

Confluence(https://wawaappdev.atlassian.net/secure/Dashboard.jspa)

## License

[Engineering Team3](https://wawaappdev.atlassian.net/secure/RapidBoard.jspa?rapidView=280&projectKey=EN3) © [WAWA](https://www.wawa.com/)

