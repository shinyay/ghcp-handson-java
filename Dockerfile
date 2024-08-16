# Use the official OpenJDK image as the base image
FROM openjdk:23-jdk-slim-bookworm

# Set the working directory
WORKDIR /workspace

# Environment variables
ARG USERNAME
ARG USER_UID
ARG USER_GID

# Set Non-Root User
RUN apt-get update \
    && groupadd --gid $USER_GID $USERNAME \
    && useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && apt-get install -y sudo \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/local/openjdk-23

USER $USERNAME
