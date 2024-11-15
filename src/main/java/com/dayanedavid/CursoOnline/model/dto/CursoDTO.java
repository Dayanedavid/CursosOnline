package com.dayanedavid.CursoOnline.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CursoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Date dataCriacao;
}
