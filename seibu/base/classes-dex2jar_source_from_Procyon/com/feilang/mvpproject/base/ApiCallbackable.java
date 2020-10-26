// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;

public interface ApiCallbackable
{
    boolean isCallerSpecific();
    
    @Subscribe
    void onApiEvent(final DataNotifyEvent p0);
}
