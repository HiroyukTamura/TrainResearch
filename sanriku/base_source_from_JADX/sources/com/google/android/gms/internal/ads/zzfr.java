package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfr extends zzfz {
    private final StackTraceElement[] zzaar;

    public zzfr(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzeo, str, str2, zza, i, 45);
        this.zzaar = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzaar;
        if (obj != null) {
            zzek zzek = new zzek((String) this.zzaaw.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zzaam) {
                this.zzaam.zzab(zzek.zzyb.longValue());
                if (zzek.zzyc.booleanValue()) {
                    this.zzaam.zzc(zzek.zzyd.booleanValue() ? zzcd.ENUM_FALSE : zzcd.ENUM_TRUE);
                } else {
                    this.zzaam.zzc(zzcd.ENUM_FAILURE);
                }
            }
        }
    }
}
