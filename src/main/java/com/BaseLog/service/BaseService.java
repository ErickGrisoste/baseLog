package com.BaseLog.service;

import com.BaseLog.dto.BaseDTO;
import com.BaseLog.model.Base;
import com.BaseLog.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BaseService {
    @Autowired
    private BaseRepository baseRepository;

    public List<BaseDTO> listarBases(){
        baseRepository.findAll().forEach(base -> base.atualizarStatus(base.getFuncionarios()));
        return baseRepository.findAll().stream().map(b ->
                new BaseDTO(b.getId(), b.getEndereco(), b.getFuncionarios(), b.getStatus())).
                collect(Collectors.toList());
    }

    public Base cadastrarBase(Base base) {
        return baseRepository.save(base);
    }

    public BaseDTO buscarBase(Long baseId) {
        Optional<Base> base = baseRepository.findById(baseId);
        if (base.isPresent()){
            return base.map(b ->
                    new BaseDTO(b.getId(), b.getEndereco(), b.getFuncionarios(), b.getStatus()))
                    .orElseThrow();
        }
        throw new RuntimeException("Base não encontrada.");
    }
}
