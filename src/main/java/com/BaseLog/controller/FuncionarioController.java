package com.BaseLog.controller;

import com.BaseLog.dto.FuncionarioDTO;
import com.BaseLog.dto.LoginDTO;
import com.BaseLog.model.Funcionario;
import com.BaseLog.model.StatusFuncionario;
import com.BaseLog.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @PostMapping("cadastrar")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionario){
        return ResponseEntity.ok(funcionarioService.cadastarFuncionario(funcionario));
    }

    @GetMapping("/buscar/{id}")
    public FuncionarioDTO buscarFuncionario(@PathVariable Long id){
        return funcionarioService.buscarFuncionario(id);
    }


    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        Optional<Funcionario> f = funcionarioService.autenticar(loginDTO.email(), loginDTO.senha());
        return funcionarioService.login(loginDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody LoginDTO loginDTO){
        Optional<Funcionario> f = funcionarioService.autenticar(loginDTO.email(), loginDTO.senha());

        if(f.isPresent()){
            Funcionario funcionario = f.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", funcionario.getId());
            response.put("nome", funcionario.getNome());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credencias invalidas");
        }
    }


    @PutMapping("/bater-ponto/{id}")
    public ResponseEntity<String> alterarStatus(@PathVariable Long id) {
        StatusFuncionario novoStatus = funcionarioService.alterarStatus(id);
        return ResponseEntity.ok("Funcionário está " + novoStatus.name() + ".");
    }


}
