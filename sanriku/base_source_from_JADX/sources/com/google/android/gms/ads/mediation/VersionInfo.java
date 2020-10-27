package com.google.android.gms.ads.mediation;

public final class VersionInfo {
    private final int zzemt;
    private final int zzemu;
    private final int zzemv;

    public VersionInfo(int i, int i2, int i3) {
        this.zzemt = i;
        this.zzemu = i2;
        this.zzemv = i3;
    }

    public final int getMajorVersion() {
        return this.zzemt;
    }

    public final int getMicroVersion() {
        return this.zzemv;
    }

    public final int getMinorVersion() {
        return this.zzemu;
    }
}
