package com.example.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    /*
     *
     * No repositório ProjetoRepository crie um método que passamos o ID do
     * projeto e ele retornará os dados do projeto e a lista de funcionários
     * vinculados aquele projeto.
     */
    @Query("SELECT f FROM Funcionario f LEFT JOIN FETCH f.projetos f WHERE f.id = :id")
    Funcionario findFuncionarioFetchProjetos(@Param("id") Long id);
}
