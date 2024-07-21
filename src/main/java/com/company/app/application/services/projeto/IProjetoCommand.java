package com.company.app.application.services.projeto;

import com.company.app.application.dtos.ProjetoDTO;

public interface IProjetoCommand {
    ProjetoDTO save(ProjetoDTO dto);
    ProjetoDTO update(ProjetoDTO dto);
    Void delete(Long id);
}
