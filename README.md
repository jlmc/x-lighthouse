# x-lighthouse

x-Lighthouse is a Jakarta EE demo project that demonstrates the use of PrimeFaces for building modern web applications.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

1. WildFly Application Server
   - This project is built with Java EE 8, so you need WildFly version 17 or earlier.
   - Download WildFly version 17.0.0 from: [WildFly 17.0.0 Final](https://download.jboss.org/wildfly/17.0.1.Final/wildfly-17.0.1.Final.zip)  
2. Java Development Kit (JDK)
   - The source code is built using JDK 11, and WildFly requires JDK 11.
   - Ensure that your JAVA_HOME environment variable points to a JDK 11 installation.
3. Maven
   - Maven is required to build the project. Install Maven and ensure it is in your system’s PATH.

---

## How to Bootstrap Locally

Follow these steps to set up and run the project:

1. Set Up WildFly
   1. Download the Wildfly 17.0.0 application server from Wildfly website: [WildFly 17.0.0 Final](https://download.jboss.org/wildfly/17.0.1.Final/wildfly-17.0.1.Final.zip)
   2. Unzip the WildFly archive to a directory of your choice. For example:
      ```sh
      mkdir -p ~/app-servers
      unzip wildfly-17.0.0.Final.zip -d ~/app-servers
      ```
2. Build the Project
   ```sh
   mvn clean package
   ```
3. Deploy the Application

   1. Copy the built WAR file (target/x-lighthouse.war) to WildFly's deployment directory:
      ```sh
      cp target/x-lighthouse.war ~/app-servers/wildfly-17.0.0.Final/standalone/deployments/x-lighthouse.war
      ```
4. Start WildFly
   1. Set the required Java options:
      ```sh
      export JAVA_OPTS="$JAVA_OPTS --add-opens java.base/java.lang=ALL-UNNAMED"
      ```  
   2. Start the application server:
      ```sh
      ~/app-servers/wildfly-17.0.0.Final/bin/standalone.sh
      ```
5. Access the Application
   1. Open your web browser and navigate to:
      http://localhost:8080/x-lighthouse

---

## Run in a Docker Container

You can also build and run the application using Docker. Follow these steps:

1. Ensure your JAVA_HOME points to JDK 11:
   ```sh
   export JAVA_HOME=$(/usr/libexec/java_home -v 11)
   java -version
   ```
   
2. Build the project using Maven:
   ```sh
   mvn clean package
   ```

3. Build the Docker image:
   ```sh
   docker build -t x-lighthouse .
   ```

4. Run the application in a Docker container:
   ```sh
   docker run --rm -p "8080:8080" x-lighthouse
   ```

## Alternative: Using the Provided Script

For convenience, a script (`build-and-run-in-docker-container.sh`) is included in the repository. This script simplifies the process of building and running the Docker container. You can execute it as follows:

```sh
./build-and-run-in-docker-container.sh
```

## Alternative: Using a multi-stage dockerfile

Useful if you don't have java or even maven installed in you machine.

```sh

docker build -t t2 -f Dockerfile-multi-stage .
docker run --rm -p "8080:8080" t2
```

## Alternative: Using a multi-stage dockerfile

For convenience, there is also in the repository a `docker-compose.yaml` that can be used to bootstrap the application locally:

```sh
docker compose up -d
```


## Notes

- Make sure that the required ports (e.g., 8080) are available and not blocked by a firewall or another application.
- WildFly requires JDK 11 for runtime. Ensure that you switch to the appropriate JDK version if you are using a higher version (e.g., JDK 11) for building the project.

With this setup, you can run x-Lighthouse either locally or in a Docker container to explore Jakarta EE with PrimeFaces!






