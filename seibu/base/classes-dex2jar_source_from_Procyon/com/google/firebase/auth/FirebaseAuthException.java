// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException
{
    private final String zzbWl;
    
    public FirebaseAuthException(@NonNull final String s, @NonNull final String s2) {
        super(s2);
        this.zzbWl = zzbo.zzcF(s);
    }
    
    @NonNull
    public String getErrorCode() {
        return this.zzbWl;
    }
}
