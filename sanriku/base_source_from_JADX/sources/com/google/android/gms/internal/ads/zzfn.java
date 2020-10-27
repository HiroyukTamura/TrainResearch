package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfn extends zzfz {
    public zzfn(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcnv)).booleanValue();
        zzdx zzdx = new zzdx((String) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zzaam) {
            this.zzaam.zze(zzdx.zzxs);
            this.zzaam.zzag(zzdx.zzxt);
        }
    }
}
