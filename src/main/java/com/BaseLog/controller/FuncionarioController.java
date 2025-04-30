package com.BaseLog.controller;

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
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(funcionarioService.cadastarFuncionario(funcionario));
    }

}
