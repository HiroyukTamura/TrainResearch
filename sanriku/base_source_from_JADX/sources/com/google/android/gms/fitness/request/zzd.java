package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;

final class zzd implements ListenerHolder.Notifier<BleScanCallback> {
    zzd(zzb zzb) {
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((BleScanCallback) obj).onScanStopped();
    }

    public final void onNotifyListenerFailed() {
    }
}
