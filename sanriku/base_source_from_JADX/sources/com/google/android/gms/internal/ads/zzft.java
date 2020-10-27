package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzft extends zzfz {
    private final zzev zzwf;
    private long zzzx;

    public zzft(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2, zzev zzev) {
        super(zzeo, str, str2, zza, i, 53);
        this.zzwf = zzev;
        if (zzev != null) {
            this.zzzx = zzev.zzcv();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwf != null) {
            this.zzaam.zzae(((Long) this.zzaaw.invoke((Object) null, new Object[]{Long.valueOf(this.zzzx)})).longValue());
        }
    }
}
