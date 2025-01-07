# FROM jboss/wildfly:21.0.1.Final
FROM jboss/wildfly:17.0.0.Final


# Definindo a variável JAVA_OPTS com --add-opens
ENV JAVA_OPTS="$JAVA_OPTS --add-opens java.base/java.lang=ALL-UNNAMED"

# Deploy artefact
#ADD target/x-lighthouse.war /opt/jboss/wildfly/standalone/deployments/
COPY target/x-lighthouse.war /opt/jboss/wildfly/standalone/deployments/