package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcwx implements zzdah<Bundle> {
    private final double zzdqd;
    private final boolean zzdqe;

    public zzcwx(double d, boolean z) {
        this.zzdqd = d;
        this.zzdqe = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdhj.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdhj.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdqe);
        zza2.putDouble("battery_level", this.zzdqd);
    }
}
