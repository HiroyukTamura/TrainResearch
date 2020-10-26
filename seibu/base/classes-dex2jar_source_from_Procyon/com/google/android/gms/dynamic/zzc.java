// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.app.Activity;

final class zzc implements zzi
{
    private /* synthetic */ Activity val$activity;
    private /* synthetic */ zza zzaSv;
    private /* synthetic */ Bundle zzaSw;
    private /* synthetic */ Bundle zzxV;
    
    zzc(final zza zzaSv, final Activity val$activity, final Bundle zzaSw, final Bundle zzxV) {
        this.zzaSv = zzaSv;
        this.val$activity = val$activity;
        this.zzaSw = zzaSw;
        this.zzxV = zzxV;
    }
    
    @Override
    public final int getState() {
        return 0;
    }
    
    @Override
    public final void zzb(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSv.zzaSr.onInflate(this.val$activity, this.zzaSw, this.zzxV);
    }
}
