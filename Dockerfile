FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY classes/gcp_sa_key.json classes/gcp_sa_key.json
ENTRYPOINT ["java","-jar","/app.jar"]