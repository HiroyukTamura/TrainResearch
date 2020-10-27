package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzcxa implements zzdak<zzcwx> {
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzcxa(zzdrh zzdrh, Context context) {
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzcwx> zzaqa() {
        return this.zzfur.zzd(new zzcwz(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcwx zzaqf() throws Exception {
        double d;
        Intent registerReceiver = this.zzvf.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            double intExtra2 = (double) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcwx(d, z);
    }
}
