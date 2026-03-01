# -----------------------------
# Use Eclipse Temurin JDK 21 as base
# -----------------------------
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .  
COPY .mvn .mvn  
COPY pom.xml .  
COPY src src

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the project inside container (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot default port (or change if needed)
EXPOSE 8080

# Run Spring Boot JAR
CMD ["java", "-jar", "target/appfood-0.0.1-SNAPSHOT.jar"]
