package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class zzccd implements zzdnx {
    static final zzdnx zzdsc = new zzccd();

    private zzccd() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzace zzace : (List) obj) {
            if (zzace != null) {
                arrayList.add(zzace);
            }
        }
        return arrayList;
    }
}
