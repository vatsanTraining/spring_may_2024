FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=target/sample-service.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]


