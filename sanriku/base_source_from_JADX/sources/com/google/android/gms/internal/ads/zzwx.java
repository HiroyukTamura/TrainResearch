package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzwx extends zzwv {
    private final MuteThisAdListener zzcgj;

    public zzwx(MuteThisAdListener muteThisAdListener) {
        this.zzcgj = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.zzcgj.onAdMuted();
    }
}
