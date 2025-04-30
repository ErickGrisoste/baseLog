package com.BaseLog.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco{
    private String logradouro;
    private int numero;
    private String cep;
    private String cidade;
    private String bairro;
    private String estado;

}
