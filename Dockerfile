FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/aws-base-app.jar app.jar

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "app.jar"]