FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy all project files
COPY pom.xml .
COPY src ./src

# Build application (without tests)
RUN mvn -q -e -DskipTests package

########## RUNTIME IMAGE ##########
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
