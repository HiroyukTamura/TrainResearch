// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class Response<T extends Result>
{
    private T zzaBj;
    
    public Response() {
    }
    
    protected Response(@NonNull final T zzaBj) {
        this.zzaBj = zzaBj;
    }
    
    @NonNull
    protected T getResult() {
        return this.zzaBj;
    }
    
    public void setResult(@NonNull final T zzaBj) {
        this.zzaBj = zzaBj;
    }
}
