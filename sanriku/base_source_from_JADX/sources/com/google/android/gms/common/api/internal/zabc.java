package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zabc extends zabp {
    private WeakReference<zaaw> zahp;

    zabc(zaaw zaaw) {
        this.zahp = new WeakReference<>(zaaw);
    }

    public final void zas() {
        zaaw zaaw = (zaaw) this.zahp.get();
        if (zaaw != null) {
            zaaw.resume();
        }
    }
}
