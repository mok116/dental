# Build stage
FROM openjdk:21-jdk-slim AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn ./.mvn
COPY src ./src
RUN chmod +x ./mvnw
RUN ./mvnw dependency:resolve
RUN ./mvnw clean package -Dspring-boot.version=3.4.2 -DskipTests

# Runtime stage
FROM openjdk:21-jdk-slim
WORKDIR /app
# Use a wildcard to copy any JAR file produced, or specify exact name from your pom.xml
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 6616
CMD ["java", "-jar", "app.jar"]