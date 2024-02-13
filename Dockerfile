FROM openjdk:8-jre-alpine
LABEL authors="youssef"

WORKDIR /app
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "./target/kaddem-1.0.0.jar"]