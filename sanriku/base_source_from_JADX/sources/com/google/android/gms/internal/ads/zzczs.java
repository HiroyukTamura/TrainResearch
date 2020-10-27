package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzczs implements zzdah<Bundle> {
    private final String zzdsr;
    private final String zzgnw;
    private final String zzgnx;
    private final String zzgny;
    private final Long zzgnz;

    public zzczs(String str, String str2, String str3, String str4, Long l) {
        this.zzdsr = str;
        this.zzgnw = str2;
        this.zzgnx = str3;
        this.zzgny = str4;
        this.zzgnz = l;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdhj.zza(bundle, "gmp_app_id", this.zzdsr);
        zzdhj.zza(bundle, "fbs_aiid", this.zzgnw);
        zzdhj.zza(bundle, "fbs_aeid", this.zzgnx);
        zzdhj.zza(bundle, "apm_id_origin", this.zzgny);
        Long l = this.zzgnz;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
