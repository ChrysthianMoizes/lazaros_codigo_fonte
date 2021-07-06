package com.basis.colatina.service.service.filter;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.index.query.BoolQueryBuilder;

import java.io.Serializable;

@Getter
@Setter
public class TarefaFilter implements BaseFilter, Serializable {

    private String query;

    @Override
    public BoolQueryBuilder getFilter() {
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        addMustTermQuery(queryBuilder, "titulo", query);
        return queryBuilder;
    }
}
