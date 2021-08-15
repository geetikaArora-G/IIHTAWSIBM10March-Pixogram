FROM openjdk:8-jdk-alpine
EXPOSE 8088
COPY target/*.jar /tmp/app.jar
CMD ["java","-jar","/tmp/app.jar"]