// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import java.util.concurrent.TimeoutException;
import com.google.android.gms.common.internal.zzbo;
import java.util.concurrent.TimeUnit;
import android.content.ComponentName;
import java.util.concurrent.LinkedBlockingQueue;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import android.content.ServiceConnection;

public final class zza implements ServiceConnection
{
    private boolean zzazV;
    private final BlockingQueue<IBinder> zzazW;
    
    public zza() {
        this.zzazV = false;
        this.zzazW = new LinkedBlockingQueue<IBinder>();
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.zzazW.add(binder);
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
    }
    
    public final IBinder zza(final long n, final TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        zzbo.zzcG("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zzazV) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zzazV = true;
        final IBinder binder = this.zzazW.poll(10000L, timeUnit);
        if (binder == null) {
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        return binder;
    }
    
    public final IBinder zzoV() throws InterruptedException {
        zzbo.zzcG("BlockingServiceConnection.getService() called on main thread");
        if (this.zzazV) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zzazV = true;
        return this.zzazW.take();
    }
}
