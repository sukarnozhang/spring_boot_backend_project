# Use the official OpenJDK 17 base image for the container
FROM openjdk:17

# Create a volume at /tmp inside the container (used for temporary files)
VOLUME /tmp                  

# Expose port 8080 to allow traffic to the Spring Boot application
EXPOSE 8080                 

# Copy the built JAR file from the target directory into the container's root directory
ADD target/simple-crm-0.0.1-SNAPSHOT.jar simple-crm-0.0.1-SNAPSHOT.jar 

# Set the command to run the JAR file when the container starts
ENTRYPOINT ["java","-jar","/simple-crm-0.0.1-SNAPSHOT.jar"]
