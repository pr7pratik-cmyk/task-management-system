FROM openjdk:17-jdk-slim

WORKDIR /app

COPY task-management-system/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]