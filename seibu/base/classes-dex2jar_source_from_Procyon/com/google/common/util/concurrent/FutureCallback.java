// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.util.concurrent;

import javax.annotation.Nullable;

public interface FutureCallback<V>
{
    void onFailure(final Throwable p0);
    
    void onSuccess(@Nullable final V p0);
}
