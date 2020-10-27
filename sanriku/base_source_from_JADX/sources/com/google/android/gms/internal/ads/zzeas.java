package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzeas implements Comparator<zzeaq> {
    zzeas() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeaq zzeaq = (zzeaq) obj;
        zzeaq zzeaq2 = (zzeaq) obj2;
        zzeaz zzeaz = (zzeaz) zzeaq.iterator();
        zzeaz zzeaz2 = (zzeaz) zzeaq2.iterator();
        while (zzeaz.hasNext() && zzeaz2.hasNext()) {
            int compare = Integer.compare(zzeaq.zzb(zzeaz.nextByte()), zzeaq.zzb(zzeaz2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeaq.size(), zzeaq2.size());
    }
}
