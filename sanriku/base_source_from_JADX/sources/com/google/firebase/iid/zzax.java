package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

final class zzax extends zze {
    private final /* synthetic */ zzau zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzau zzau, Looper looper) {
        super(looper);
        this.zza = zzau;
    }

    public final void handleMessage(Message message) {
        this.zza.zza(message);
    }
}
