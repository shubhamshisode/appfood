# -----------------------------
# Stage 1: Build the project
# -----------------------------
FROM maven:3.9.2-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (cached)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Package the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2: Run the application
# -----------------------------
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file from build stage
COPY --from=build /app/target/*.jar appfood.jar

# Expose default Spring Boot port
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "appfood.jar"]
