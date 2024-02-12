FROM openjdk:8-jre-alpine
EXPOSE 8888
COPY target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kaddem-0.0.1-SNAPSHOT.jar"]
