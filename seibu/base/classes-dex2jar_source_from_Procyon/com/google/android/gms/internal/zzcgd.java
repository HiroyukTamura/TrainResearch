// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;
import android.content.Context;
import android.os.Bundle;

final class zzcgd implements Runnable
{
    private /* synthetic */ zzcgl zzbrM;
    private /* synthetic */ long zzbrN;
    private /* synthetic */ Bundle zzbrO;
    private /* synthetic */ zzcfl zzbrP;
    private /* synthetic */ Context zztF;
    
    zzcgd(final zzcgc zzcgc, final zzcgl zzbrM, final long zzbrN, final Bundle zzbrO, final Context zztF, final zzcfl zzbrP) {
        this.zzbrM = zzbrM;
        this.zzbrN = zzbrN;
        this.zzbrO = zzbrO;
        this.zztF = zztF;
        this.zzbrP = zzbrP;
    }
    
    @Override
    public final void run() {
        final zzcjk zzG = this.zzbrM.zzwz().zzG(this.zzbrM.zzwu().zzhl(), "_fot");
        long longValue;
        if (zzG != null && zzG.mValue instanceof Long) {
            longValue = (long)zzG.mValue;
        }
        else {
            longValue = 0L;
        }
        final long zzbrN = this.zzbrN;
        long n;
        if (longValue > 0L && (zzbrN >= longValue || zzbrN <= 0L)) {
            n = longValue - 1L;
        }
        else {
            n = zzbrN;
        }
        if (n > 0L) {
            this.zzbrO.putLong("click_timestamp", n);
        }
        AppMeasurement.getInstance(this.zztF).logEventInternal("auto", "_cmp", this.zzbrO);
        this.zzbrP.zzyD().log("Install campaign recorded");
    }
}
