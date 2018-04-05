package com.jet.mail.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 * <pre>
 * </pre>
 *
 * @author javahuang
 * @since 2017/12/22
 */
@ConfigurationProperties(prefix = "third-service.mail")
public class MailProperties {

    private String serverRequestUrl;

    public String getServerRequestUrl() {
        return serverRequestUrl;
    }

    public void setServerRequestUrl(String serverRequestUrl) {
        this.serverRequestUrl = serverRequestUrl;
    }
}
