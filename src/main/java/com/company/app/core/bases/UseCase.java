package com.company.app.core.bases;

public abstract class UseCase<T> {
    protected abstract T execute() throws Exception;
}
