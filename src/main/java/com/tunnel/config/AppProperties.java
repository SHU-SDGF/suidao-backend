package com.tunnel.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tunnel")
@Setter
@Getter
public class AppProperties {

	private String fileUploadBasePath;
}