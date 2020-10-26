// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.content.BroadcastReceiver$PendingResult;
import android.os.IBinder;
import android.content.ComponentName;
import com.google.android.gms.common.stats.zza;
import android.util.Log;
import android.support.annotation.VisibleForTesting;
import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import android.content.Context;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import android.content.Intent;
import android.content.ServiceConnection;

public final class zzh implements ServiceConnection
{
    private final Intent zzckp;
    private final ScheduledExecutorService zzckq;
    private final Queue<zzd> zzckr;
    private zzf zzcks;
    private boolean zzckt;
    private final Context zzqD;
    
    public zzh(final Context context, final String s) {
        this(context, s, new ScheduledThreadPoolExecutor(0));
    }
    
    @VisibleForTesting
    private zzh(final Context context, final String s, final ScheduledExecutorService zzckq) {
        this.zzckr = new LinkedList<zzd>();
        this.zzckt = false;
        this.zzqD = context.getApplicationContext();
        this.zzckp = new Intent(s).setPackage(this.zzqD.getPackageName());
        this.zzckq = zzckq;
    }
    
    private final void zzJO() {
    Label_0206:
        while (true) {
            Label_0190: {
                Label_0111: {
                    synchronized (this) {
                        if (Log.isLoggable("EnhancedIntentService", 3)) {
                            Log.d("EnhancedIntentService", "flush queue called");
                        }
                        while (!this.zzckr.isEmpty()) {
                            if (Log.isLoggable("EnhancedIntentService", 3)) {
                                Log.d("EnhancedIntentService", "found intent to be delivered");
                            }
                            if (this.zzcks == null || !this.zzcks.isBinderAlive()) {
                                break Label_0111;
                            }
                            if (Log.isLoggable("EnhancedIntentService", 3)) {
                                Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                            }
                            this.zzcks.zza(this.zzckr.poll());
                        }
                        break Label_0190;
                    }
                }
                Label_0193: {
                    while (true) {
                        Label_0156: {
                            if (!Log.isLoggable("EnhancedIntentService", 3)) {
                                break Label_0156;
                            }
                            if (this.zzckt) {
                                break Label_0193;
                            }
                            final boolean b = true;
                            Log.d("EnhancedIntentService", new StringBuilder(39).append("binder is dead. start connection? ").append(b).toString());
                        }
                        if (this.zzckt) {
                            break Label_0190;
                        }
                        this.zzckt = true;
                        try {
                            if (!zza.zzrU().zza(this.zzqD, this.zzckp, (ServiceConnection)this, 65)) {
                                Log.e("EnhancedIntentService", "binding to the service failed");
                                while (!this.zzckr.isEmpty()) {
                                    this.zzckr.poll().finish();
                                }
                            }
                            // monitorexit(this)
                            return;
                            final boolean b = false;
                            continue;
                        }
                        catch (SecurityException ex) {
                            Log.e("EnhancedIntentService", "Exception while binding the service", (Throwable)ex);
                            continue Label_0206;
                        }
                        break;
                    }
                }
            }
            continue Label_0206;
        }
    }
    
    public final void onServiceConnected(final ComponentName obj, final IBinder binder) {
        synchronized (this) {
            this.zzckt = false;
            this.zzcks = (zzf)binder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                final String value = String.valueOf(obj);
                Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(value).length() + 20).append("onServiceConnected: ").append(value).toString());
            }
            this.zzJO();
        }
    }
    
    public final void onServiceDisconnected(final ComponentName obj) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            final String value = String.valueOf(obj);
            Log.d("EnhancedIntentService", new StringBuilder(String.valueOf(value).length() + 23).append("onServiceDisconnected: ").append(value).toString());
        }
        this.zzJO();
    }
    
    public final void zza(final Intent intent, final BroadcastReceiver$PendingResult broadcastReceiver$PendingResult) {
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
            }
            this.zzckr.add(new zzd(intent, broadcastReceiver$PendingResult, this.zzckq));
            this.zzJO();
        }
    }
}
