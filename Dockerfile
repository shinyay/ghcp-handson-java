# Use the official OpenJDK image as the base image
FROM openjdk:23-jdk-slim-bookworm

# Set the working directory
WORKDIR /workspace

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Copy the current directory contents into the container at /workspace
COPY . /workspace

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/local/openjdk-23

# Expose port 8080
EXPOSE 8080

# Set user to vscode to avoid using root user
USER vscode

# Define the command to run the application
CMD ["mvn", "spring-boot:run"]
