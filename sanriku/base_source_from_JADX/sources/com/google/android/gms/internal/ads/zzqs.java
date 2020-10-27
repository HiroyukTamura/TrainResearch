package com.google.android.gms.internal.ads;

import android.view.View;

final class zzqs implements Runnable {
    private final /* synthetic */ zzqp zzbrc;
    private final /* synthetic */ View zzbrd;

    zzqs(zzqp zzqp, View view) {
        this.zzbrc = zzqp;
        this.zzbrd = view;
    }

    public final void run() {
        this.zzbrc.zzj(this.zzbrd);
    }
}
