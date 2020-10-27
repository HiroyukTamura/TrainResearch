package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcya implements zzdah<Bundle> {
    private final String zzdmx;
    private final boolean zzdmz;

    public zzcya(String str, boolean z) {
        this.zzdmx = str;
        this.zzdmz = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zzdmx);
        if (this.zzdmz) {
            bundle.putString("de", "1");
        }
    }
}
