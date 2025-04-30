package com.BaseLog.controller;

import com.BaseLog.model.Base;
import com.BaseLog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Base> cadastrarBase(@RequestBody Base base){
        return ResponseEntity.ok(baseService.cadastrarBase(base));
    }

}
