package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

final /* synthetic */ class zzait implements Runnable {
    private final String zzdcd;

    zzait(String str) {
        this.zzdcd = str;
    }

    public final void run() {
        zzq.zzla().zzvv().zzct(this.zzdcd.substring(1));
    }
}
