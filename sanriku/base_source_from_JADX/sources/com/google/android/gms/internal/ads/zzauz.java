package com.google.android.gms.internal.ads;

final /* synthetic */ class zzauz implements zzavh {
    static final zzavh zzdtc = new zzauz();

    private zzauz() {
    }

    public final Object zzb(zzbgr zzbgr) {
        String currentScreenName = zzbgr.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbgr.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
