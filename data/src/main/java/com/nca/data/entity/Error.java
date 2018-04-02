package com.nca.data.entity;

public class Error extends Exception {

    private ErrorType frendlyError;

    public Error(ErrorType frendlyError) {
        this.frendlyError = frendlyError;
    }

    public ErrorType getFrendlyError() {
        return frendlyError;
    }

}
