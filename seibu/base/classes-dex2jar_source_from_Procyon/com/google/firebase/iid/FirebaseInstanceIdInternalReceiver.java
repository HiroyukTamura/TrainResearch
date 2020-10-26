// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.os.Parcelable;
import android.util.Log;
import android.content.Intent;
import com.google.android.gms.common.util.zzq;
import android.content.Context;
import android.support.v4.content.WakefulBroadcastReceiver;

public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver
{
    private static boolean zzbfB;
    private static zzh zzckA;
    private static zzh zzckz;
    
    static {
        FirebaseInstanceIdInternalReceiver.zzbfB = false;
    }
    
    static zzh zzH(final Context context, final String anObject) {
        synchronized (FirebaseInstanceIdInternalReceiver.class) {
            zzh zzh;
            if ("com.google.firebase.MESSAGING_EVENT".equals(anObject)) {
                if (FirebaseInstanceIdInternalReceiver.zzckA == null) {
                    FirebaseInstanceIdInternalReceiver.zzckA = new zzh(context, anObject);
                }
                zzh = FirebaseInstanceIdInternalReceiver.zzckA;
            }
            else {
                if (FirebaseInstanceIdInternalReceiver.zzckz == null) {
                    FirebaseInstanceIdInternalReceiver.zzckz = new zzh(context, anObject);
                }
                zzh = FirebaseInstanceIdInternalReceiver.zzckz;
            }
            return zzh;
        }
    }
    
    static boolean zzbH(final Context context) {
        return zzq.isAtLeastO() && context.getApplicationInfo().targetSdkVersion > 25;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (!(parcelableExtra instanceof Intent)) {
            Log.e("FirebaseInstanceId", "Missing or invalid wrapped intent");
            return;
        }
        final Intent intent2 = (Intent)parcelableExtra;
        if (zzbH(context)) {
            zzH(context, intent.getAction()).zza(intent2, this.goAsync());
            return;
        }
        com.google.firebase.iid.zzq.zzJX().zza(context, intent.getAction(), intent2);
    }
}
