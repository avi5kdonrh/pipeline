package io.fabric8.quickstarts.camel.amq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration parameters filled in from application.properties and overridden using env variables on Openshift.
 */
@Configuration
@ConfigurationProperties(prefix = "amq-camel")
public class CoreConfiguration {

    @Value("${url:tcp://localhost:61616}")
    private String url;

    @Value("${userName:admin}")
    private String user;

    @Value("${password:admin}")
    private String password;

    @Value("${maxConnections:25}")
    private int maxConnections;

    @Value("${maxSessionsPerConnection:1}")
    private int maxSessionsPerConnection;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMaxSessionsPerConnection() {
        return maxSessionsPerConnection;
    }

    public void setMaxSessionsPerConnection(int maxSessionsPerConnection) {
        this.maxSessionsPerConnection = maxSessionsPerConnection;
    }
}
