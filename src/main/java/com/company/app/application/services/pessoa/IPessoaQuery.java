package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;

public interface IPessoaQuery {
    ListResultDto<PessoaDTO> findAll();
    SingleResultDto<PessoaDTO> findById(Long id);
}
