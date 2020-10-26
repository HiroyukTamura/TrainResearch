// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.MainThread;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;

public final class zzcgc
{
    private final zzcge zzbrL;
    
    public zzcgc(final zzcge zzbrL) {
        zzbo.zzu(zzbrL);
        this.zzbrL = zzbrL;
    }
    
    public static boolean zzj(final Context context, final boolean b) {
        zzbo.zzu(context);
        return zzcjl.zza(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    }
    
    @MainThread
    public final void onReceive(final Context context, Intent setClassName) {
        final zzcgl zzbj = zzcgl.zzbj(context);
        final zzcfl zzwF = zzbj.zzwF();
        if (setClassName == null) {
            zzwF.zzyz().log("Receiver called with null intent");
        }
        else {
            zzcem.zzxE();
            final String action = setClassName.getAction();
            zzwF.zzyD().zzj("Local receiver got", action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzciw.zzk(context, false);
                setClassName = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
                setClassName.setAction("com.google.android.gms.measurement.UPLOAD");
                this.zzbrL.doStartService(context, setClassName);
                return;
            }
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                final String stringExtra = setClassName.getStringExtra("referrer");
                if (stringExtra == null) {
                    zzwF.zzyD().log("Install referrer extras are null");
                    return;
                }
                zzwF.zzyB().zzj("Install referrer extras are", stringExtra);
                String concat = stringExtra;
                if (!stringExtra.contains("?")) {
                    final String value = String.valueOf(stringExtra);
                    if (value.length() != 0) {
                        concat = "?".concat(value);
                    }
                    else {
                        concat = new String("?");
                    }
                }
                final Bundle zzq = zzbj.zzwB().zzq(Uri.parse(concat));
                if (zzq == null) {
                    zzwF.zzyD().log("No campaign defined in install referrer broadcast");
                    return;
                }
                final long n = 1000L * setClassName.getLongExtra("referrer_timestamp_seconds", 0L);
                if (n == 0L) {
                    zzwF.zzyz().log("Install referrer is missing timestamp");
                }
                zzbj.zzwE().zzj(new zzcgd(this, zzbj, n, zzq, context, zzwF));
            }
        }
    }
}
