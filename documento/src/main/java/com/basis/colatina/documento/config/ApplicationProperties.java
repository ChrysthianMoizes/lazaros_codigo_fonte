package com.basis.colatina.documento.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application")
@Configuration
@Getter
@Setter
public class ApplicationProperties {

    private MinioProperties minio;

    @Getter
    @Setter
    public static final class MinioProperties {
        private String bucket;
        private String url;
        private String username;
        private String password;
    }
}
