package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class zzuq extends zzwg {
    private final AppEventListener zzblk;

    public zzuq(AppEventListener appEventListener) {
        this.zzblk = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzblk;
    }

    public final void onAppEvent(String str, String str2) {
        this.zzblk.onAppEvent(str, str2);
    }
}
