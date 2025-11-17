FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# MAVEN SETTINGS (Render için güvenli mirror)
RUN mkdir -p /root/.m2 && \
    printf '<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" \
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" \
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 \
    https://maven.apache.org/xsd/settings-1.0.0.xsd"> \
    <mirrors> \
        <mirror> \
            <id>central</id> \
            <mirrorOf>*</mirrorOf> \
            <url>https://repo.maven.apache.org/maven2</url> \
        </mirror> \
    </mirrors> \
</settings>' > /root/.m2/settings.xml

# Copy everything
COPY . .

# BUILD WITH RETRY (Render timeout için kritik)
RUN mvn -B -DskipTests clean package || \
    (echo "Retry Maven..." && mvn -B -DskipTests clean package)

########## RUNTIME ##########
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
