package com.google.android.gms.internal.ads;

public final class zzoj {
    private boolean isOpen;

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzit() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }
}
