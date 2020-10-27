package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzdql<V> extends zzdqi<V, List<V>> {
    zzdql(zzdot<? extends zzdri<? extends V>> zzdot, boolean z) {
        super(zzdot, true);
        zzawi();
    }

    public final /* synthetic */ Object zzi(List list) {
        ArrayList zzej = zzdpc.zzej(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdod zzdod = (zzdod) it.next();
            zzej.add(zzdod != null ? zzdod.zzavo() : null);
        }
        return Collections.unmodifiableList(zzej);
    }
}
