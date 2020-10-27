package com.google.android.gms.internal.measurement;

import java.io.Serializable;

final class zzfi extends zzfk<Comparable> implements Serializable {
    static final zzfi zza = new zzfi();

    private zzfi() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        zzdq.zza(comparable);
        zzdq.zza(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
