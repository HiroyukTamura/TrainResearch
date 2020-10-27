package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

public final class zzayy {
    private Handler handler = null;
    private final Object lock = new Object();
    private HandlerThread zzdyf = null;
    private int zzdyg = 0;

    public final Handler getHandler() {
        return this.handler;
    }

    public final Looper zzxx() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzdyg != 0) {
                Preconditions.checkNotNull(this.zzdyf, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzdyf == null) {
                zzawr.zzeg("Starting the looper thread.");
                HandlerThread handlerThread = new HandlerThread("LooperProvider");
                this.zzdyf = handlerThread;
                handlerThread.start();
                this.handler = new zzdns(this.zzdyf.getLooper());
                zzawr.zzeg("Looper thread started.");
            } else {
                zzawr.zzeg("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzdyg++;
            looper = this.zzdyf.getLooper();
        }
        return looper;
    }
}
