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
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void atualizarStatus(List<Funcionario> funcionarios){
        setStatus(Status.FECHADA);
        for(Funcionario f : funcionarios){
            if (f.getStatusFuncionario().equals(StatusFuncionario.ON)){
                setStatus(Status.OPERANTE);
                break;
            }
        }
    }

}
