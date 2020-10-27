package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

final class zzpj implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzpj zzbjs = new zzpj();
    private final zzdns zzaes;
    public volatile long zzbjr;
    private final HandlerThread zzbjt;
    private Choreographer zzbju;
    private int zzbjv;

    private zzpj() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzbjt = handlerThread;
        handlerThread.start();
        zzdns zzdns = new zzdns(this.zzbjt.getLooper(), this);
        this.zzaes = zzdns;
        zzdns.sendEmptyMessage(0);
    }

    public static zzpj zzjn() {
        return zzbjs;
    }

    public final void doFrame(long j) {
        this.zzbjr = j;
        this.zzbju.postFrameCallbackDelayed(this, 500);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbju = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzbjv + 1;
            this.zzbjv = i2;
            if (i2 == 1) {
                this.zzbju.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzbjv - 1;
            this.zzbjv = i3;
            if (i3 == 0) {
                this.zzbju.removeFrameCallback(this);
                this.zzbjr = 0;
            }
            return true;
        }
    }

    public final void zzjo() {
        this.zzaes.sendEmptyMessage(1);
    }

    public final void zzjp() {
        this.zzaes.sendEmptyMessage(2);
    }
}
