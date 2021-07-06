package com.basis.colatina.service.resource;

import com.basis.colatina.service.service.elasticsearch.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/elasticsearch/reindex")
public class ElasticsearchResource {

    private final ElasticsearchService elasticsearchService;

    @GetMapping
    public ResponseEntity<String> reindex() {
        elasticsearchService.reindex();
        return ResponseEntity.ok().body("Reindexando todas as entidades do sistema");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindexEntity(@PathVariable String entity) {
        elasticsearchService.reindexEntity(entity);
        return ResponseEntity.ok().body("Reindexando " + entity);
    }
}
