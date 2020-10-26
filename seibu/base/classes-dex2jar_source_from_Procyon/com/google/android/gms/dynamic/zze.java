// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

final class zze implements zzi
{
    private /* synthetic */ zza zzaSv;
    private /* synthetic */ FrameLayout zzaSx;
    private /* synthetic */ LayoutInflater zzaSy;
    private /* synthetic */ ViewGroup zzaSz;
    private /* synthetic */ Bundle zzxV;
    
    zze(final zza zzaSv, final FrameLayout zzaSx, final LayoutInflater zzaSy, final ViewGroup zzaSz, final Bundle zzxV) {
        this.zzaSv = zzaSv;
        this.zzaSx = zzaSx;
        this.zzaSy = zzaSy;
        this.zzaSz = zzaSz;
        this.zzxV = zzxV;
    }
    
    @Override
    public final int getState() {
        return 2;
    }
    
    @Override
    public final void zzb(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSx.removeAllViews();
        this.zzaSx.addView(this.zzaSv.zzaSr.onCreateView(this.zzaSy, this.zzaSz, this.zzxV));
    }
}
