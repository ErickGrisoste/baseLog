package com.BaseLog.service;

import com.BaseLog.dto.FuncionarioDTO;
import com.BaseLog.dto.LoginDTO;
import com.BaseLog.model.Base;
import com.BaseLog.model.Funcionario;
import com.BaseLog.repository.BaseRepository;
import com.BaseLog.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private BaseRepository baseRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Funcionario cadastarFuncionario(FuncionarioDTO funcionario) {
        Funcionario f = new Funcionario(funcionario);
        f.setSenha(passwordEncoder.encode(f.getSenha()));
        Optional<Base> base = baseRepository.findById(funcionario.base().getId());
        if (base.isPresent()){
            Base baseEncontrada = base.get();
            baseEncontrada.addFuncionario(f);
            baseRepository.save(baseEncontrada);
        }
        return funcionarioRepository.save(f);
    }

    public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        Funcionario funcionario = funcionarioRepository.findByEmail(login.email()).
                orElseThrow(() -> new RuntimeException("Email não encontrado"));

       boolean senhaCorreta = passwordEncoder.matches(login.senha(), funcionario.getSenha());

       if(senhaCorreta){
            return ResponseEntity.ok("Bem vindo, " + funcionario.getNome() + "!");
       }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
    }
}
