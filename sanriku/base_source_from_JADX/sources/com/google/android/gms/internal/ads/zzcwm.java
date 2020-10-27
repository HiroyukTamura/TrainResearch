package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcwm implements zzdak<Object> {
    private static final Object lock = new Object();
    private final String zzcgc;
    private final String zzdma;
    private final zzdhe zzfll;
    private final zzbpc zzgmg;
    private final zzdhy zzgmh;

    public zzcwm(String str, String str2, zzbpc zzbpc, zzdhy zzdhy, zzdhe zzdhe) {
        this.zzdma = str;
        this.zzcgc = str2;
        this.zzgmg = zzbpc;
        this.zzgmh = zzdhy;
        this.zzfll = zzdhe;
    }

    public final zzdri<Object> zzaqa() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcru)).booleanValue()) {
            this.zzgmg.zzf(this.zzfll.zzguw);
            bundle.putAll(this.zzgmh.zzash());
        }
        return zzdqw.zzag(new zzcwl(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcru)).booleanValue()) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrt)).booleanValue()) {
                synchronized (lock) {
                    this.zzgmg.zzf(this.zzfll.zzguw);
                    bundle2.putBundle("quality_signals", this.zzgmh.zzash());
                }
                bundle2.putString("seq_num", this.zzdma);
                bundle2.putString("session_id", this.zzcgc);
            }
            this.zzgmg.zzf(this.zzfll.zzguw);
            bundle = this.zzgmh.zzash();
        }
        bundle2.putBundle("quality_signals", bundle);
        bundle2.putString("seq_num", this.zzdma);
        bundle2.putString("session_id", this.zzcgc);
    }
}
