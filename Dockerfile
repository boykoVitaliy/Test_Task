FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/Test_Task-1.0-SNAPSHOT.jar Test_Task-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Test_Task-1.0-SNAPSHOT.jar"]
