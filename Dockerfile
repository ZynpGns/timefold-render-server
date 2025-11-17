FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -q -e -DskipTests package

FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/quarkus-app ./quarkus-app

CMD ["java", "-jar", "quarkus-app/quarkus-run.jar"]

