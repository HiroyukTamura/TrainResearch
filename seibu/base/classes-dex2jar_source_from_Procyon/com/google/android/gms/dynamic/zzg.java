// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

final class zzg implements zzi
{
    private /* synthetic */ zza zzaSv;
    
    zzg(final zza zzaSv) {
        this.zzaSv = zzaSv;
    }
    
    @Override
    public final int getState() {
        return 4;
    }
    
    @Override
    public final void zzb(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSv.zzaSr.onStart();
    }
}
