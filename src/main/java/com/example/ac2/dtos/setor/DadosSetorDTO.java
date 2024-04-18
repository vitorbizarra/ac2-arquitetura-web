package com.example.ac2.dtos.setor;

import java.util.List;

import com.example.ac2.dtos.funcionario.FuncionarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosSetorDTO {
    private Long id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;
}
