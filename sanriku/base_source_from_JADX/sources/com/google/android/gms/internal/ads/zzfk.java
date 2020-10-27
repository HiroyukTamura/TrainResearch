package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfk extends zzfz {
    private static final Object zzaal = new Object();
    private static volatile Long zzaan;

    public zzfk(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzaan == null) {
            synchronized (zzaal) {
                if (zzaan == null) {
                    zzaan = (Long) this.zzaaw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaam) {
            this.zzaam.zzo(zzaan.longValue());
        }
    }
}
