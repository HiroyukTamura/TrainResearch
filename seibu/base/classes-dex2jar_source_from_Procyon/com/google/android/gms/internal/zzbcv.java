// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class zzbcv extends zzbdl
{
    private WeakReference<zzbcp> zzaDR;
    
    zzbcv(final zzbcp referent) {
        this.zzaDR = new WeakReference<zzbcp>(referent);
    }
    
    @Override
    public final void zzpA() {
        final zzbcp zzbcp = this.zzaDR.get();
        if (zzbcp == null) {
            return;
        }
        zzbcp.resume();
    }
}
