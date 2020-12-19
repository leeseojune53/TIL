FROM openjdk:11
EXPOSE 8080
COPY ./build/libs/*.jar helloworld-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/helloworld-0.0.1-SNAPSHOT.jar"]