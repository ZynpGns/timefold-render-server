# ================================
# 1) Build Stage
# ================================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Bağımlılıkları hızlı yüklemek için önce pom.xml kopyalanır
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Şimdi tüm proje kopyalanır
COPY src ./src

# Spring Boot jar oluşturulur
RUN mvn clean package -DskipTests

# ================================
# 2) Run Stage
# ================================
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
