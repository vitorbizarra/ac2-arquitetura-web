package com.example.ac2.dtos.funcionario;

import java.util.List;

import com.example.ac2.dtos.setor.DadosSetorDTO;
import com.example.ac2.models.Projeto;
import com.example.ac2.models.Setor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosFuncionarioDTO {
    private Long id;
    private String nome;
    private Setor setor;
    private List<Projeto> projetos;
}
