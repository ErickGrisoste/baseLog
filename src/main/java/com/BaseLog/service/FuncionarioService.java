package com.BaseLog.service;

import com.BaseLog.model.Base;
import com.BaseLog.model.Funcionario;
import com.BaseLog.repository.BaseRepository;
import com.BaseLog.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private BaseRepository baseRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Funcionario cadastarFuncionario(Funcionario funcionario) {
        funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
        Optional<Base> base = baseRepository.findById(funcionario.getBase().getId());
        if (base.isPresent()){
            Base baseEncontrada = base.get();
            baseEncontrada.addFuncionario(funcionario);
            baseRepository.save(baseEncontrada);
        }
        return funcionarioRepository.save(funcionario);
    }
}
