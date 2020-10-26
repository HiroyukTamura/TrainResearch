// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;

public interface DataFetcher<T>
{
    void cancel();
    
    void cleanup();
    
    String getId();
    
    T loadData(final Priority p0) throws Exception;
}
