package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzri implements Comparator<zzqw> {
    public zzri(zzrf zzrf) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzqw zzqw = (zzqw) obj;
        zzqw zzqw2 = (zzqw) obj2;
        if (zzqw.zzmo() < zzqw2.zzmo()) {
            return -1;
        }
        if (zzqw.zzmo() > zzqw2.zzmo()) {
            return 1;
        }
        if (zzqw.zzmn() < zzqw2.zzmn()) {
            return -1;
        }
        if (zzqw.zzmn() > zzqw2.zzmn()) {
            return 1;
        }
        float zzmp = (zzqw.zzmp() - zzqw.zzmn()) * (zzqw.zzmq() - zzqw.zzmo());
        float zzmp2 = (zzqw2.zzmp() - zzqw2.zzmn()) * (zzqw2.zzmq() - zzqw2.zzmo());
        if (zzmp > zzmp2) {
            return -1;
        }
        return zzmp < zzmp2 ? 1 : 0;
    }
}
