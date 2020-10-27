package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class zzgv implements Comparator<zzgt> {
    zzgv() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgt zzgt = (zzgt) obj;
        zzgt zzgt2 = (zzgt) obj2;
        zzgy zzgy = (zzgy) zzgt.iterator();
        zzgy zzgy2 = (zzgy) zzgt2.iterator();
        while (zzgy.hasNext() && zzgy2.hasNext()) {
            int compare = Integer.compare(zzgt.zzb(zzgy.zza()), zzgt.zzb(zzgy2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgt.zza(), zzgt2.zza());
    }
}
