FROM openjdk:8-jre-alpine
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "./target/kaddem-0.0.1-SNAPSHOT.jar"]
