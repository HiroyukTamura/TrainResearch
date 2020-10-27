package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzedk implements zzedh {
    zzedk() {
    }

    public final Map<?, ?> zzan(Object obj) {
        return (zzedi) obj;
    }

    public final Map<?, ?> zzao(Object obj) {
        return (zzedi) obj;
    }

    public final boolean zzap(Object obj) {
        return !((zzedi) obj).isMutable();
    }

    public final Object zzaq(Object obj) {
        ((zzedi) obj).zzbcj();
        return obj;
    }

    public final Object zzar(Object obj) {
        return zzedi.zzbfy().zzbfz();
    }

    public final zzedf<?, ?> zzas(Object obj) {
        zzedg zzedg = (zzedg) obj;
        throw new NoSuchMethodError();
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzedi zzedi = (zzedi) obj;
        zzedg zzedg = (zzedg) obj2;
        if (zzedi.isEmpty()) {
            return 0;
        }
        Iterator it = zzedi.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final Object zze(Object obj, Object obj2) {
        zzedi zzedi = (zzedi) obj;
        zzedi zzedi2 = (zzedi) obj2;
        if (!zzedi2.isEmpty()) {
            if (!zzedi.isMutable()) {
                zzedi = zzedi.zzbfz();
            }
            zzedi.zza(zzedi2);
        }
        return zzedi;
    }
}
