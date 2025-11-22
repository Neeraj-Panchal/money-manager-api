# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre
WORKDIR /app
# Yahan humne naam 'app.jar' rakh diya taaki neeche command simple rahe
COPY --from=build /app/target/*.jar app.jar

# Aapki demand par Port 9090
EXPOSE 8080

# Entrypoint bhi same rahega kyunki humne file ka naam 'app.jar' kar diya hai
ENTRYPOINT ["java","-jar","app.jar"]