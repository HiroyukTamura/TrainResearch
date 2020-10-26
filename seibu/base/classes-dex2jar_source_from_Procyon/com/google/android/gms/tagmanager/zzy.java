// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Result;
import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.zzbn;
import com.google.android.gms.internal.ee;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zze;
import android.os.Looper;
import com.google.android.gms.internal.zzbq;
import com.google.android.gms.internal.ef;
import android.content.Context;
import com.google.android.gms.internal.zzbbe;

public final class zzy extends zzbbe<ContainerHolder>
{
    private final Context mContext;
    private long zzbDB;
    private final TagManager zzbDI;
    private final zzaf zzbDL;
    private final zzek zzbDM;
    private final int zzbDN;
    private final zzai zzbDO;
    private zzah zzbDP;
    private ef zzbDQ;
    private volatile zzv zzbDR;
    private volatile boolean zzbDS;
    private zzbq zzbDT;
    private String zzbDU;
    private zzag zzbDV;
    private zzac zzbDW;
    private final String zzbDw;
    private final Looper zzrM;
    private final zze zzvw;
    
    private zzy(final Context mContext, final TagManager zzbDI, final Looper looper, final String zzbDw, final int zzbDN, final zzah zzbDP, final zzag zzbDV, final ef zzbDQ, final zze zzvw, final zzek zzbDM, final zzai zzbDO) {
        Looper mainLooper;
        if (looper == null) {
            mainLooper = Looper.getMainLooper();
        }
        else {
            mainLooper = looper;
        }
        super(mainLooper);
        this.mContext = mContext;
        this.zzbDI = zzbDI;
        Looper mainLooper2 = looper;
        if (looper == null) {
            mainLooper2 = Looper.getMainLooper();
        }
        this.zzrM = mainLooper2;
        this.zzbDw = zzbDw;
        this.zzbDN = zzbDN;
        this.zzbDP = zzbDP;
        this.zzbDV = zzbDV;
        this.zzbDQ = zzbDQ;
        this.zzbDL = new zzaf(this, null);
        this.zzbDT = new zzbq();
        this.zzvw = zzvw;
        this.zzbDM = zzbDM;
        this.zzbDO = zzbDO;
        if (this.zzAQ()) {
            this.zzfa(zzei.zzBD().zzBF());
        }
    }
    
    public zzy(final Context context, final TagManager tagManager, final Looper looper, final String s, final int n, final zzal zzal) {
        this(context, tagManager, looper, s, n, new zzey(context, s), new zzet(context, s, zzal), new ef(context), zzi.zzrY(), new zzdh(1, 5, 900000L, 5000L, "refreshing", zzi.zzrY()), new zzai(context, s));
        this.zzbDQ.zzgc(zzal.zzAX());
    }
    
    private final boolean zzAQ() {
        final zzei zzBD = zzei.zzBD();
        return (zzBD.zzBE() == zzei.zza.zzbFK || zzBD.zzBE() == zzei.zza.zzbFL) && this.zzbDw.equals(zzBD.getContainerId());
    }
    
    private final void zza(final zzbq zzbLH) {
        synchronized (this) {
            if (this.zzbDP != null) {
                final ee ee = new ee();
                ee.zzbLG = this.zzbDB;
                ee.zzlB = new zzbn();
                ee.zzbLH = zzbLH;
                this.zzbDP.zza(ee);
            }
        }
    }
    
    private final void zza(final zzbq zzbDT, final long zzbDB, final boolean b) {
        // monitorenter(this)
        Label_0013: {
            if (!b) {
                break Label_0013;
            }
            while (true) {
                while (true) {
                    Container container = null;
                    Label_0175: {
                        try {
                            final boolean zzbDS = this.zzbDS;
                            if (!this.isReady() || this.zzbDR != null) {
                                this.zzbDT = zzbDT;
                                this.zzbDB = zzbDB;
                                final long zzAS = this.zzbDO.zzAS();
                                this.zzag(Math.max(0L, Math.min(zzAS, this.zzbDB + zzAS - this.zzvw.currentTimeMillis())));
                                container = new Container(this.mContext, this.zzbDI.getDataLayer(), this.zzbDw, zzbDB, zzbDT);
                                if (this.zzbDR != null) {
                                    break Label_0175;
                                }
                                this.zzbDR = new zzv(this.zzbDI, this.zzrM, container, this.zzbDL);
                                if (!this.isReady() && this.zzbDW.zzb(container)) {
                                    ((zzbbe<zzv>)this).setResult(this.zzbDR);
                                }
                            }
                            return;
                        }
                        finally {
                        }
                        // monitorexit(this)
                    }
                    this.zzbDR.zza(container);
                    continue;
                }
            }
        }
    }
    
    private final void zzag(final long n) {
        synchronized (this) {
            if (this.zzbDV == null) {
                zzdj.zzaT("Refresh requested, but no network load scheduler.");
            }
            else {
                this.zzbDV.zza(n, this.zzbDT.zzlC);
            }
        }
    }
    
    private final void zzaq(final boolean b) {
        this.zzbDP.zza(new zzad(this, null));
        this.zzbDV.zza(new zzae(this, null));
        final ek zzbx = this.zzbDP.zzbx(this.zzbDN);
        if (zzbx != null) {
            this.zzbDR = new zzv(this.zzbDI, this.zzrM, new Container(this.mContext, this.zzbDI.getDataLayer(), this.zzbDw, 0L, zzbx), this.zzbDL);
        }
        this.zzbDW = new zzab(this, b);
        if (this.zzAQ()) {
            this.zzbDV.zza(0L, "");
            return;
        }
        this.zzbDP.zzAR();
    }
    
    final String zzAK() {
        synchronized (this) {
            return this.zzbDU;
        }
    }
    
    public final void zzAN() {
        final ek zzbx = this.zzbDP.zzbx(this.zzbDN);
        if (zzbx != null) {
            ((zzbbe<zzv>)this).setResult(new zzv(this.zzbDI, this.zzrM, new Container(this.mContext, this.zzbDI.getDataLayer(), this.zzbDw, 0L, zzbx), new zzaa(this)));
        }
        else {
            zzdj.e("Default was requested, but no default container was found");
            this.setResult(this.zzI(new Status(10, "Default was requested, but no default container was found", null)));
        }
        this.zzbDV = null;
        this.zzbDP = null;
    }
    
    public final void zzAO() {
        this.zzaq(false);
    }
    
    public final void zzAP() {
        this.zzaq(true);
    }
    
    protected final ContainerHolder zzI(final Status status) {
        if (this.zzbDR != null) {
            return this.zzbDR;
        }
        if (status == Status.zzaBp) {
            zzdj.e("timer expired: setting result to failure");
        }
        return new zzv(status);
    }
    
    final void zzfa(final String zzbDU) {
        synchronized (this) {
            this.zzbDU = zzbDU;
            if (this.zzbDV != null) {
                this.zzbDV.zzfb(zzbDU);
            }
        }
    }
}
