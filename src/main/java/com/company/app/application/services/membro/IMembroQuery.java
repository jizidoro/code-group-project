package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;
import com.company.app.application.responseObjects.ListResultDto;
import com.company.app.application.responseObjects.SingleResultDto;

public interface IMembroQuery {
    ListResultDto<MembroDTO> findAll();
    SingleResultDto<MembroDTO> findById(Long id);
}
