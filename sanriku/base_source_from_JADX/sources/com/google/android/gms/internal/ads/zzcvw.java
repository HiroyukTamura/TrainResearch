package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

final class zzcvw implements zzdak<zzdah<Bundle>> {
    private final Set<String> zzgly;

    zzcvw(Set<String> set) {
        this.zzgly = set;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zzgly) {
            arrayList.add(add);
        }
        return zzdqw.zzag(new zzcvv(arrayList));
    }
}
