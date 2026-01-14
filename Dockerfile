# ---- Build Stage ----
FROM gradle:9.2.1-jdk21-temurin AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# ---- Run Stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]