// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.exception;

public class ParameterCountMismatchException extends RuntimeException
{
    public ParameterCountMismatchException(final String str, final int i, final int j) {
        super("Can not call OnApiSuccess method " + str + ", because method parameter count is " + i + ", but received data count is " + j + ".");
    }
}
