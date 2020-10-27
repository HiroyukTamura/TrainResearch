package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzczi implements zzdak<zzdah<Bundle>> {
    private final String zzfmw;
    private final Context zzvf;

    zzczi(Context context, @Nullable String str) {
        this.zzvf = context;
        this.zzfmw = str;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        return zzdqw.zzag(this.zzfmw == null ? null : new zzczh(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzvf.getPackageName());
    }
}
