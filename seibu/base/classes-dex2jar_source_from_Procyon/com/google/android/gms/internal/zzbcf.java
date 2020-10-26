// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.internal.zzj;

final class zzbcf implements zzj
{
    private final boolean zzaCj;
    private final WeakReference<zzbcd> zzaDq;
    private final Api<?> zzayW;
    
    public zzbcf(final zzbcd referent, final Api<?> zzayW, final boolean zzaCj) {
        this.zzaDq = new WeakReference<zzbcd>(referent);
        this.zzayW = zzayW;
        this.zzaCj = zzaCj;
    }
    
    @Override
    public final void zzf(@NonNull final ConnectionResult connectionResult) {
        boolean b = false;
        final zzbcd zzbcd = this.zzaDq.get();
        if (zzbcd == null) {
            return;
        }
        if (Looper.myLooper() == zzbcd.zzaCZ.zzaCl.getLooper()) {
            b = true;
        }
        zzbo.zza(b, (Object)"onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zzbcd.zzaCv.lock();
        try {
            if (!com.google.android.gms.internal.zzbcd.zza(zzbcd, 0)) {
                return;
            }
            if (!connectionResult.isSuccess()) {
                zzbcd.zzb(connectionResult, this.zzayW, this.zzaCj);
            }
            if (zzbcd.zzpW()) {
                zzbcd.zzpX();
            }
        }
        finally {
            zzbcd.zzaCv.unlock();
        }
    }
}
