package com.company.app.core.bases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class UseCaseFacade {
    private final UseCaseManager manager;
    private final Validator validator;

    @Autowired
    public UseCaseFacade(UseCaseManager manager, Validator validator) {
        this.manager = manager;
        this.validator = validator;
    }

    @Transactional
    public <T> T execute(UseCase<T> usecase) {
        manager.prepare(usecase);
        validate(usecase);
        try {
            T res = executeAndHandleExceptions(usecase);
            manager.complete(usecase);
            return res;
        } finally {
            manager.destroy(usecase);
        }
    }

    private <T> T executeAndHandleExceptions(UseCase<T> prepared) {
        try {
            return prepared.execute();
        } catch (Exception e) {
            throw new UnexpectedUseCaseException(prepared.getClass(), e);
        }
    }

    protected void validate(Object usecase) {
        Set<ConstraintViolation<Object>> violations = validator.validate(usecase,
                UseCaseValidationOrder.class);
        if (!violations.isEmpty()) {
            throw new UnexpectedUseCaseException();
        }
    }
}