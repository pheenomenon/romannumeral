FROM java:8
WORKDIR /
ADD target/adobe-roman-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/adobe-roman-0.0.1-SNAPSHOT.jar"]