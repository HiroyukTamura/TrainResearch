// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.auth;

import android.support.annotation.Nullable;

public class GetTokenResult
{
    private String zzakv;
    
    public GetTokenResult(final String zzakv) {
        this.zzakv = zzakv;
    }
    
    @Nullable
    public String getToken() {
        return this.zzakv;
    }
}
