// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote.errorhandler;

import com.google.common.eventbus.EventBus;

public class ErrorHandlerEventBus
{
    private static EventBus INSTANCE;
    
    public static EventBus getInstance() {
        if (ErrorHandlerEventBus.INSTANCE == null) {
            ErrorHandlerEventBus.INSTANCE = new EventBus("NetworkErrorBus");
        }
        return ErrorHandlerEventBus.INSTANCE;
    }
}
