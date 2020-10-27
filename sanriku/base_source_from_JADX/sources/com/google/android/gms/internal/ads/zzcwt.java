package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcwt implements zzdah<Bundle> {
    private final float zzdmn;
    private final int zzdpr;
    private final boolean zzdps;
    private final boolean zzdpt;
    private final int zzdpu;
    private final int zzdpv;
    private final int zzdpw;
    private final boolean zzgmn;

    public zzcwt(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdpr = i;
        this.zzdps = z;
        this.zzdpt = z2;
        this.zzdpu = i2;
        this.zzdpv = i3;
        this.zzdpw = i4;
        this.zzdmn = f;
        this.zzgmn = z3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zzdpr);
        bundle.putBoolean("ma", this.zzdps);
        bundle.putBoolean("sp", this.zzdpt);
        bundle.putInt("muv", this.zzdpu);
        bundle.putInt("rm", this.zzdpv);
        bundle.putInt("riv", this.zzdpw);
        bundle.putFloat("android_app_volume", this.zzdmn);
        bundle.putBoolean("android_app_muted", this.zzgmn);
    }
}
