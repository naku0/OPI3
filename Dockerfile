FROM jboss/wildfly:26.1.3.Final

LABEL authors="naku0 <https://github.com/naku0>"

WORKDIR /opt/jboss/wildfly/standalone/deployments/

COPY target/my-little-jsf-app.war /opt/jboss/wildfly/standalone/deployments/ROOT.war
COPY ./postgres-ds.xml /opt/jboss/wildfly/standalone/configuration/
COPY ./lib/postgresql-42.7.4.jar /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
