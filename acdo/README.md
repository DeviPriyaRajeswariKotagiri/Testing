# The account-domain-svc  Project

# The account Project

Maven info:

```
<name>account-domain-svc</name>
<description>account-domain-svc project of Fiserv ecosystem</description>
```

    
## About


Describe your project here.

## Technical Stack

- Java 11
- Maven 3.5+
- Spring boot
- Lombok abstraction
- Swagger open Api generation 
- Swagger 2 API documentation

## Installation

-  to run locally , you need to configure the run configuration by passing :

Compile:

Custom dependencies to compile;
```
        <dependency>
            <groupId>com.fiserv.error</groupId>
            <artifactId>error-handler</artifactId>
        </dependency>

        <dependency>
            <groupId>com.fiserv.cardservices.domain</groupId>
            <artifactId>common-domain-utilities</artifactId>
        </dependency>
```

```
mvn clean compile
```

Run:
```
mvn spring-boot:run
```
