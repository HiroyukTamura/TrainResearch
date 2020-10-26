// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Looper;

final class zzces implements Runnable
{
    private /* synthetic */ zzcer zzbpB;
    
    zzces(final zzcer zzbpB) {
        this.zzbpB = zzbpB;
    }
    
    @Override
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzbpB.zzboe.zzwE().zzj(this);
        }
        else {
            final boolean zzbo = this.zzbpB.zzbo();
            zzcer.zza(this.zzbpB, 0L);
            if (zzbo && this.zzbpB.zzbpA) {
                this.zzbpB.run();
            }
        }
    }
}
