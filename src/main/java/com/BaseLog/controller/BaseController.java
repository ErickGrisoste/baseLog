package com.BaseLog.controller;

import com.BaseLog.dto.BaseDTO;
import com.BaseLog.model.Base;
import com.BaseLog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Base> cadastrarBase(@RequestBody Base base){
        return ResponseEntity.ok(baseService.cadastrarBase(base));
    }

    @GetMapping("/listar")
    public List<BaseDTO> listarBases(){
        return baseService.listarBases();
    }

    @GetMapping("/{baseId}")
    public BaseDTO detalharBase(@PathVariable Long baseId){
        return baseService.buscarBase(baseId);
    }

}
