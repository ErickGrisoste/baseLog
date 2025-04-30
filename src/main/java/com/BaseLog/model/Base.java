package com.BaseLog.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "bases")
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Endereco endereco;
    @OneToMany(mappedBy = "base")
    private List<Funcionario> funcionarios;
    private Status status;
}
