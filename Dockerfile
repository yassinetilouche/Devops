FROM openjdk:8-jre-alpine
LABEL authors="Yassine"

WORKDIR /app
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "./target/kaddem-1.0.0.jar"]