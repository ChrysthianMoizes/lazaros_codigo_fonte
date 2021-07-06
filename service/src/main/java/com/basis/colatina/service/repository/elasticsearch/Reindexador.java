package com.basis.colatina.service.repository.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Reindexador {

    String getEntity();

    default <T> Page<T> reindexPage(Pageable pageable) {
        throw new IllegalAccessError("Method not implemented.");
    }
}
