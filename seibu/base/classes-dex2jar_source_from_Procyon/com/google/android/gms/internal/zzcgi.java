// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

final class zzcgi implements UncaughtExceptionHandler
{
    private final String zzbsg;
    private /* synthetic */ zzcgg zzbsh;
    
    public zzcgi(final zzcgg zzbsh, final String zzbsg) {
        this.zzbsh = zzbsh;
        zzbo.zzu(zzbsg);
        this.zzbsg = zzbsg;
    }
    
    @Override
    public final void uncaughtException(final Thread thread, final Throwable t) {
        synchronized (this) {
            this.zzbsh.zzwF().zzyx().zzj(this.zzbsg, t);
        }
    }
}
