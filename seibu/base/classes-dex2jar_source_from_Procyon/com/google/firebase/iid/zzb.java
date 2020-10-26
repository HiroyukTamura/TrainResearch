// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.util.Log;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.Executors;
import android.os.Binder;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import android.app.Service;

public abstract class zzb extends Service
{
    private final Object mLock;
    @VisibleForTesting
    final ExecutorService zzbrV;
    private Binder zzckd;
    private int zzcke;
    private int zzckf;
    
    public zzb() {
        this.zzbrV = Executors.newSingleThreadExecutor();
        this.mLock = new Object();
        this.zzckf = 0;
    }
    
    private final void zzm(final Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.mLock) {
            --this.zzckf;
            if (this.zzckf == 0) {
                this.stopSelfResult(this.zzcke);
            }
        }
    }
    
    public abstract void handleIntent(final Intent p0);
    
    public final IBinder onBind(final Intent intent) {
        synchronized (this) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.zzckd == null) {
                this.zzckd = new zzf(this);
            }
            return (IBinder)this.zzckd;
        }
    }
    
    public final int onStartCommand(final Intent intent, final int n, final int zzcke) {
        Object o = this.mLock;
        synchronized (o) {
            this.zzcke = zzcke;
            ++this.zzckf;
            // monitorexit(o)
            o = this.zzn(intent);
            if (o == null) {
                this.zzm(intent);
                return 2;
            }
        }
        final Intent intent2;
        if (this.zzo((Intent)o)) {
            this.zzm(intent2);
            return 2;
        }
        this.zzbrV.execute(new zzc(this, (Intent)o, intent2));
        return 3;
    }
    
    protected Intent zzn(final Intent intent) {
        return intent;
    }
    
    public boolean zzo(final Intent intent) {
        return false;
    }
}
