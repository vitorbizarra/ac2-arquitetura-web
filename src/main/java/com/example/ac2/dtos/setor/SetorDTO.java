package com.example.ac2.dtos.setor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorDTO {
    private Long id;
    private String nome;
    private int setorId;
}
