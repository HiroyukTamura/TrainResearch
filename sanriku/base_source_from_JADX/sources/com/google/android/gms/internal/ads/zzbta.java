package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbta extends zzbui<zzbtb> implements zzbrp, zzbsr {
    private final zzdgo zzfgk;
    private AtomicBoolean zzfnm = new AtomicBoolean();

    public zzbta(Set<zzbvt<zzbtb>> set, zzdgo zzdgo) {
        super(set);
        this.zzfgk = zzdgo;
    }

    private final void zzaiu() {
        zzuo zzuo;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcuh)).booleanValue() && this.zzfnm.compareAndSet(false, true) && (zzuo = this.zzfgk.zzgue) != null && zzuo.type == 3) {
            zza(new zzbsz(this));
        }
    }

    public final void onAdImpression() {
        int i = this.zzfgk.zzgtl;
        if (i == 2 || i == 5 || i == 4) {
            zzaiu();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbtb zzbtb) throws Exception {
        zzbtb.zzb(this.zzfgk.zzgue);
    }

    public final void zzait() {
        if (this.zzfgk.zzgtl == 1) {
            zzaiu();
        }
    }
}
