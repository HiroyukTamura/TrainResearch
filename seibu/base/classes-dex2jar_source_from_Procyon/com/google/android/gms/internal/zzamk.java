// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzamk implements UncaughtExceptionHandler
{
    private /* synthetic */ zzamj zzaga;
    
    zzamk(final zzamj zzaga) {
        this.zzaga = zzaga;
    }
    
    @Override
    public final void uncaughtException(final Thread thread, final Throwable t) {
        final zzaoc zzkF = this.zzaga.zzkF();
        if (zzkF != null) {
            zzkF.zze("Job execution failed", t);
        }
    }
}
