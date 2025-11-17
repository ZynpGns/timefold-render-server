FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# MAVEN MIRROR (Render bağımlılık problemi çözümü)
RUN mkdir -p /root/.m2 && \
    echo '<settings><mirrors><mirror><id>maven-default</id><mirrorOf>*</mirrorOf><url>https://repo.maven.apache.org/maven2</url></mirror></mirrors></settings>' \
    > /root/.m2/settings.xml

COPY pom.xml .
COPY src ./src

RUN mvn -e -DskipTests package

########## RUNTIME ##########
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
