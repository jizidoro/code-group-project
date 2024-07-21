package com.company.app.application.services.projeto;

import com.company.app.application.dtos.ProjetoDTO;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;

public interface IProjetoQuery {
    ListResultDto<ProjetoDTO> findAll();
    SingleResultDto<ProjetoDTO> findById(Long id);
}
