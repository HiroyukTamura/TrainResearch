package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzczw implements zzdah<Bundle> {
    private final String zzbnd;
    private final int zzdmo;
    private final boolean zzdnl;
    private final boolean zzdzq;
    private final boolean zzgob;
    private final int zzgoc;
    private final int zzgod;

    public zzczw(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zzgob = z;
        this.zzdzq = z2;
        this.zzbnd = str;
        this.zzdnl = z3;
        this.zzdmo = i;
        this.zzgoc = i2;
        this.zzgod = i3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzbnd);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzvj.zzpv().zzd(zzzz.zzcoo));
        bundle.putInt("target_api", this.zzdmo);
        bundle.putInt("dv", this.zzgoc);
        bundle.putInt("lv", this.zzgod);
        Bundle zza = zzdhj.zza(bundle, "sdk_env");
        zza.putBoolean("mf", zzabk.zzcwm.get().booleanValue());
        zza.putBoolean("instant_app", this.zzgob);
        zza.putBoolean("lite", this.zzdzq);
        zza.putBoolean("is_privileged_process", this.zzdnl);
        bundle.putBundle("sdk_env", zza);
        Bundle zza2 = zzdhj.zza(zza, "build_meta");
        zza2.putString("cl", "305933803");
        zza2.putString("rapid_rc", "dev");
        zza2.putString("rapid_rollup", "HEAD");
        zza.putBundle("build_meta", zza2);
    }
}
