# FROM eclipse-temurin:17-jdk-focal
 
# WORKDIR /app
 
# COPY .mvn ./mvn
# COPY mvnw pom.xml ./
# RUN ./mvnw dependency:go-offline
 
# COPY src ./src
 
# CMD ["./mvnw", "spring-boot:run"]

FROM openjdk:17
VOLUME /tmp                  
EXPOSE 8080                 
ADD target/simple-crm-0.0.1-SNAPSHOT.jar simple-crm-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/simple-crm-0.0.1-SNAPSHOT.jar"]  