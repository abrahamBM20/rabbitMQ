# --- Etapa 1: compilación con Gradle ---
FROM gradle:jdk-21-and-22-alpine AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradlew ./
COPY gradle ./gradle
COPY src ./src
RUN ./gradlew bootJar -x test

# --- Etapa 2: imagen final ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Usuario sin privilegios + carpeta /data con permisos (SQLite necesita escribir)
RUN addgroup -S spring && adduser -S spring -G spring \
    && mkdir /data && chown spring:spring /data
USER spring:spring

COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]