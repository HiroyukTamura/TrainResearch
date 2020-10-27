package com.google.android.gms.internal.measurement;

import android.util.Log;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdb extends zzcw<Long> {
    zzdb(zzdf zzdf, String str, Long l, boolean z) {
        super(zzdf, str, l, z, (zzdb) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C0681a.m314a(valueOf.length() + C0681a.m336b(zzb, 25), "Invalid long value for ", zzb, ": ", valueOf));
        return null;
    }
}
