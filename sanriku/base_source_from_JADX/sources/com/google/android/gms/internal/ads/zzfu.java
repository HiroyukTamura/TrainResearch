package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfu extends zzfz {
    public zzfu(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzaam) {
            zzel zzel = new zzel((String) this.zzaaw.invoke((Object) null, new Object[0]));
            this.zzaam.zzac(zzel.zzye.longValue());
            this.zzaam.zzad(zzel.zzyf.longValue());
        }
    }
}
