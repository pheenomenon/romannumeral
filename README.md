# Cloud native web application to convert input numerals to roman equivalents
The application leverages Spring boot to expose the core services via REST API.

## How to build and run your project.
This application uses Maven to build and resolve application dependencies.

1- Clone this repo.
2- Execute the following command to create the jar 

`mvn package`

3- Execute the following command to run the application
`java -jar target/adobe-roman-0.0.1-SNAPSHOT.jar`


The metrics, info and monitoring for the application is exposed at:  
http://localhost:8080/actuator/info

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/metrics/api.convertDecimalToRoman

API documentation available using Swagger at:
http://localhost:8080/swagger-ui.html




