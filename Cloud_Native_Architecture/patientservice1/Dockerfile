#java version is 8
FROM openjdk:17

#copy all jar files
COPY *.jar /app.jar

#server port
CMD ["--server.port=7071"]

#container expose port
EXPOSE 7071

#container run command
ENTRYPOINT ["java","-jar","/app.jar"]