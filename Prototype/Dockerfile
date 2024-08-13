#java version is 8
FROM openjdk:17

#copy all jar files
COPY *.jar /app.jar

#server port
CMD ["--server.port=6061"]

#container expose port
EXPOSE 6061

#container run command
ENTRYPOINT ["java","-jar","/app.jar"]