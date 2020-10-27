package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

public final class zzcyr implements zzdah<Bundle> {
    private final String zzgnk;

    public zzcyr(String str) {
        this.zzgnk = str;
    }

    /* access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public final /* synthetic */ void zzs(Object obj) {
        zzdhj.zza((Bundle) obj, "omid_v", this.zzgnk);
    }
}
