// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.datasource;

import com.google.common.eventbus.EventBus;

public class DataNotifyEventBus extends EventBus
{
    private static EventBus INSTANCE;
    
    public static EventBus getInstance() {
        if (DataNotifyEventBus.INSTANCE == null) {
            DataNotifyEventBus.INSTANCE = new EventBus("DataNotifyEventBus");
        }
        return DataNotifyEventBus.INSTANCE;
    }
}
