package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzn extends zzl {
    private final Callable<String> zzar;

    private zzn(Callable<String> callable) {
        super(false, (String) null, (Throwable) null);
        this.zzar = callable;
    }

    /* access modifiers changed from: package-private */
    public final String getErrorMessage() {
        try {
            return this.zzar.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
