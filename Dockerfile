FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ARG SEC_FILE=target/classes/gcp_sa_key.json
COPY ${JAR_FILE} app.jar
COPY ${SEC_FILE} classes/gcp_sa_key.json
ENTRYPOINT ["java","-jar","/app.jar"]
