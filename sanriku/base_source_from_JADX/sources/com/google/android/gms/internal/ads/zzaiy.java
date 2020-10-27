package com.google.android.gms.internal.ads;

final class zzaiy implements Runnable {
    private final /* synthetic */ String zzdch;
    private final /* synthetic */ zzaiu zzdci;

    zzaiy(zzaiu zzaiu, String str) {
        this.zzdci = zzaiu;
        this.zzdch = str;
    }

    public final void run() {
        this.zzdci.zzdce.loadData(this.zzdch, "text/html", "UTF-8");
    }
}
