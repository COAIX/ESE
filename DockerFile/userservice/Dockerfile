#java version is 17
FROM openjdk:17

#copy all jar files
COPY *.jar /app.jar

#server port
CMD ["--server.port=8081"]

#container expose port
EXPOSE 8081

#container run command
ENTRYPOINT ["java","-jar","/app.jar"]