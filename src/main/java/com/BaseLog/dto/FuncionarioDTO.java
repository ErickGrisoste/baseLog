package com.BaseLog.dto;

import com.BaseLog.model.Base;

public record FuncionarioDTO(
        String nome,
        Long id,
        Base base,
        String email,
        String senha,
        String cargo
) {
}
