// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;

final class zzcjc extends zzcer
{
    private /* synthetic */ zzcja zzbuu;
    
    zzcjc(final zzcja zzbuu, final zzcgl zzcgl) {
        this.zzbuu = zzbuu;
        super(zzcgl);
    }
    
    @WorkerThread
    @Override
    public final void run() {
        this.zzbuu.zzzp();
    }
}
