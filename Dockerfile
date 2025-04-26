# Build stage
FROM --platform=$BUILDPLATFORM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn ./.mvn
COPY src ./src
RUN chmod +x ./mvnw
RUN ./mvnw dependency:resolve
RUN ./mvnw clean package -Dspring-boot.version=3.4.2 -DskipTests

# Runtime stage
FROM --platform=$BUILDPLATFORM eclipse-temurin:21-jre
WORKDIR /app
# Use a wildcard to copy any JAR file produced
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 6616
CMD ["java", "-jar", "app.jar"]