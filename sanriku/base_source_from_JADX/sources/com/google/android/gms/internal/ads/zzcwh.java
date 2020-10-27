package com.google.android.gms.internal.ads;

import java.util.ArrayList;

final /* synthetic */ class zzcwh implements zzdnx {
    static final zzdnx zzdsc = new zzcwh();

    private zzcwh() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcwk(arrayList);
    }
}
