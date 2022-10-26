# banking-system
Spring boot microservice

## description:
This is a Spring Boot microservices monorepo project

### Project structure
We will use a single monorepo repository for all microservices, so our project is structured as follows:
```
banking
  api-gateway
    pom.xml (jar)
  account
    pom.xml (jar)
  customer
    pom.xml (jar)  
  config
    pom.xml (jar)
  service-discovery
    pom.xml (jar)
  netflix-user-microservice
    pom.xml (jar)
  pom.xml (pom)
```
How to create a monorepo project?

1- 
```
mvn -B archetype:generate -DgroupId=com.anbaralabs -DartifactId=banking -DarchetypeArtifactId=maven-archetype-quickstart
 -DarchetypeVersion=1.4 -DinteractiveMode=false
```

2- Delete src folder from parent

3- copy the config that exist in pom.xml from this repo to pom.xml in your project parent

4- Start create module using Intellij ide: click new on your folder parent then create
new module


