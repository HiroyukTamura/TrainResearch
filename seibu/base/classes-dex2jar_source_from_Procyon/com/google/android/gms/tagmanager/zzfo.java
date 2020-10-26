// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.Context;

final class zzfo extends zzfn
{
    private static final Object zzbGC;
    private static zzfo zzbGO;
    private boolean connected;
    private Context zzbGD;
    private zzcc zzbGE;
    private volatile zzbz zzbGF;
    private int zzbGG;
    private boolean zzbGH;
    private boolean zzbGI;
    private boolean zzbGJ;
    private zzcd zzbGK;
    private zzfr zzbGL;
    private zzdo zzbGM;
    private boolean zzbGN;
    
    static {
        zzbGC = new Object();
    }
    
    private zzfo() {
        this.zzbGG = 1800000;
        this.zzbGH = true;
        this.zzbGI = false;
        this.connected = true;
        this.zzbGJ = true;
        this.zzbGK = new zzfp(this);
        this.zzbGN = false;
    }
    
    private final boolean isPowerSaveMode() {
        return this.zzbGN || !this.connected || this.zzbGG <= 0;
    }
    
    public static zzfo zzBV() {
        if (zzfo.zzbGO == null) {
            zzfo.zzbGO = new zzfo();
        }
        return zzfo.zzbGO;
    }
    
    @Override
    public final void dispatch() {
        synchronized (this) {
            if (!this.zzbGI) {
                zzdj.v("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.zzbGH = true;
            }
            else {
                this.zzbGF.zzn(new zzfq(this));
            }
        }
    }
    
    @Override
    public final void zzBU() {
        synchronized (this) {
            if (!this.isPowerSaveMode()) {
                this.zzbGL.zzBY();
            }
        }
    }
    
    final zzcc zzBW() {
        Label_0050: {
            synchronized (this) {
                if (this.zzbGE != null) {
                    break Label_0050;
                }
                if (this.zzbGD == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
            }
            this.zzbGE = new zzec(this.zzbGK, this.zzbGD);
        }
        if (this.zzbGL == null) {
            this.zzbGL = new zzfs(this, null);
            if (this.zzbGG > 0) {
                this.zzbGL.zzs(this.zzbGG);
            }
        }
        this.zzbGI = true;
        if (this.zzbGH) {
            this.dispatch();
            this.zzbGH = false;
        }
        if (this.zzbGM == null && this.zzbGJ) {
            this.zzbGM = new zzdo(this);
            final zzdo zzbGM = this.zzbGM;
            final Context zzbGD = this.zzbGD;
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            zzbGD.registerReceiver((BroadcastReceiver)zzbGM, intentFilter);
            final IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(zzbGD.getPackageName());
            zzbGD.registerReceiver((BroadcastReceiver)zzbGM, intentFilter2);
        }
        // monitorexit(this)
        return this.zzbGE;
    }
    
    final void zza(final Context context, final zzbz zzbGF) {
        synchronized (this) {
            if (this.zzbGD == null) {
                this.zzbGD = context.getApplicationContext();
                if (this.zzbGF == null) {
                    this.zzbGF = zzbGF;
                }
            }
        }
    }
    
    @Override
    public final void zzas(final boolean b) {
        synchronized (this) {
            this.zzd(this.zzbGN, b);
        }
    }
    
    final void zzd(final boolean zzbGN, final boolean connected) {
        while (true) {
            Label_0061: {
                synchronized (this) {
                    final boolean powerSaveMode = this.isPowerSaveMode();
                    this.zzbGN = zzbGN;
                    this.connected = connected;
                    if (this.isPowerSaveMode() != powerSaveMode) {
                        if (!this.isPowerSaveMode()) {
                            break Label_0061;
                        }
                        this.zzbGL.cancel();
                        zzdj.v("PowerSaveMode initiated.");
                    }
                    return;
                }
            }
            this.zzbGL.zzs(this.zzbGG);
            zzdj.v("PowerSaveMode terminated.");
        }
    }
}
