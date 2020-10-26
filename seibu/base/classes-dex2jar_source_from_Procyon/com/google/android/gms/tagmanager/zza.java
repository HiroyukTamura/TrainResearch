// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Process;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import android.content.Context;

public final class zza
{
    private static Object zzbDk;
    private static zza zzbDl;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzYV;
    private volatile AdvertisingIdClient.Info zzafw;
    private volatile long zzbDe;
    private volatile long zzbDf;
    private volatile long zzbDg;
    private volatile long zzbDh;
    private final Object zzbDi;
    private zzd zzbDj;
    private final zze zzvw;
    
    static {
        zza.zzbDk = new Object();
    }
    
    private zza(final Context context) {
        this(context, null, zzi.zzrY());
    }
    
    private zza(final Context mContext, final zzd zzd, final zze zzvw) {
        this.zzbDe = 900000L;
        this.zzbDf = 30000L;
        this.mClosed = false;
        this.zzbDi = new Object();
        this.zzbDj = new zzb(this);
        this.zzvw = zzvw;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.zzbDg = this.zzvw.currentTimeMillis();
        this.zzYV = new Thread(new zzc(this));
    }
    
    private final void zzAA() {
        if (this.zzvw.currentTimeMillis() - this.zzbDg <= this.zzbDf) {
            return;
        }
        synchronized (this.zzbDi) {
            this.zzbDi.notify();
            // monitorexit(this.zzbDi)
            this.zzbDg = this.zzvw.currentTimeMillis();
        }
    }
    
    private final void zzAB() {
        if (this.zzvw.currentTimeMillis() - this.zzbDh > 3600000L) {
            this.zzafw = null;
        }
    }
    
    private final void zzAC() {
        Process.setThreadPriority(10);
        while (true) {
            final boolean mClosed = this.mClosed;
            final AdvertisingIdClient.Info zzAD = this.zzbDj.zzAD();
            if (zzAD != null) {
                this.zzafw = zzAD;
                this.zzbDh = this.zzvw.currentTimeMillis();
                zzdj.zzaS("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                this.notifyAll();
                // monitorexit(this)
                try {
                    synchronized (this.zzbDi) {
                        this.zzbDi.wait(this.zzbDe);
                    }
                }
                catch (InterruptedException ex) {
                    zzdj.zzaS("sleep interrupted in AdvertiserDataPoller thread; continuing");
                }
            }
        }
    }
    
    private final void zzAz() {
        // monitorenter(this)
        try {
            try {
                this.zzAA();
                this.wait(500L);
            }
            finally {
            }
            // monitorexit(this)
        }
        catch (InterruptedException ex) {}
    }
    
    public static zza zzbl(final Context context) {
        Label_0040: {
            if (zza.zzbDl != null) {
                break Label_0040;
            }
            synchronized (zza.zzbDk) {
                if (zza.zzbDl == null) {
                    (zza.zzbDl = new zza(context)).zzYV.start();
                }
                return zza.zzbDl;
            }
        }
    }
    
    public final boolean isLimitAdTrackingEnabled() {
        if (this.zzafw == null) {
            this.zzAz();
        }
        else {
            this.zzAA();
        }
        this.zzAB();
        return this.zzafw == null || this.zzafw.isLimitAdTrackingEnabled();
    }
    
    public final String zzAy() {
        if (this.zzafw == null) {
            this.zzAz();
        }
        else {
            this.zzAA();
        }
        this.zzAB();
        if (this.zzafw == null) {
            return null;
        }
        return this.zzafw.getId();
    }
}
