package com.basis.colatina.service.resource;

import com.basis.colatina.service.service.ResponsavelService;
import com.basis.colatina.service.service.dto.ResponsavelDTO;
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
@RequestMapping("/api/responsaveis")
@RequiredArgsConstructor
public class ResponsavelResource {
    
    private final ResponsavelService responsavelService;

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> listar() {
        List<ResponsavelDTO> dtos = responsavelService.listar();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelDTO> obterPorId(@PathVariable("id") Long id) {
        ResponsavelDTO dto = responsavelService.obterPorId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponsavelDTO> salvar(@RequestBody @Validated ResponsavelDTO entidade) {
        ResponsavelDTO dto = responsavelService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponsavelDTO> alterar(@RequestBody @Validated ResponsavelDTO entidade) {
        ResponsavelDTO dto = responsavelService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        responsavelService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
