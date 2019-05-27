# Cloud native web application to convert input numerals to roman equivalents
The application leverages Spring boot to expose the core services via REST API. Only allows positive integers between 1-3999 as input. Returns HttpResponse BAD_REQUEST for input outside this range.

## How to build and run your project.
Pre-requisite: download and install java8, maven and Dcoker.

This application uses Maven to build and resolve application dependencies.

1- Clone this repo.

2- Execute the following command to create the jar 

`mvn package`

## JAVA application
3- Execute the following command to run the application
`java -jar target/adobe-roman-0.0.1-SNAPSHOT.jar`

OR

## DOCKER
3.1- Execute following command to create an image from the jar file. (pre-requisite download and install Dcoker)

`docker build -t adoberoman .`

3.2- Execute following command to run the docker image

`docker run --name roman-numeral -p8080:8080 -d adoberoman`

The application should be now up and running.

API documentation available using Swagger at:
http://localhost:8080/swagger-ui.html

Sample usage:
http://localhost:8080/romannumeral?query=660

The metrics, info and monitoring for the application is exposed at:  
http://localhost:8080/actuator/info

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/metrics/api.convertDecimalToRoman


I have left out Security configurations for now, but ideally in production I would like to not allow all the metrics exposed by Spring actuator, instead only expose the required ones and that too restrict them outside network firewall.

## Best practices for designing a cloud-native app:
1] API First, API documentation, examples & mgmt (swagger)

2] Configuration management. Multiple profile of configs for QA, Dev, Prod.

3] Exception handling. Design seperate application exception and infrastructure exception.

4] Security first. API gateway. JWT tokens.

5] Logging. Avoid files if possible. Streaming of logs better idea.

6] API driven app monitoring & info, healthcheck. Using tools like Spring Actuator, Prometheus, Knox, NewRelic, DataDog.

7] Test Statergy: Acceptance tests(using Cucumber), Integration tests to test external dependencies, Component tests to test with Spring contexts but without external dependencies, Unit tests, Developer tests to help team with prototype or sample code.

8] Build tools like gradle(build.gradle), maven(pom.xml).

9] Pipeline using tools like Jenkins.
  - Pre-commit checks & scans.
  - Post-commit: Build and create jar, Create docker image, Deploy using rundeck/spinaker.
