package com.google.android.gms.internal.measurement;

import android.util.Log;
import p009e.p010a.p011a.p012a.C0681a;

final class zzda extends zzcw<Boolean> {
    zzda(zzdf zzdf, String str, Boolean bool, boolean z) {
        super(zzdf, str, bool, z, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzcf.zzb.matcher(str).matches()) {
                return true;
            }
            if (zzcf.zzc.matcher(str).matches()) {
                return false;
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C0681a.m314a(valueOf.length() + C0681a.m336b(zzb, 28), "Invalid boolean value for ", zzb, ": ", valueOf));
        return null;
    }
}
