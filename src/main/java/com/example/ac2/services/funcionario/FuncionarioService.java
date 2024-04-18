package com.example.ac2.services.funcionario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.funcionario.DadosFuncionarioDTO;
import com.example.ac2.dtos.funcionario.FuncionarioDTO;
import com.example.ac2.models.Funcionario;

@Service
public interface FuncionarioService {
    List<DadosFuncionarioDTO> findAll();

    Funcionario create(FuncionarioDTO funcionario);

    DadosFuncionarioDTO findById(Long id);

    void delete(Long id);

    Funcionario update(Long id, FuncionarioDTO funcionario);
}