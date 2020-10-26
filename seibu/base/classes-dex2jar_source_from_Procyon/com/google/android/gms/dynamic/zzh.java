// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

final class zzh implements zzi
{
    private /* synthetic */ zza zzaSv;
    
    zzh(final zza zzaSv) {
        this.zzaSv = zzaSv;
    }
    
    @Override
    public final int getState() {
        return 5;
    }
    
    @Override
    public final void zzb(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSv.zzaSr.onResume();
    }
}
