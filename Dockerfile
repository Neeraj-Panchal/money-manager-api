# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

# --- YAHAN CHANGE HAI ---
# Hum folder ke andar ja rahe hain jahan pom.xml hai
WORKDIR /app/moneymanager

# Ab ye chalega
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre
WORKDIR /app

# --- YAHAN BHI CHANGE HAI ---
# Jar file ab 'moneymanager' folder ke andar 'target' mein milegi
COPY --from=build /app/moneymanager/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]