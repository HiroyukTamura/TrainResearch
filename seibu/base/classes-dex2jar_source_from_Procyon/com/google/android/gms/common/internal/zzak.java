// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;

public final class zzak
{
    @NonNull
    private final String mPackageName;
    @NonNull
    private final String zzaId;
    private final boolean zzaIe;
    
    public zzak(@NonNull final String mPackageName, @NonNull final String zzaId, final boolean b) {
        this.mPackageName = mPackageName;
        this.zzaId = zzaId;
        this.zzaIe = false;
    }
    
    @NonNull
    final String getPackageName() {
        return this.mPackageName;
    }
    
    @NonNull
    final String zzrE() {
        return this.zzaId;
    }
}
