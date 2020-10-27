package com.google.android.gms.internal.ads;

import java.io.InputStream;

final /* synthetic */ class zzclg implements zzdqj {
    private final zzarj zzfnq;

    zzclg(zzarj zzarj) {
        this.zzfnq = zzarj;
    }

    public final zzdri zzf(Object obj) {
        zzarj zzarj = this.zzfnq;
        zzarj.zzdpi = new String(zzdpr.toByteArray((InputStream) obj), zzdnv.UTF_8);
        return zzdqw.zzag(zzarj);
    }
}
