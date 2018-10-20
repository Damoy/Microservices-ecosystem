FROM openjdk:8-jdk-alpine


RUN mkdir -p src/main
COPY src/main src/main

# Add a volume pointing to /tmp
VOLUME /tmp


# Make port 8082 available to the world outside this container
EXPOSE 8082

# The application's jar file
ARG JAR_FILE=target/clients-accounts-modification-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} clients-accounts-modification.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/clients-accounts-modification.jar"]
