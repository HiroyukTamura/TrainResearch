package com.google.android.gms.internal.ads;

import p009e.p010a.p011a.p012a.C0681a;

public final class zzin extends Exception {
    private final int errorCode;

    public zzin(int i) {
        super(C0681a.m309a(36, "AudioTrack write failed: ", i));
        this.errorCode = i;
    }
}
