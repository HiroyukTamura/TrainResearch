package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting
final class zzac extends BroadcastReceiver {
    final /* synthetic */ zzad zza;
    @GuardedBy("this")
    @Nullable
    private zzad zzb;

    public zzac(zzad zzad, zzad zzad2) {
        this.zza = zzad;
        this.zzb = zzad2;
    }

    public final synchronized void onReceive(Context context, Intent intent) {
        if (this.zzb != null) {
            if (this.zzb.zzb()) {
                if (zzad.zzc()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.zzb.zzd.zza(this.zzb, 0);
                context.unregisterReceiver(this);
                this.zzb = null;
            }
        }
    }
}
