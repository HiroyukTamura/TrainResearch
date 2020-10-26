// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import android.os.Looper;

public final class zzbdw<L>
{
    private volatile L mListener;
    private final zzbdx zzaEM;
    private final zzbdy<L> zzaEN;
    
    zzbdw(@NonNull final Looper looper, @NonNull final L l, @NonNull final String s) {
        this.zzaEM = new zzbdx(this, looper);
        this.mListener = zzbo.zzb(l, "Listener must not be null");
        this.zzaEN = new zzbdy<L>(l, zzbo.zzcF(s));
    }
    
    public final void clear() {
        this.mListener = null;
    }
    
    public final void zza(final zzbdz<? super L> zzbdz) {
        zzbo.zzb(zzbdz, "Notifier must not be null");
        this.zzaEM.sendMessage(this.zzaEM.obtainMessage(1, (Object)zzbdz));
    }
    
    final void zzb(final zzbdz<? super L> zzbdz) {
        final L mListener = this.mListener;
        if (mListener == null) {
            zzbdz.zzpT();
            return;
        }
        try {
            zzbdz.zzq(mListener);
        }
        catch (RuntimeException ex) {
            zzbdz.zzpT();
            throw ex;
        }
    }
    
    public final boolean zzoc() {
        return this.mListener != null;
    }
    
    @NonNull
    public final zzbdy<L> zzqG() {
        return this.zzaEN;
    }
}
