package com.google.android.gms.common.api.internal;

abstract class zabd {
    private final zabb zahq;

    protected zabd(zabb zabb) {
        this.zahq = zabb;
    }

    public final void zaa(zabe zabe) {
        zabe.zaer.lock();
        try {
            if (zabe.zahu == this.zahq) {
                zaal();
            }
        } finally {
            zabe.zaer.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zaal();
}
