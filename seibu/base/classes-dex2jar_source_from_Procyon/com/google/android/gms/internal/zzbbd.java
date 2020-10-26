// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.Dialog;

final class zzbbd extends zzbdl
{
    private /* synthetic */ Dialog zzaBT;
    private /* synthetic */ zzbbc zzaBU;
    
    zzbbd(final zzbbc zzaBU, final Dialog zzaBT) {
        this.zzaBU = zzaBU;
        this.zzaBT = zzaBT;
    }
    
    @Override
    public final void zzpA() {
        this.zzaBU.zzaBS.zzpx();
        if (this.zzaBT.isShowing()) {
            this.zzaBT.dismiss();
        }
    }
}
