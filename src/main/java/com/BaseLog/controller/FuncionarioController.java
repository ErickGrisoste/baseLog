package com.BaseLog.controller;

import com.BaseLog.dto.FuncionarioDTO;
import com.BaseLog.dto.LoginDTO;
import com.BaseLog.model.Funcionario;
import com.BaseLog.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @PostMapping("cadastrar")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario){
        return ResponseEntity.ok(funcionarioService.cadastarFuncionario(funcionario));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        return funcionarioService.login(loginDTO);
    }

}
