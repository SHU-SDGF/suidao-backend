package com.tunnel.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@ConfigurationProperties(prefix = "cip")
@Setter
@Getter
public class AppProperties {

    private String directory;

    private String kettleUrl;

    private String sparkExecutorUrl;

    private String logFile;

    private String notificationServiceUrl;

    private String userMgmtUrl;

    private String token;

    private String appName;

    private String appLogicalName;

    private String appLink;

    private String hadoopDesPath;

    private String muleURL;
    
    private String emailServiceUrl;
    
    private String emailPlainCreds;


    public String getDocsDirectory(String user) {
        return directory + File.separator + user + File.separator;
    }

}