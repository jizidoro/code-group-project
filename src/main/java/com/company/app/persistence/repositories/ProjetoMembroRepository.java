package com.company.app.persistence.repositories;

import com.company.app.domain.models.ProjetoMembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoMembroRepository extends JpaRepository<ProjetoMembro, Long> {
}