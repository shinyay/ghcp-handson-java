FROM openjdk:21-jdk-slim-bookworm

ARG USERNAME
ARG USER_UID
ARG USER_GID

# Set non-interactive frontend for apt-get
ENV DEBIAN_FRONTEND=noninteractive

# Update and install sudo
RUN apt-get update \
    && apt-get install -y sudo

# Create /etc/sudoers.d directory if it doesn't exist
RUN mkdir -p /etc/sudoers.d

# Create the group and user using the build arguments
RUN groupadd --gid $USER_GID $USERNAME \
    && useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && usermod -aG sudo $USERNAME \
    && echo "$USERNAME ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

# Set the user as the default user
USER $USERNAME

WORKDIR /workspace
