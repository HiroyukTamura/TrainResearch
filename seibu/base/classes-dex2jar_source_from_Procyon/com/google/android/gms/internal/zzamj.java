// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzl;
import android.content.Context;

public class zzamj
{
    private static volatile zzamj zzafM;
    private final Context mContext;
    private final Context zzafN;
    private final zzank zzafO;
    private final zzaoc zzafP;
    private final zzl zzafQ;
    private final zzaly zzafR;
    private final zzanp zzafS;
    private final zzaot zzafT;
    private final zzaog zzafU;
    private final GoogleAnalytics zzafV;
    private final zzanb zzafW;
    private final zzalx zzafX;
    private final zzamu zzafY;
    private final zzano zzafZ;
    private final zze zzvw;
    
    private zzamj(final zzaml zzaml) {
        final Context applicationContext = zzaml.getApplicationContext();
        zzbo.zzb(applicationContext, "Application context can't be null");
        final Context zzkE = zzaml.zzkE();
        zzbo.zzu(zzkE);
        this.mContext = applicationContext;
        this.zzafN = zzkE;
        this.zzvw = zzi.zzrY();
        this.zzafO = new zzank(this);
        final zzaoc zzafP = new zzaoc(this);
        zzafP.initialize();
        this.zzafP = zzafP;
        final zzaoc zzkr = this.zzkr();
        final String version = zzami.VERSION;
        zzkr.zzbq(new StringBuilder(String.valueOf(version).length() + 134).append("Google Analytics ").append(version).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        final zzaog zzafU = new zzaog(this);
        zzafU.initialize();
        this.zzafU = zzafU;
        final zzaot zzafT = new zzaot(this);
        zzafT.initialize();
        this.zzafT = zzafT;
        final zzaly zzafR = new zzaly(this, zzaml);
        final zzanb zzafW = new zzanb(this);
        final zzalx zzafX = new zzalx(this);
        final zzamu zzafY = new zzamu(this);
        final zzano zzafZ = new zzano(this);
        final zzl zzae = zzl.zzae(applicationContext);
        zzae.zza(new zzamk(this));
        this.zzafQ = zzae;
        final GoogleAnalytics zzafV = new GoogleAnalytics(this);
        zzafW.initialize();
        this.zzafW = zzafW;
        zzafX.initialize();
        this.zzafX = zzafX;
        zzafY.initialize();
        this.zzafY = zzafY;
        zzafZ.initialize();
        this.zzafZ = zzafZ;
        final zzanp zzafS = new zzanp(this);
        zzafS.initialize();
        this.zzafS = zzafS;
        zzafR.initialize();
        this.zzafR = zzafR;
        zzafV.initialize();
        this.zzafV = zzafV;
        zzafR.start();
    }
    
    private static void zza(final zzamh zzamh) {
        zzbo.zzb(zzamh, "Analytics service not created/initialized");
        zzbo.zzb(zzamh.isInitialized(), (Object)"Analytics service not initialized");
    }
    
    public static zzamj zzaf(final Context context) {
        zzbo.zzu(context);
        Label_0105: {
            if (zzamj.zzafM != null) {
                break Label_0105;
            }
            synchronized (zzamj.class) {
                if (zzamj.zzafM == null) {
                    final zze zzrY = zzi.zzrY();
                    final long elapsedRealtime = zzrY.elapsedRealtime();
                    final zzamj zzamj = com.google.android.gms.internal.zzamj.zzafM = new zzamj(new zzaml(context));
                    GoogleAnalytics.zzjo();
                    final long l = zzrY.elapsedRealtime() - elapsedRealtime;
                    final long longValue = zzans.zzahU.get();
                    if (l > longValue) {
                        zzamj.zzkr().zzc("Slow initialization (ms)", l, longValue);
                    }
                }
                return zzamj.zzafM;
            }
        }
    }
    
    public final Context getContext() {
        return this.mContext;
    }
    
    public final zzamu zzkB() {
        zza(this.zzafY);
        return this.zzafY;
    }
    
    public final zzano zzkC() {
        return this.zzafZ;
    }
    
    public final Context zzkE() {
        return this.zzafN;
    }
    
    public final zzaoc zzkF() {
        return this.zzafP;
    }
    
    public final GoogleAnalytics zzkG() {
        zzbo.zzu(this.zzafV);
        zzbo.zzb(this.zzafV.isInitialized(), (Object)"Analytics instance not initialized");
        return this.zzafV;
    }
    
    public final zzaog zzkH() {
        if (this.zzafU == null || !this.zzafU.isInitialized()) {
            return null;
        }
        return this.zzafU;
    }
    
    public final zzalx zzkI() {
        zza(this.zzafX);
        return this.zzafX;
    }
    
    public final zzanb zzkJ() {
        zza(this.zzafW);
        return this.zzafW;
    }
    
    public final zze zzkq() {
        return this.zzvw;
    }
    
    public final zzaoc zzkr() {
        zza(this.zzafP);
        return this.zzafP;
    }
    
    public final zzank zzks() {
        return this.zzafO;
    }
    
    public final zzl zzkt() {
        zzbo.zzu(this.zzafQ);
        return this.zzafQ;
    }
    
    public final zzaly zzkv() {
        zza(this.zzafR);
        return this.zzafR;
    }
    
    public final zzanp zzkw() {
        zza(this.zzafS);
        return this.zzafS;
    }
    
    public final zzaot zzkx() {
        zza(this.zzafT);
        return this.zzafT;
    }
    
    public final zzaog zzky() {
        zza(this.zzafU);
        return this.zzafU;
    }
}
