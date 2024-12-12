#building using gradle
FROM gradle:7.6.2-jdk17 AS build

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew && ./gradlew clean build -x test
#running app
FROM openjdk:17

WORKDIR /app

#copying from build
COPY --from=build /app/build/libs/*.jar app.jar
COPY --from=build /app/build/resources /app/resources
COPY /src/main/resources/application.properties.tpl /app/application.properties

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
