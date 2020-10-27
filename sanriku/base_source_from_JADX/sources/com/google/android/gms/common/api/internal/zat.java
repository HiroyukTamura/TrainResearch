package com.google.android.gms.common.api.internal;

final class zat implements Runnable {
    private final /* synthetic */ zaq zaet;

    zat(zaq zaq) {
        this.zaet = zaq;
    }

    public final void run() {
        this.zaet.zaer.lock();
        try {
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }
}
