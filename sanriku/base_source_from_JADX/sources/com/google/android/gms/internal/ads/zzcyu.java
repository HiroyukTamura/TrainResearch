package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Set;

public final class zzcyu implements zzdak<zzcyr> {
    private final zzdrh zzglk;
    private final Set<String> zzgly;
    private final Context zzvf;

    public zzcyu(zzdrh zzdrh, Context context, Set<String> set) {
        this.zzglk = zzdrh;
        this.zzvf = context;
        this.zzgly = set;
    }

    public final zzdri<zzcyr> zzaqa() {
        return this.zzglk.zzd(new zzcyt(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcyr zzaqj() throws Exception {
        return (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqw)).booleanValue() || !zzcyr.zze(this.zzgly)) ? new zzcyr((String) null) : new zzcyr(zzq.zzll().getVersion(this.zzvf));
    }
}
