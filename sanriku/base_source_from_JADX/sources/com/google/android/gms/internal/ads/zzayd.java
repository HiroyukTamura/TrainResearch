package com.google.android.gms.internal.ads;

public final class zzayd extends Exception {
    private final int errorCode;

    public zzayd(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
