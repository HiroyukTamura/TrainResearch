package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzez extends zzgw {
    /* access modifiers changed from: private */
    public char zza = 0;
    /* access modifiers changed from: private */
    public long zzb = -1;
    @GuardedBy("this")
    private String zzc;
    private final zzfb zzd = new zzfb(this, 6, false, false);
    private final zzfb zze = new zzfb(this, 6, true, false);
    private final zzfb zzf = new zzfb(this, 6, false, true);
    private final zzfb zzg = new zzfb(this, 5, false, false);
    private final zzfb zzh = new zzfb(this, 5, true, false);
    private final zzfb zzi = new zzfb(this, 5, false, true);
    private final zzfb zzj = new zzfb(this, 4, false, false);
    private final zzfb zzk = new zzfb(this, 3, false, false);
    private final zzfb zzl = new zzfb(this, 2, false, false);

    zzez(zzgd zzgd) {
        super(zzgd);
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzfa(str);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + str.length() + 43);
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof zzfa ? ((zzfa) obj).zza : z ? "-" : String.valueOf(obj);
            }
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzb2 = zzb(zzgd.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(zzb2)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i++;
            }
            return sb2.toString();
        }
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zza2 = zza(z, obj);
        String zza3 = zza(z, obj2);
        String zza4 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zza4)) {
            sb.append(str3);
            sb.append(zza4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private final String zzad() {
        String str;
        String str2;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzy.zzs() != null) {
                    str2 = this.zzy.zzs();
                } else {
                    zzt().zzu();
                    str2 = "FA";
                }
                this.zzc = str2;
            }
            str = this.zzc;
        }
        return str;
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zzad(), str);
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfw zzg2 = this.zzy.zzg();
            if (zzg2 == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (!zzg2.zzz()) {
                str2 = "Scheduler not initialized. Not logging error/warn";
            } else {
                if (i < 0) {
                    i = 0;
                }
                zzg2.zza((Runnable) new zzey(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
                return;
            }
            zza(6, str2);
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean zza(int i) {
        return Log.isLoggable(zzad(), i);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final zzfb zzf() {
        return this.zzd;
    }

    public final zzfb zzg() {
        return this.zze;
    }

    public final zzfb zzh() {
        return this.zzf;
    }

    public final zzfb zzi() {
        return this.zzg;
    }

    public final zzfb zzj() {
        return this.zzh;
    }

    public final zzfb zzk() {
        return this.zzi;
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    public final zzfb zzv() {
        return this.zzj;
    }

    public final zzfb zzw() {
        return this.zzk;
    }

    public final zzfb zzx() {
        return this.zzl;
    }

    public final String zzy() {
        Pair<String, Long> zza2 = zzs().zzb.zza();
        if (zza2 == null || zza2 == zzfl.zza) {
            return null;
        }
        String valueOf = String.valueOf(zza2.second);
        String str = (String) zza2.first;
        return C0681a.m313a(C0681a.m336b(str, valueOf.length() + 1), valueOf, ":", str);
    }
}
