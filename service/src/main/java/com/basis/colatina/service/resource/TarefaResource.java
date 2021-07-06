package com.basis.colatina.service.resource;

import com.basis.colatina.service.service.TarefaService;
import com.basis.colatina.service.service.dto.TarefaDTO;
import com.basis.colatina.service.service.elasticsearch.TarefaElasticsearchService;
import com.basis.colatina.service.service.filter.TarefaFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {
    
    private final TarefaService tarefaService;

    private final TarefaElasticsearchService tarefaElasticsearchService;

    @PostMapping("/search")
    public ResponseEntity<Page<TarefaDTO>> listar(@RequestBody TarefaFilter filter, Pageable pageable) {
        Page<TarefaDTO> dtos = tarefaElasticsearchService.search(filter, pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable("id") Long id) {
        TarefaDTO dto = tarefaService.obterPorId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> salvar(@RequestBody @Validated TarefaDTO entidade) {
        TarefaDTO dto = tarefaService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> alterar(@RequestBody @Validated TarefaDTO entidade) {
        TarefaDTO dto = tarefaService.salvar(entidade);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        tarefaService.excluir(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
