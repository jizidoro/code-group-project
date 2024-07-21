package com.company.app.application.services.pessoa;

import com.company.app.application.dtos.PessoaDTO;

public interface IPessoaCommand {
    PessoaDTO save(PessoaDTO dto);
    PessoaDTO update(PessoaDTO dto);
    Void delete(Long id);
}
