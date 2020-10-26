// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.Bundle;

final class zzd implements zzi
{
    private /* synthetic */ zza zzaSv;
    private /* synthetic */ Bundle zzxV;
    
    zzd(final zza zzaSv, final Bundle zzxV) {
        this.zzaSv = zzaSv;
        this.zzxV = zzxV;
    }
    
    @Override
    public final int getState() {
        return 1;
    }
    
    @Override
    public final void zzb(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSv.zzaSr.onCreate(this.zzxV);
    }
}
