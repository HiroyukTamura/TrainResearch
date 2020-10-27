package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzcec<T> implements zzaga<Object> {
    private final WeakReference<T> zzfwp;
    private final String zzfwq;
    private final zzaga<T> zzfwr;
    private final /* synthetic */ zzcdt zzfws;

    private zzcec(zzcdt zzcdt, WeakReference<T> weakReference, String str, zzaga<T> zzaga) {
        this.zzfws = zzcdt;
        this.zzfwp = weakReference;
        this.zzfwq = str;
        this.zzfwr = zzaga;
    }

    /* synthetic */ zzcec(zzcdt zzcdt, WeakReference weakReference, String str, zzaga zzaga, zzcdu zzcdu) {
        this(zzcdt, weakReference, str, zzaga);
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzfwp.get();
        if (obj2 == null) {
            this.zzfws.zzb(this.zzfwq, this);
        } else {
            this.zzfwr.zza(obj2, map);
        }
    }
}
