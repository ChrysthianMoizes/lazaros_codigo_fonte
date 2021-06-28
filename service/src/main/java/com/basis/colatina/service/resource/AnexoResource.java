package com.basis.colatina.service.resource;

import com.basis.colatina.service.service.AnexoService;
import com.basis.colatina.service.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anexos")
@RequiredArgsConstructor
public class AnexoResource {
    
    private final AnexoService anexoService;

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> listar() {
        List<AnexoDTO> entidades = anexoService.listar();
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> obterPorId(@PathVariable("id") Long id) {
        AnexoDTO entidade = anexoService.obterPorId(id);
        return new ResponseEntity<>(entidade, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnexoDTO> salvar(@RequestBody @Validated AnexoDTO entidade) {
        AnexoDTO dto = anexoService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AnexoDTO> alterar(@RequestBody @Validated AnexoDTO entidade) {
        AnexoDTO dto = anexoService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        anexoService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
