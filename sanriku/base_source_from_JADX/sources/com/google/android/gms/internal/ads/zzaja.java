package com.google.android.gms.internal.ads;

final class zzaja implements Runnable {
    private final /* synthetic */ zzaiu zzdci;
    private final /* synthetic */ String zzdck;

    zzaja(zzaiu zzaiu, String str) {
        this.zzdci = zzaiu;
        this.zzdck = str;
    }

    public final void run() {
        this.zzdci.zzdce.loadUrl(this.zzdck);
    }
}
