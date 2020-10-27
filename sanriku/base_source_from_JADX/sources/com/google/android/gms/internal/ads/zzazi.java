package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzazi {
    private final BroadcastReceiver zzdyp = new zzazh(this);
    private final Map<BroadcastReceiver, IntentFilter> zzdyq = new WeakHashMap();
    private boolean zzdyr;
    private boolean zzyw = false;
    private Context zzzo;

    /* access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzdyq.entrySet()) {
            if (((IntentFilter) next.getValue()).hasAction(intent.getAction())) {
                arrayList.add((BroadcastReceiver) next.getKey());
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }

    public final synchronized void initialize(Context context) {
        if (!this.zzyw) {
            Context applicationContext = context.getApplicationContext();
            this.zzzo = applicationContext;
            if (applicationContext == null) {
                this.zzzo = context;
            }
            zzzz.initialize(this.zzzo);
            this.zzdyr = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcoz)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzzo.registerReceiver(this.zzdyp, intentFilter);
            this.zzyw = true;
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzdyr) {
            this.zzdyq.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzdyr) {
            this.zzdyq.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
