package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzi implements Executor {
    private final /* synthetic */ Handler val$handler;

    zzi(zzj zzj, Handler handler) {
        this.val$handler = handler;
    }

    public final void execute(Runnable runnable) {
        this.val$handler.post(runnable);
    }
}
