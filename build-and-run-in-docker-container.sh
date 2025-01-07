#!/bin/bash

set -e  # Exit the script if any command fails
set -u  # Exit the script if undefined variables are used

# Configuration
JAVA_VERSION="11"
DOCKER_IMAGE_NAME="x-lighthouse"
DOCKER_PORT="8080"

# Helper functions
log() {
    echo "[INFO] $1"
}

error_exit() {
    echo "[ERROR] $1"
    exit 1
}

# Stop and remove container if running
stop_container() {
    CONTAINER_ID=$(docker ps -q --filter "ancestor=$DOCKER_IMAGE_NAME")
    if [ -n "$CONTAINER_ID" ]; then
        log "Stopping container with ID $CONTAINER_ID..."
        docker stop "$CONTAINER_ID" || log "Failed to stop the container (ignored)."
    else
        log "No running container found for image '$DOCKER_IMAGE_NAME'."
    fi
}

# Set JAVA_HOME
log "Setting JAVA_HOME to version $JAVA_VERSION..."
export JAVA_HOME=$(/usr/libexec/java_home -v "$JAVA_VERSION") || error_exit "Failed to set JAVA_HOME"
java -version || error_exit "Failed to verify Java version"

# Build the project with Maven
log "Running 'mvn clean package'..."
mvn clean package || error_exit "Failed to build the project with Maven"

# Stop the running container before building a new image
stop_container

# Build the Docker image
log "Building Docker image '$DOCKER_IMAGE_NAME'..."
docker build -t "$DOCKER_IMAGE_NAME" . || error_exit "Failed to build the Docker image"

# Run the Docker container, ignoring errors
log "Running Docker container on port $DOCKER_PORT (errors will be ignored)..."
docker run --rm -p "${DOCKER_PORT}:${DOCKER_PORT}" "$DOCKER_IMAGE_NAME" || log "Error occurred while running the container (ignored)."

log "Script executed successfully!"
