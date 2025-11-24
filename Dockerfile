FROM gradle:8.5-jdk17 AS build
WORKDIR /app

#Copy gradle wrapper and build files
COPY gradle gradle
COPY gradlew .
COPY build.gradle.kts .
COPY settings.gradle.kts .

#Copy source code
COPY src src

#Build the application
RUN ./gradlew build --no-daemon -x test

#Runtime stage
FROM openjdk:17-oracle
WORKDIR /app

#Copy the built jar from build stage
COPY --from=build /app/build/libs/*.jar app.jar

#Expose application port
EXPOSE 8080

#Run the Application
ENTRYPOINT ["java", "-jar", "app.jar"]
