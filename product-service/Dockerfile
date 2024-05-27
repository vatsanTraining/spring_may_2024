FROM amazoncorretto:17-alpine
ARG JAR_FILE=target/product-service.jar
COPY ${JAR_FILE} app.jar
EXPOSE 4040
ENTRYPOINT ["java","-jar","app.jar"]