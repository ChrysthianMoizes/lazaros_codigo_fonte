package com.basis.colatina.service.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AnexoDTO implements Serializable {

    private Long id;

    private Long idTarefa;

    private String titulo;

    private String hash;

    private String tipo;

    private String tamanho;
}
