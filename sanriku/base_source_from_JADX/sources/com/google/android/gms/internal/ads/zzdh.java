package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbm;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzdh {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzvq = new ConditionVariable();
    @VisibleForTesting
    protected static volatile zzsy zzvr = null;
    private static volatile Random zzvt = null;
    /* access modifiers changed from: private */
    public zzeo zzvp;
    @VisibleForTesting
    protected volatile Boolean zzvs;

    public zzdh(zzeo zzeo) {
        this.zzvp = zzeo;
        zzeo.zzch().execute(new zzdk(this));
    }

    public static int zzbv() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzbw().nextInt();
        } catch (RuntimeException unused) {
            return zzbw().nextInt();
        }
    }

    private static Random zzbw() {
        if (zzvt == null) {
            synchronized (zzdh.class) {
                if (zzvt == null) {
                    zzvt = new Random();
                }
            }
        }
        return zzvt;
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, (String) null, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str) {
        zza(i, -1, j, str, (Exception) null);
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzvq.block();
            if (this.zzvs.booleanValue() && zzvr != null) {
                zzbm.zza.C2651zza zzc = zzbm.zza.zzt().zzi(this.zzvp.zzvf.getPackageName()).zzc(j);
                if (str != null) {
                    zzc.zzl(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzdzz.zza((Throwable) exc, new PrintWriter(stringWriter));
                    zzc.zzj(stringWriter.toString()).zzk(exc.getClass().getName());
                }
                zztc zzf = zzvr.zzf(((zzbm.zza) ((zzecd) zzc.zzbet())).toByteArray());
                zzf.zzbs(i);
                if (i2 != -1) {
                    zzf.zzbr(i2);
                }
                zzf.zzdx();
            }
        } catch (Exception unused) {
        }
    }
}
