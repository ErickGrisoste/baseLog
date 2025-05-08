package com.BaseLog.dto;

import com.BaseLog.model.Base;
import com.BaseLog.model.StatusFuncionario;

public record FuncionarioDTO(
        String nome,
        Long id,
        Base base,
        String email,
        String senha,
        String cargo,
        StatusFuncionario status
) {
}
