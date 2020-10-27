package com.google.android.gms.internal.ads;

import java.util.Iterator;

final /* synthetic */ class zzddw implements zzdqj {
    private final zzddt zzgrh;
    private final zzdiv zzgri;
    private final zzboq zzgrj;

    zzddw(zzddt zzddt, zzdiv zzdiv, zzboq zzboq) {
        this.zzgrh = zzddt;
        this.zzgri = zzdiv;
        this.zzgrj = zzboq;
    }

    public final zzdri zzf(Object obj) {
        zzdiv zzdiv = this.zzgri;
        zzboq zzboq = this.zzgrj;
        zzdha zzdha = (zzdha) obj;
        zzdiv.zzepv = zzdha;
        Iterator<zzdgo> it = zzdha.zzgus.zzguo.iterator();
        boolean z = false;
        boolean z2 = false;
        loop0:
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            Iterator<String> it2 = it.next().zzgtk.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!it2.next().contains("FirstPartyRenderer")) {
                        break loop0;
                    }
                    z2 = true;
                }
            }
        }
        return !z ? zzdqw.zzag(null) : zzboq.zzb((zzdri<zzdha>) zzdqw.zzag(zzdha));
    }
}
