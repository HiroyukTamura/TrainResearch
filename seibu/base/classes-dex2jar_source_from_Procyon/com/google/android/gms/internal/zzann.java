// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Looper;

final class zzann implements Runnable
{
    private /* synthetic */ zzanm zzaha;
    
    zzann(final zzanm zzaha) {
        this.zzaha = zzaha;
    }
    
    @Override
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzaha.zzafJ.zzkt().zzf(this);
        }
        else {
            final boolean zzbo = this.zzaha.zzbo();
            zzanm.zza(this.zzaha, 0L);
            if (zzbo) {
                this.zzaha.run();
            }
        }
    }
}
