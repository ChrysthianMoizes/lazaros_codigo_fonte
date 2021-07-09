package com.basis.colatina.service.config;

import com.basis.colatina.service.service.feign.DocumentClient;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
public class MockConfiguration {

    @MockBean
    private DocumentClient documentClient;

    @PostConstruct
    public void mock() {
        Mockito.when(documentClient.upload()).thenReturn(UUID.randomUUID().toString());
    }

}
