package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfl extends zzfz {
    private long zzaao = -1;

    public zzfl(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 12);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzi(-1);
        this.zzaam.zzi(((Long) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()})).longValue());
    }
}
