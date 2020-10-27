package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfv extends zzfz {
    public zzfv(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        zzbv.zza.C2654zza zza;
        zzcd zzcd;
        this.zzaam.zza(zzcd.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()})).booleanValue();
        synchronized (this.zzaam) {
            if (booleanValue) {
                zza = this.zzaam;
                zzcd = zzcd.ENUM_TRUE;
            } else {
                zza = this.zzaam;
                zzcd = zzcd.ENUM_FALSE;
            }
            zza.zza(zzcd);
        }
    }
}
