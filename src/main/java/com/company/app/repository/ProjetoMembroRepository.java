package com.company.app.repository;

import com.company.app.model.ProjetoMembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoMembroRepository extends JpaRepository<ProjetoMembro, Long> {
}