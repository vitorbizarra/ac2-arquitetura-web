package com.example.ac2.services.funcionario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.funcionario.DadosFuncionarioDTO;
import com.example.ac2.dtos.funcionario.FuncionarioDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    @Override
    public List<DadosFuncionarioDTO> findAll() {
        return funcionarioRepository.findAll()
                .stream()
                .map((Funcionario funcionario) -> {
                    return DadosFuncionarioDTO.builder()
                            .id(funcionario.getId())
                            .nome(funcionario.getNome())
                            .setor(funcionario.getSetor())
                            .projetos(funcionario.getProjetos())
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Funcionario create(FuncionarioDTO funcionario) {
        Setor setor = setorRepository.findById(funcionario.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Funcionario funcionarioObject = new Funcionario();
        funcionarioObject.setId(funcionario.getId());
        funcionarioObject.setNome(funcionario.getNome());

        funcionarioObject.setSetor(setor);

        return funcionarioRepository.save(funcionarioObject);
    }

    @Override
    public DadosFuncionarioDTO findById(Long id) {
        return funcionarioRepository.findById(id).map((Funcionario funcionario) -> {
            return DadosFuncionarioDTO
                    .builder()
                    .id(funcionario.getId())
                    .nome(funcionario.getNome())
                    .setor(funcionario.getSetor())
                    .projetos(funcionario.getProjetos())
                    .build();
        }).orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id fornecido"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario update(Long id, FuncionarioDTO funcionario) {
        Funcionario funcionarioModel = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o id fornecido"));

        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado com o id fornecido"));

        funcionarioModel.setNome(funcionario.getNome());

        funcionarioModel.setSetor(setor);

        return funcionarioRepository.save(funcionarioModel);
    }

}
