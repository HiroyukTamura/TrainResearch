package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

public final class zzayz extends zzawn {
    private final String url;
    private final zzbaa zzdyh;

    public zzayz(Context context, String str, String str2) {
        this(str2, zzq.zzkw().zzr(context, str));
    }

    private zzayz(String str, String str2) {
        this.zzdyh = new zzbaa(str2);
        this.url = str;
    }

    public final void zzup() {
        this.zzdyh.zzeq(this.url);
    }
}
