package com.BaseLog.service;

import com.BaseLog.model.Funcionario;
import com.BaseLog.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Funcionario cadastarFuncionario(Funcionario funcionario) {
        funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
        return funcionarioRepository.save(funcionario);
    }
}
