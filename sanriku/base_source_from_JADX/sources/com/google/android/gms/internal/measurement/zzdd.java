package com.google.android.gms.internal.measurement;

import android.util.Log;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdd extends zzcw<Double> {
    zzdd(zzdf zzdf, String str, Double d, boolean z) {
        super(zzdf, str, d, z, (zzdb) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Double zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C0681a.m314a(valueOf.length() + C0681a.m336b(zzb, 27), "Invalid double value for ", zzb, ": ", valueOf));
        return null;
    }
}
