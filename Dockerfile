# Use Eclipse Temurin JDK 21
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

# Expose Spring Boot port
EXPOSE 8084

# Run Spring Boot JAR (auto-detect JAR name)
CMD ["sh", "-c", "java -jar target/*.jar"]
