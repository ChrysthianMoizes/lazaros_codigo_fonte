package com.basis.colatina.documento.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MinioConfiguration {

    private final ApplicationProperties applicationProperties;

    @Bean
    @SneakyThrows
    public MinioClient minioClient()  {
        MinioClient client = MinioClient.builder()
                .endpoint(applicationProperties.getMinio().getUrl())
                .credentials(applicationProperties.getMinio().getUsername(), applicationProperties.getMinio().getPassword()).build();

        if(!client.bucketExists(BucketExistsArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build())) {
            client.makeBucket(MakeBucketArgs.builder().bucket(applicationProperties.getMinio().getBucket()).build());
        }

        return client;
    }

}
