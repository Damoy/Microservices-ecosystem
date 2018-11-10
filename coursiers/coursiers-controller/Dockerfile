FROM openjdk:8-jdk-alpine


RUN mkdir -p src/main
COPY src/main src/main

# Add a volume pointing to /tmp
VOLUME /tmp


# Make port 8081 available to the world outside this container
EXPOSE 8090

# The application's jar file
ARG JAR_FILE=target/coursier-controller-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} coursier-controller.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/coursier-controller.jar"]