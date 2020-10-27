package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzaqo implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzaqm zzdlu;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdlv;

    zzaqo(zzaqm zzaqm, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdlu = zzaqm;
        this.zzdlv = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdlu.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdlv;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdlv;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
