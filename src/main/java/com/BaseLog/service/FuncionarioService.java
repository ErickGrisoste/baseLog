package com.BaseLog.service;

import com.BaseLog.dto.FuncionarioDTO;
import com.BaseLog.dto.LoginDTO;
import com.BaseLog.model.Base;
import com.BaseLog.model.Funcionario;
import com.BaseLog.model.StatusFuncionario;
import com.BaseLog.repository.BaseRepository;
import com.BaseLog.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Funcionario cadastarFuncionario(FuncionarioDTO funcionario) {
        Funcionario f = new Funcionario(funcionario);
        f.setSenha(passwordEncoder.encode(f.getSenha()));
        f.setStatusFuncionario(StatusFuncionario.OFF);
        Optional<Base> base = baseRepository.findById(funcionario.base().getId());
        if (base.isPresent()){
            Base baseEncontrada = base.get();
            baseEncontrada.addFuncionario(f);
            baseRepository.save(baseEncontrada);
        }
        return funcionarioRepository.save(f);
    }

    public ResponseEntity<String> login(LoginDTO login) {
        Funcionario funcionario = funcionarioRepository.findByEmail(login.email()).
                orElseThrow(() -> new RuntimeException("Email não encontrado"));

       boolean senhaCorreta = passwordEncoder.matches(login.senha(), funcionario.getSenha());

       if(senhaCorreta){
            return ResponseEntity.ok("Bem vindo, " + funcionario.getNome() + "!");
       }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
    }

    public Optional<Funcionario> autenticar(String email, String senha){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findByEmail(email);

        if(funcionarioOptional.isPresent()){
            Funcionario funcionario = funcionarioOptional.get();
            if(passwordEncoder.matches(senha, funcionario.getSenha())){
                return Optional.of(funcionario);
            }
        }
        return Optional.empty();
    }


    public StatusFuncionario alterarStatus(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        StatusFuncionario novoStatus = funcionario.getStatusFuncionario() == StatusFuncionario.ON
                ? StatusFuncionario.OFF
                : StatusFuncionario.ON;

        funcionario.setStatusFuncionario(novoStatus);
        funcionarioRepository.save(funcionario);

        return novoStatus;
    }


    public FuncionarioDTO buscarFuncionario(Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if(funcionarioOptional.isPresent()){
           Funcionario f = funcionarioOptional.get();
           return new FuncionarioDTO(f.getNome(), f.getId(), f.getBase(), f.getEmail(), f.getSenha(),
                   f.getCargo(), f.getStatusFuncionario());
        }
        return null;
    }
}
