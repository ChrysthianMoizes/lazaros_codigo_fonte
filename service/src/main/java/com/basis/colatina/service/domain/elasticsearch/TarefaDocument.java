package com.basis.colatina.service.domain.elasticsearch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDateTime;

@Document(indexName = "lazaros-tarefas")
@Getter
@Setter
@Setting(settingPath = "/config/elasticsearch/elasticsearch-config.json")
public class TarefaDocument extends BaseDocument {

    @MultiField(mainField = @Field(type = FieldType.Text, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)
            })
    private String titulo;

    @MultiField(mainField = @Field(type = FieldType.Date, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Date, store = true)
            })
    private LocalDateTime dataInicioPrevista;

    private LocalDateTime dataTerminoPrevista;

    private LocalDateTime dataInicio;

    private LocalDateTime datatermino;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)
            })
    private String tipo;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)
            })
    private String status;

    @MultiField(mainField = @Field(type = FieldType.Text, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)
            })
    private String responsavel;

    public TarefaDocument(Long id, String titulo, LocalDateTime dataInicioPrevista, LocalDateTime dataTerminoPrevista, LocalDateTime dataInicio, LocalDateTime datatermino, String tipo, String status, String responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.dataInicioPrevista = dataInicioPrevista;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.dataInicio = dataInicio;
        this.datatermino = datatermino;
        this.tipo = tipo;
        this.status = status;
        this.responsavel = responsavel;
    }
}
