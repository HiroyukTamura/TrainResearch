package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbom implements zzo {
    private final zzbrx zzflh;
    private AtomicBoolean zzfli = new AtomicBoolean(false);

    public zzbom(zzbrx zzbrx) {
        this.zzflh = zzbrx;
    }

    public final boolean isClosed() {
        return this.zzfli.get();
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zztz() {
        this.zzfli.set(true);
        this.zzflh.onAdClosed();
    }

    public final void zzua() {
        this.zzflh.onAdOpened();
    }
}
