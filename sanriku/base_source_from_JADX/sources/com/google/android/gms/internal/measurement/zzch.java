package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzch extends ContentObserver {
    zzch(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzcf.zze.set(true);
    }
}
