// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase;

import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;

public class FirebaseException extends Exception
{
    @Deprecated
    protected FirebaseException() {
    }
    
    public FirebaseException(@NonNull final String s) {
        super(zzbo.zzh(s, "Detail message must not be empty"));
    }
    
    public FirebaseException(@NonNull final String s, final Throwable cause) {
        super(zzbo.zzh(s, "Detail message must not be empty"), cause);
    }
}
