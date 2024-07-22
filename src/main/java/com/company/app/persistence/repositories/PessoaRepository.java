package com.company.app.persistence.repositories;

import com.company.app.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
