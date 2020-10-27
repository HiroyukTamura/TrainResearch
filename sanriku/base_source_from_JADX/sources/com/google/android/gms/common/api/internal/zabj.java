package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

final class zabj implements Runnable {
    private final /* synthetic */ GoogleApiManager.zaa zaiq;
    private final /* synthetic */ ConnectionResult zajc;

    zabj(GoogleApiManager.zaa zaa, ConnectionResult connectionResult) {
        this.zaiq = zaa;
        this.zajc = connectionResult;
    }

    public final void run() {
        this.zaiq.onConnectionFailed(this.zajc);
    }
}
