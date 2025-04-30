package com.BaseLog.dto;

import com.BaseLog.model.Base;
import com.BaseLog.model.Endereco;
import com.BaseLog.model.Funcionario;
import com.BaseLog.model.Status;

import java.util.List;

public record BaseDTO(
        Long id,
        Endereco endereco,
        List<Funcionario> funcionarios,
        Status status) {
}
