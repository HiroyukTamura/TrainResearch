// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;
import android.os.IBinder;
import java.util.Set;
import android.content.ComponentName;
import android.content.ServiceConnection;

final class zzah implements ServiceConnection
{
    private int mState;
    private ComponentName zzaHO;
    private final Set<ServiceConnection> zzaHT;
    private boolean zzaHU;
    private final zzaf zzaHV;
    private /* synthetic */ zzag zzaHW;
    private IBinder zzaHj;
    
    public zzah(final zzag zzaHW, final zzaf zzaHV) {
        this.zzaHW = zzaHW;
        this.zzaHV = zzaHV;
        this.zzaHT = new HashSet<ServiceConnection>();
        this.mState = 2;
    }
    
    public final IBinder getBinder() {
        return this.zzaHj;
    }
    
    public final ComponentName getComponentName() {
        return this.zzaHO;
    }
    
    public final int getState() {
        return this.mState;
    }
    
    public final boolean isBound() {
        return this.zzaHU;
    }
    
    public final void onServiceConnected(final ComponentName zzaHO, final IBinder zzaHj) {
        synchronized (this.zzaHW.zzaHP) {
            this.zzaHW.mHandler.removeMessages(1, (Object)this.zzaHV);
            this.zzaHj = zzaHj;
            this.zzaHO = zzaHO;
            final Iterator<ServiceConnection> iterator = this.zzaHT.iterator();
            while (iterator.hasNext()) {
                iterator.next().onServiceConnected(zzaHO, zzaHj);
            }
        }
        this.mState = 1;
    }
    // monitorexit(hashMap)
    
    public final void onServiceDisconnected(final ComponentName zzaHO) {
        synchronized (this.zzaHW.zzaHP) {
            this.zzaHW.mHandler.removeMessages(1, (Object)this.zzaHV);
            this.zzaHj = null;
            this.zzaHO = zzaHO;
            final Iterator<ServiceConnection> iterator = this.zzaHT.iterator();
            while (iterator.hasNext()) {
                iterator.next().onServiceDisconnected(zzaHO);
            }
        }
        this.mState = 2;
    }
    // monitorexit(hashMap)
    
    public final void zza(final ServiceConnection serviceConnection, final String s) {
        this.zzaHW.zzaHQ;
        this.zzaHW.mApplicationContext;
        this.zzaHV.zzrB();
        this.zzaHT.add(serviceConnection);
    }
    
    public final boolean zza(final ServiceConnection serviceConnection) {
        return this.zzaHT.contains(serviceConnection);
    }
    
    public final void zzb(final ServiceConnection serviceConnection, final String s) {
        this.zzaHW.zzaHQ;
        this.zzaHW.mApplicationContext;
        this.zzaHT.remove(serviceConnection);
    }
    
    public final void zzcB(final String s) {
        this.mState = 3;
        this.zzaHW.zzaHQ;
        this.zzaHU = zza.zza(this.zzaHW.mApplicationContext, s, this.zzaHV.zzrB(), (ServiceConnection)this, 129);
        if (this.zzaHU) {
            this.zzaHW.mHandler.sendMessageDelayed(this.zzaHW.mHandler.obtainMessage(1, (Object)this.zzaHV), this.zzaHW.zzaHS);
            return;
        }
        this.mState = 2;
        try {
            this.zzaHW.zzaHQ;
            this.zzaHW.mApplicationContext.unbindService((ServiceConnection)this);
        }
        catch (IllegalArgumentException ex) {}
    }
    
    public final void zzcC(final String s) {
        this.zzaHW.mHandler.removeMessages(1, (Object)this.zzaHV);
        this.zzaHW.zzaHQ;
        this.zzaHW.mApplicationContext.unbindService((ServiceConnection)this);
        this.zzaHU = false;
        this.mState = 2;
    }
    
    public final boolean zzrC() {
        return this.zzaHT.isEmpty();
    }
}
