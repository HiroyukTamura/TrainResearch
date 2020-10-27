package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzcxu implements zzdah<Bundle> {
    private final String zzdnn;
    private final String zzgnb;
    private final Bundle zzgnc;

    private zzcxu(String str, String str2, Bundle bundle) {
        this.zzdnn = str;
        this.zzgnb = str2;
        this.zzgnc = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zzdnn);
        bundle.putString("fc_consent", this.zzgnb);
        bundle.putBundle("iab_consent_info", this.zzgnc);
    }
}
