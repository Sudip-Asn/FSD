FROM openjdk:8
EXPOSE 8085
ADD projectmanager-API-0.0.1-SNAPSHOT.jar projectmanager-API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "projectmanager-API-0.0.1-SNAPSHOT.jar"]
RUN sh -c 'touch /projectmanager-API-0.0.1-SNAPSHOT.jar'