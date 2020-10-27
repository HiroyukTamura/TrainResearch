package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdlg implements Runnable {
    private final String zzdbv;
    private final zzdld zzhar;

    zzdlg(zzdld zzdld, String str) {
        this.zzhar = zzdld;
        this.zzdbv = str;
    }

    public final void run() {
        this.zzhar.zzgx(this.zzdbv);
    }
}
