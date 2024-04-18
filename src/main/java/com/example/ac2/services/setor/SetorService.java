package com.example.ac2.services.setor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.setor.DadosSetorDTO;
import com.example.ac2.dtos.setor.SetorDTO;
import com.example.ac2.models.Setor;

@Service
public interface SetorService {
    List<DadosSetorDTO> findAll();

    Setor create(SetorDTO setor);

    DadosSetorDTO findById(Long id);

    void delete(Long id);

    Setor update(Long id, SetorDTO setor);
}