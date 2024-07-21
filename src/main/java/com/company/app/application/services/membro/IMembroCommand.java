package com.company.app.application.services.membro;

import com.company.app.application.dtos.MembroDTO;

public interface IMembroCommand {
    MembroDTO save(MembroDTO dto);
    MembroDTO update(MembroDTO dto);
    Void delete(Long id);
}
