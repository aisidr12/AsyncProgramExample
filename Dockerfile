FROM eclipse-temurin:17-jdk-alpine
COPY demoyaml/target/asyncapp-0.0.1.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]