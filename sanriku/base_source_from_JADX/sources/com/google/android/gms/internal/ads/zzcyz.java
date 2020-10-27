package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcyz implements zzdah<Bundle> {
    private final Bundle zzfmv;

    public zzcyz(Bundle bundle) {
        this.zzfmv = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zzfmv;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}
