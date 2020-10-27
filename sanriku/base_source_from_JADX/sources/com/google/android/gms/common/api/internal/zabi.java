package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

final class zabi implements Runnable {
    private final /* synthetic */ GoogleApiManager.zaa zaiq;

    zabi(GoogleApiManager.zaa zaa) {
        this.zaiq = zaa;
    }

    public final void run() {
        this.zaiq.zabe();
    }
}
