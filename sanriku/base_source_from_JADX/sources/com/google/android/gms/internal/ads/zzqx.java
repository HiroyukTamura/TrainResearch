package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzqx implements Comparator<zzrd> {
    zzqx(zzqy zzqy) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrd zzrd = (zzrd) obj;
        zzrd zzrd2 = (zzrd) obj2;
        int i = zzrd.zzbrj - zzrd2.zzbrj;
        return i != 0 ? i : (int) (zzrd.value - zzrd2.value);
    }
}
