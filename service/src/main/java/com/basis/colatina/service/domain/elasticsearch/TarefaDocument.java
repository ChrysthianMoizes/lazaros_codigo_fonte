package com.basis.colatina.service.domain.elasticsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class TarefaDocument extends BaseDocument {

    @MultiField(mainField = @Field(type = FieldType.Text, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text, store = true)
            })
    private String titulo;

    private String dataInicioPrevista;

    private String dataTerminoPrevista;

    private String dataInicio;

    private String datatermino;

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
        this.dataInicioPrevista = dataInicioPrevista.toString();
        this.dataTerminoPrevista = dataTerminoPrevista.toString();
        this.dataInicio = dataInicio.toString();
        this.datatermino = datatermino.toString();
        this.tipo = tipo;
        this.status = status;
        this.responsavel = responsavel;
    }
}
