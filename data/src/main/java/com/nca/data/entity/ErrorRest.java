package com.nca.data.entity;

import java.lang.*;


public class ErrorRest extends Error{

    private String codeServerError;

    public ErrorRest(ErrorType frendlyError) {
        super(frendlyError);
    }
}
