# Select Java version and distribution
FROM openjdk:11-jdk-alpine
MAINTAINER Luiza Prestes <taeckls@gmail.com>

# Spring commands
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Move JAR file from target to use in the execution
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Commands to execute
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Environment variables
ENV SPRING_PROFILES_ACTIVE "default"