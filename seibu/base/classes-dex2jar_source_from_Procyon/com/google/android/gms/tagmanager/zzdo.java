// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class zzdo extends BroadcastReceiver
{
    private static String zzaiq;
    private final zzfn zzbFr;
    
    static {
        zzdo.zzaiq = zzdo.class.getName();
    }
    
    zzdo(final zzfn zzbFr) {
        this.zzbFr = zzbFr;
    }
    
    public static void zzbt(final Context context) {
        final Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzdo.zzaiq, true);
        context.sendBroadcast(intent);
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final Bundle extras = intent.getExtras();
            Boolean b = Boolean.FALSE;
            if (extras != null) {
                b = intent.getExtras().getBoolean("noConnectivity");
            }
            this.zzbFr.zzas(!b);
        }
        else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzdo.zzaiq)) {
            this.zzbFr.zzBU();
        }
    }
}
