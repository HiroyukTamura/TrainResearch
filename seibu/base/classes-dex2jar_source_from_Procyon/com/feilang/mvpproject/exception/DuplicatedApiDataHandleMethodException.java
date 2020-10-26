// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.exception;

import com.feilang.mvpproject.data.datasource.DataNotifyEvent;

public class DuplicatedApiDataHandleMethodException extends RuntimeException
{
    public DuplicatedApiDataHandleMethodException(final DataNotifyEvent.ApiEventType obj, final String str) {
        super("Duplicated API handle method for type " + obj + " in class " + str);
    }
}
