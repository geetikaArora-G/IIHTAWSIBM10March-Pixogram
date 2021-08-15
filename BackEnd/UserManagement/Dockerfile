FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/*.jar /tmp/app.jar
CMD ["java","-jar","/tmp/app.jar"]