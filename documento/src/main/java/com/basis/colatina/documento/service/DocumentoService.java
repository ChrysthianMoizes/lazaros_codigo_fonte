package com.basis.colatina.documento.service;

import com.basis.colatina.documento.config.ApplicationProperties;
import com.basis.colatina.documento.service.dto.DocumentoDTO;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentoService {

    private final MinioClient minioClient;

    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public void salvar(DocumentoDTO dto) {
        minioClient.putObject(
                PutObjectArgs.builder().bucket(applicationProperties.getMinio().getBucket())
                        .object(dto.getUuid()).stream(new ByteArrayInputStream(dto.getFile().getBytes()),
                        dto.getFile().getBytes().length, 0).build()
        );
        log.info("Documento salvo com sucesso: {}", dto.getUuid());
    }

    @SneakyThrows
    public DocumentoDTO obter(String uuid) {
        InputStream stream = minioClient.getObject(GetObjectArgs.builder()
                .bucket(applicationProperties.getMinio().getBucket())
                .object(uuid).build());

        return new DocumentoDTO(uuid, IOUtils.toString(stream, StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public void delete(String uuid) {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(applicationProperties.getMinio().getBucket()).object(uuid).build());
    }
}
