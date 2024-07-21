package com.company.app.core.bases;

import java.io.Serial;

public class UnexpectedUseCaseException extends RuntimeException {
    @Serial private static final long serialVersionUID = 1L;

    protected UnexpectedUseCaseException() {
        super();
    }

    protected UnexpectedUseCaseException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    protected UnexpectedUseCaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedUseCaseException(String message) {
        super(message);
    }

    protected UnexpectedUseCaseException(Throwable cause) {
        super(cause);
    }

    protected UnexpectedUseCaseException(Class<?> useCaseType, Throwable cause) {
        super("Erro ao executar caso de uso " + useCaseType.getSimpleName()
                + ": " + cause.getLocalizedMessage(), cause);
    }
}
