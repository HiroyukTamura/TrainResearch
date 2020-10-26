// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.internal.zzbo;
import android.content.ComponentName;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.AlarmManager;

public final class zzanp extends zzamh
{
    private boolean zzahb;
    private boolean zzahc;
    private AlarmManager zzahd;
    
    protected zzanp(final zzamj zzamj) {
        super(zzamj);
        this.zzahd = (AlarmManager)this.getContext().getSystemService("alarm");
    }
    
    private final PendingIntent zzlD() {
        final Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(this.getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(this.getContext(), 0, intent, 0);
    }
    
    public final void cancel() {
        this.zzkD();
        this.zzahc = false;
        this.zzahd.cancel(this.zzlD());
    }
    
    public final void schedule() {
        this.zzkD();
        zzbo.zza(this.zzahb, (Object)"Receiver not registered");
        final long zzlr = zzank.zzlr();
        if (zzlr > 0L) {
            this.cancel();
            final long elapsedRealtime = this.zzkq().elapsedRealtime();
            this.zzahc = true;
            this.zzahd.setInexactRepeating(2, elapsedRealtime + zzlr, 0L, this.zzlD());
        }
    }
    
    public final boolean zzbo() {
        return this.zzahc;
    }
    
    @Override
    protected final void zzjD() {
        try {
            this.zzahd.cancel(this.zzlD());
            if (zzank.zzlr() > 0L) {
                final ActivityInfo receiverInfo = this.getContext().getPackageManager().getReceiverInfo(new ComponentName(this.getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    this.zzbo("Receiver registered. Using alarm for local dispatch.");
                    this.zzahb = true;
                }
            }
        }
        catch (PackageManager$NameNotFoundException ex) {}
    }
    
    public final boolean zzlC() {
        return this.zzahb;
    }
}
