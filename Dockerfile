# Maven build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only pom first (cache)
COPY pom.xml .

# Download dependencies
RUN mvn -q -e dependency:go-offline

# Copy source
COPY src ./src

# Build jar
RUN mvn -q -e -DskipTests package

# Runtime stage
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
