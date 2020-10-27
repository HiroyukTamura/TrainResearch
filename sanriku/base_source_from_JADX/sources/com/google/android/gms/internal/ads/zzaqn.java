package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzaqn implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdlt;
    private final /* synthetic */ zzaqm zzdlu;

    zzaqn(zzaqm zzaqm, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdlu = zzaqm;
        this.zzdlt = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdlu.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdlt;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdlt;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
