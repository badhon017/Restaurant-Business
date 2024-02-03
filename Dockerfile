FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/restaurant-business-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar","./app.jar"]