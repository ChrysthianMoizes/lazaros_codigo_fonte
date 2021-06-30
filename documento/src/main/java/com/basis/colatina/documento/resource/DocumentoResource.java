package com.basis.colatina.documento.resource;

import com.basis.colatina.documento.service.DocumentoService;
import com.basis.colatina.documento.service.dto.DocumentoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoResource {

    private final DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody DocumentoDTO dto) {
        documentoService.salvar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DocumentoDTO> buscar(@PathVariable String uuid) {
        DocumentoDTO file = documentoService.obter(uuid);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> remove(@PathVariable String uuid) {
        documentoService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
