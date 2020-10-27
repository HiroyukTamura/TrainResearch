package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final class zzdrt extends TimeoutException {
    private zzdrt(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
