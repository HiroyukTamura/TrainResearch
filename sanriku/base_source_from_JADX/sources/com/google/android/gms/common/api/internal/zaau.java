package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;

abstract class zaau implements Runnable {
    private final /* synthetic */ zaak zafz;

    private zaau(zaak zaak) {
        this.zafz = zaak;
    }

    /* synthetic */ zaau(zaak zaak, zaaj zaaj) {
        this(zaak);
    }

    @WorkerThread
    public void run() {
        this.zafz.zaer.lock();
        try {
            if (!Thread.interrupted()) {
                zaal();
            }
        } catch (RuntimeException e) {
            this.zafz.zafv.zab(e);
        } catch (Throwable th) {
            this.zafz.zaer.unlock();
            throw th;
        }
        this.zafz.zaer.unlock();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract void zaal();
}
