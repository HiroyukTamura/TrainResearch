package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzbdy {
    private final ArrayList<zznx> zzehi = new ArrayList<>();
    private long zzehj;

    zzbdy() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zznx zznx) {
        this.zzehi.add(zznx);
    }

    /* access modifiers changed from: package-private */
    public final long zzaam() {
        Iterator<zznx> it = this.zzehi.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry next : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzehj = Math.max(this.zzehj, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzehj;
    }
}
