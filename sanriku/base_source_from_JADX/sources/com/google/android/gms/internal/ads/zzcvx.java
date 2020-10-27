package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcvx implements zzdah<Bundle> {
    private final Bundle zzglz;

    private zzcvx(Bundle bundle) {
        this.zzglz = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zzglz.isEmpty()) {
            bundle.putBundle("installed_adapter_data", this.zzglz);
        }
    }
}
