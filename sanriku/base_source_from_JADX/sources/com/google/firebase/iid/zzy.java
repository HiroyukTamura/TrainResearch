package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.util.concurrent.Callable;
import p009e.p010a.p011a.p012a.C0681a;

final /* synthetic */ class zzy implements Callable {
    private final Intent zza;

    zzy(Intent intent) {
        this.zza = intent;
    }

    public final Object call() {
        Intent intent = this.zza;
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("FirebaseInstanceId", C0681a.m314a(valueOf.length() + stringExtra.length() + 21, "Received command: ", stringExtra, " - ", valueOf));
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.getInstance().zze();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId.getInstance().zzg();
            }
        }
        return -1;
    }
}
