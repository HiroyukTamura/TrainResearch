// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote;

import org.springframework.web.client.RestTemplate;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;

public interface Restable
{
    void beforeExecuting(final DataCallWrapper p0);
    
    void completeExecute(final DataCallWrapper p0);
    
    RestTemplate getRestTemplate();
    
    Object getService();
}
