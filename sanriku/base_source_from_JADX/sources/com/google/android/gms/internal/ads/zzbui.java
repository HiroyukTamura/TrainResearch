package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbui<ListenerT> {
    private final Map<ListenerT, Executor> zzfnt = new HashMap();

    protected zzbui(Set<zzbvt<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzbvt<ListenerT>> set) {
        for (zzbvt<ListenerT> zza : set) {
            zza(zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbuk<ListenerT> zzbuk) {
        for (Map.Entry next : this.zzfnt.entrySet()) {
            ((Executor) next.getValue()).execute(new zzbuh(zzbuk, next.getKey()));
        }
    }

    public final synchronized void zza(zzbvt<ListenerT> zzbvt) {
        zza(zzbvt.zzfom, zzbvt.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfnt.put(listenert, executor);
    }
}
