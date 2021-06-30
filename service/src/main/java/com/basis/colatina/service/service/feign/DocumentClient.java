package com.basis.colatina.service.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "documento", url = "${application.feign.documento}")
public interface DocumentClient {

    @GetMapping("/api/documentos")
    String upload();
}
