package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzmo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzex extends zzgw {
    private static final AtomicReference<String[]> zza = new AtomicReference<>();
    private static final AtomicReference<String[]> zzb = new AtomicReference<>();
    private static final AtomicReference<String[]> zzc = new AtomicReference<>();

    zzex(zzgd zzgd) {
        super(zzgd);
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzkw.zzc(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Nullable
    private final String zza(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder a = C0681a.m330a("[");
        for (Bundle bundle : objArr) {
            String zza2 = bundle instanceof Bundle ? zza(bundle) : String.valueOf(bundle);
            if (zza2 != null) {
                if (a.length() != 1) {
                    a.append(", ");
                }
                a.append(zza2);
            }
        }
        a.append("]");
        return a.toString();
    }

    private final boolean zzg() {
        zzu();
        return this.zzy.zzl() && this.zzy.zzr().zza(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzg()) {
            return bundle.toString();
        }
        StringBuilder a = C0681a.m330a("Bundle[{");
        for (String str : bundle.keySet()) {
            if (a.length() != 8) {
                a.append(", ");
            }
            a.append(zzb(str));
            a.append("=");
            if (!zzmo.zzb() || !zzt().zza(zzaq.zzcd)) {
                a.append(bundle.get(str));
            } else {
                Object obj = bundle.get(str);
                a.append(obj instanceof Bundle ? zza(new Object[]{obj}) : obj instanceof Object[] ? zza((Object[]) obj) : obj instanceof ArrayList ? zza(((ArrayList) obj).toArray()) : String.valueOf(obj));
            }
        }
        a.append("}]");
        return a.toString();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzao zzao) {
        String str = null;
        if (zzao == null) {
            return null;
        }
        if (!zzg()) {
            return zzao.toString();
        }
        StringBuilder a = C0681a.m330a("origin=");
        a.append(zzao.zzc);
        a.append(",name=");
        a.append(zza(zzao.zza));
        a.append(",params=");
        zzan zzan = zzao.zzb;
        if (zzan != null) {
            str = !zzg() ? zzan.toString() : zza(zzan.zzb());
        }
        a.append(str);
        return a.toString();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzhb.zzb, zzhb.zza, zza);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(String str) {
        if (str == null) {
            return null;
        }
        return !zzg() ? str : zza(str, zzha.zzb, zzha.zza, zzb);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzc(String str) {
        if (str == null) {
            return null;
        }
        if (!zzg()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzhd.zzb, zzhd.zza, zzc);
        }
        return "experiment_id" + "(" + str + ")";
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
}
