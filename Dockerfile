#
FROM openjdk:8-jre-alpine

COPY /senslog-processing.jar /senslog-processing.jar

# Make port 80 available to the world outside this container
EXPOSE 7777

# Run java
CMD ["java", "-jar", "/senslog-processing.jar"]