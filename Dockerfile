FROM openjdk:8-jre-alpine
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "./target/kaddem-1.0.0.jar"]
