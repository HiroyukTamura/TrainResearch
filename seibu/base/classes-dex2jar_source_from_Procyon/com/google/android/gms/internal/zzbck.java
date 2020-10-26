// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.BinderThread;
import java.lang.ref.WeakReference;

final class zzbck extends zzctp
{
    private final WeakReference<zzbcd> zzaDq;
    
    zzbck(final zzbcd referent) {
        this.zzaDq = new WeakReference<zzbcd>(referent);
    }
    
    @BinderThread
    @Override
    public final void zzb(final zzctx zzctx) {
        final zzbcd zzbcd = this.zzaDq.get();
        if (zzbcd == null) {
            return;
        }
        zzbcd.zzaCZ.zza(new zzbcl(this, zzbcd, zzbcd, zzctx));
    }
}
