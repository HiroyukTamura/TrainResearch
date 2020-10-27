package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzff extends zzfz {
    private long startTime;

    public zzff(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, long j, int i, int i2) {
        super(zzeo, str, str2, zza, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzaaw.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzaam) {
            this.zzaam.zzak(longValue);
            if (this.startTime != 0) {
                this.zzaam.zzm(longValue - this.startTime);
                this.zzaam.zzp(this.startTime);
            }
        }
    }
}
