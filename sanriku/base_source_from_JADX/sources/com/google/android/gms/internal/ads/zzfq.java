package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfq extends zzfz {
    public zzfq(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zzaam.zzd(((Boolean) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()})).booleanValue() ? zzcd.ENUM_TRUE : zzcd.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzaam.zzd(zzcd.ENUM_FAILURE);
        }
    }
}
