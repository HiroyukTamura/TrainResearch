package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

public class zzdns extends Handler {
    private static zzdnr zzhdp;

    public zzdns() {
    }

    public zzdns(Looper looper) {
        super(looper);
    }

    public zzdns(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }
}
