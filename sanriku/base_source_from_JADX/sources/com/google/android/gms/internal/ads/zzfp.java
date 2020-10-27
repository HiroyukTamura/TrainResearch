package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzfp extends zzfz {
    private List<Long> zzaaq = null;

    public zzfp(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzq(-1);
        this.zzaam.zzr(-1);
        if (this.zzaaq == null) {
            this.zzaaq = (List) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()});
        }
        List<Long> list = this.zzaaq;
        if (list != null && list.size() == 2) {
            synchronized (this.zzaam) {
                this.zzaam.zzq(this.zzaaq.get(0).longValue());
                this.zzaam.zzr(this.zzaaq.get(1).longValue());
            }
        }
    }
}
