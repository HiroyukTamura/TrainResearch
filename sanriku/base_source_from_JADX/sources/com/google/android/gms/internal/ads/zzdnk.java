package com.google.android.gms.internal.ads;

public final class zzdnk extends Exception {
    private final int zzhdj;

    public zzdnk(int i, String str) {
        super(str);
        this.zzhdj = i;
    }

    public zzdnk(int i, Throwable th) {
        super(th);
        this.zzhdj = i;
    }

    public final int zzavm() {
        return this.zzhdj;
    }
}
