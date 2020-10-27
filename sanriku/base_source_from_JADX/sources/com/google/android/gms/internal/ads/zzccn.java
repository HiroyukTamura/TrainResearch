package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class zzccn implements zzdnx {
    static final zzdnx zzdsc = new zzccn();

    private zzccn() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzccp zzccp : (List) obj) {
            if (zzccp != null) {
                arrayList.add(zzccp);
            }
        }
        return arrayList;
    }
}
