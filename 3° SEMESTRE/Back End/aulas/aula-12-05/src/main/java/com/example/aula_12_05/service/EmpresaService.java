package com.example.aula_12_05.service;

import com.example.aula_12_05.entity.Empresa;
import com.example.aula_12_05.exception.NotFoundException;
import com.example.aula_12_05.repository.EmpresaRepository;
import com.sun.jdi.LongValue;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    public List<Empresa> listagem() {
        List<Empresa> todasEmpresas = repository.findAll();
        return todasEmpresas;
    }

    public Empresa buscarId(Long id) {
        Optional<Empresa> byId = repository.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("Nao achei");
        }

        return byId.get();
    }

    public void deletarId(Long id){
        if (!repository.existsById(id)){
            throw new NotFoundException("Nao tem");
        }

        repository.deleteById(id);
    }
}
