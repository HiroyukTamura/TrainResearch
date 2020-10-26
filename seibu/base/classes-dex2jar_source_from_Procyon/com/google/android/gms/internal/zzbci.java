// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzj;

final class zzbci extends zzbcy
{
    private /* synthetic */ zzj zzaDu;
    
    zzbci(final zzbcg zzbcg, final zzbcw zzbcw, final zzj zzaDu) {
        this.zzaDu = zzaDu;
        super(zzbcw);
    }
    
    public final void zzpV() {
        this.zzaDu.zzf(new ConnectionResult(16, null));
    }
}
