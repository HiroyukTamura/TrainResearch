// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.stats.zze;
import android.text.TextUtils;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.util.zzx;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.annotation.SuppressLint;
import android.os.WorkSource;
import android.os.PowerManager$WakeLock;
import android.content.Context;

public final class zzctz
{
    private static boolean DEBUG;
    private static String TAG;
    private static String zzbCW;
    private final Context mContext;
    private final String zzaJp;
    private final String zzaJr;
    private final PowerManager$WakeLock zzbCX;
    private WorkSource zzbCY;
    private final int zzbCZ;
    private final String zzbDa;
    private boolean zzbDb;
    private int zzbDc;
    private int zzbDd;
    
    static {
        zzctz.TAG = "WakeLock";
        zzctz.zzbCW = "*gcore*:";
        zzctz.DEBUG = false;
    }
    
    public zzctz(final Context context, final int n, final String s) {
        String packageName;
        if (context == null) {
            packageName = null;
        }
        else {
            packageName = context.getPackageName();
        }
        this(context, 1, s, null, packageName);
    }
    
    @SuppressLint({ "UnwrappedWakeLock" })
    private zzctz(final Context context, final int n, final String s, final String s2, final String s3) {
        this(context, 1, s, null, s3, null);
    }
    
    @SuppressLint({ "UnwrappedWakeLock" })
    private zzctz(final Context context, final int zzbCZ, String packageName, String s, final String s2, String value) {
        this.zzbDb = true;
        zzbo.zzh(packageName, "Wake lock name can NOT be empty");
        this.zzbCZ = zzbCZ;
        this.zzbDa = null;
        this.zzaJr = null;
        this.mContext = context.getApplicationContext();
        while (true) {
            while (true) {
                Label_0088: {
                    Label_0204: {
                        if ("com.google.android.gms".equals(context.getPackageName())) {
                            break Label_0204;
                        }
                        s = String.valueOf(zzctz.zzbCW);
                        value = String.valueOf(packageName);
                        if (value.length() != 0) {
                            s = s.concat(value);
                            break Label_0204;
                        }
                        Label_0190: {
                            break Label_0190;
                            while (true) {
                                final WorkSource zzbCY = this.zzbCY;
                                try {
                                    this.zzbCX.setWorkSource(zzbCY);
                                    return;
                                    s = new String(s);
                                    break;
                                    this.zzaJp = packageName;
                                    break Label_0088;
                                    final WorkSource zzbCY2;
                                    this.zzbCY = zzbCY2;
                                }
                                catch (IllegalArgumentException ex) {
                                    Log.wtf(zzctz.TAG, ex.toString());
                                    return;
                                }
                            }
                        }
                    }
                    this.zzaJp = s;
                }
                this.zzbCX = ((PowerManager)context.getSystemService("power")).newWakeLock(zzbCZ, packageName);
                if (!zzx.zzaM(this.mContext)) {
                    return;
                }
                packageName = s2;
                if (zzt.zzcL(s2)) {
                    packageName = context.getPackageName();
                }
                this.zzbCY = zzx.zzD(context, packageName);
                final WorkSource zzbCY2 = this.zzbCY;
                if (zzbCY2 == null || !zzx.zzaM(this.mContext)) {
                    return;
                }
                if (this.zzbCY != null) {
                    this.zzbCY.add(zzbCY2);
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private final boolean zzeV(String zzbDa) {
        if (!TextUtils.isEmpty((CharSequence)null)) {
            zzbDa = this.zzbDa;
            throw new NullPointerException();
        }
        return false;
    }
    
    private final String zzi(final String s, final boolean b) {
        if (!this.zzbDb) {
            return this.zzbDa;
        }
        if (b) {
            return null;
        }
        return this.zzbDa;
    }
    
    public final void acquire(final long n) {
        final boolean zzeV = this.zzeV(null);
        final String zzi = this.zzi(null, zzeV);
        synchronized (this) {
            if ((this.zzbDb && (this.zzbDc++ == 0 || zzeV)) || (!this.zzbDb && this.zzbDd == 0)) {
                zze.zzrX();
                zze.zza(this.mContext, zzc.zza(this.zzbCX, zzi), 7, this.zzaJp, zzi, null, this.zzbCZ, zzx.zzb(this.zzbCY), 1000L);
                ++this.zzbDd;
            }
            // monitorexit(this)
            this.zzbCX.acquire(1000L);
        }
    }
    
    public final boolean isHeld() {
        return this.zzbCX.isHeld();
    }
    
    public final void release() {
        final boolean zzeV = this.zzeV(null);
        final String zzi = this.zzi(null, zzeV);
        synchronized (this) {
            Label_0105: {
                Label_0057: {
                    if (this.zzbDb) {
                        final int zzbDc = this.zzbDc - 1;
                        this.zzbDc = zzbDc;
                        if (zzbDc == 0 || zzeV) {
                            break Label_0057;
                        }
                    }
                    if (this.zzbDb || this.zzbDd != 1) {
                        break Label_0105;
                    }
                }
                zze.zzrX();
                zze.zza(this.mContext, zzc.zza(this.zzbCX, zzi), 8, this.zzaJp, zzi, null, this.zzbCZ, zzx.zzb(this.zzbCY));
                --this.zzbDd;
            }
            // monitorexit(this)
            this.zzbCX.release();
        }
    }
    
    public final void setReferenceCounted(final boolean b) {
        this.zzbCX.setReferenceCounted(false);
        this.zzbDb = false;
    }
}
