# Select Java version and distribution
FROM adoptopenjdk/openjdk11:latest
MAINTAINER Luiza Prestes <taeckls@gmail.com>

# Move JAR file from target to use in the execution
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Commands to execute
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Environment variables
ENV SPRING_PROFILES_ACTIVE "default"