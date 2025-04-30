package com.BaseLog.service;

import com.BaseLog.model.Base;
import com.BaseLog.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    private BaseRepository baseRepository;

    public List<Base> listarBases(){
        return baseRepository.findAll();
    }

    public Base cadastrarBase(Base base) {
        return baseRepository.save(base);
    }
}
