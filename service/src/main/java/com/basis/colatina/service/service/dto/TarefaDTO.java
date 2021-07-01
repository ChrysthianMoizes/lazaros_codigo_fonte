package com.basis.colatina.service.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TarefaDTO implements Serializable {

    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataInicioPrevista;

    private LocalDateTime dataTerminoPrevista;

    private LocalDateTime dataInicio;

    private LocalDateTime dataTermino;

    private String tipo;

    private String status;

    private String comentarios;

    private Long idResponsavel;
}
