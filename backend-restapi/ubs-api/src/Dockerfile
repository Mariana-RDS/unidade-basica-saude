FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/ubs-api-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]