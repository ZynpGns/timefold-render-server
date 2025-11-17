# Base image: JDK 17 + MAVEN automatically installed
FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

# Copy Maven config files first (better caching)
COPY pom.xml .

# Download dependencies (caching)
RUN mvn -q -e dependency:go-offline

# Copy source code
COPY src ./src

# Build the project
RUN mvn -q -e -DskipTests package

# Run the app
CMD ["java", "-jar", "target/timefold-render-server.jar"]
