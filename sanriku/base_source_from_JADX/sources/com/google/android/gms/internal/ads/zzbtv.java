package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

final /* synthetic */ class zzbtv implements zzbuk {
    private final String zzdbv;
    private final String zzdcd;

    zzbtv(String str, String str2) {
        this.zzdcd = str;
        this.zzdbv = str2;
    }

    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzdcd, this.zzdbv);
    }
}
