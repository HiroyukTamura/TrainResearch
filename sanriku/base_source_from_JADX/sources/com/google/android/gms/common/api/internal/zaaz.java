package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zar;

final class zaaz extends zar {
    private final /* synthetic */ zaaw zagv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaaz(zaaw zaaw, Looper looper) {
        super(looper);
        this.zagv = zaaw;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zagv.zaat();
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            this.zagv.resume();
        }
    }
}
