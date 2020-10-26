// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.util.Base64;
import android.os.Build$VERSION;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.WakefulBroadcastReceiver;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver
{
    public final void onReceive(final Context context, final Intent intent) {
        String s = null;
        final int n = -1;
        intent.setComponent((ComponentName)null);
        intent.setPackage(context.getPackageName());
        if (Build$VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        final String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final String stringExtra2 = intent.getStringExtra("from");
        if ("google.com/iid".equals(stringExtra2) || "gcm.googleapis.com/refresh".equals(stringExtra2)) {
            s = "com.google.firebase.INSTANCE_ID_EVENT";
        }
        else if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            s = "com.google.firebase.MESSAGING_EVENT";
        }
        else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
        }
        int zza = n;
        if (s != null) {
            if (FirebaseInstanceIdInternalReceiver.zzbH(context)) {
                if (this.isOrderedBroadcast()) {
                    this.setResultCode(-1);
                }
                FirebaseInstanceIdInternalReceiver.zzH(context, s).zza(intent, this.goAsync());
                zza = n;
            }
            else {
                zza = zzq.zzJX().zza(context, s, intent);
            }
        }
        if (this.isOrderedBroadcast()) {
            this.setResultCode(zza);
        }
    }
}
