package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcye implements zzdah<Bundle> {
    private final Bundle zzdmw;

    public zzcye(Bundle bundle) {
        this.zzdmw = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdhj.zza(bundle, "device");
        zza.putBundle("android_mem_info", this.zzdmw);
        bundle.putBundle("device", zza);
    }
}
