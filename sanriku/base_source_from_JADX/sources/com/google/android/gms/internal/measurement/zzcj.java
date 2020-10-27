package com.google.android.gms.internal.measurement;

import android.content.Context;
import p009e.p010a.p011a.p012a.C0681a;

final class zzcj extends zzde {
    private final Context zza;
    private final zzdv<zzdr<zzcs>> zzb;

    zzcj(Context context, zzdv<zzdr<zzcs>> zzdv) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzdv;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzde) {
            zzde zzde = (zzde) obj;
            if (this.zza.equals(zzde.zza())) {
                zzdv<zzdr<zzcs>> zzdv = this.zzb;
                zzdv<zzdr<zzcs>> zzb2 = zzde.zzb();
                return zzdv != null ? zzdv.equals(zzb2) : zzb2 == null;
            }
        }
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdv<zzdr<zzcs>> zzdv = this.zzb;
        return hashCode ^ (zzdv == null ? 0 : zzdv.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder b = C0681a.m337b(valueOf2.length() + valueOf.length() + 46, "FlagsContext{context=", valueOf, ", hermeticFileOverrides=", valueOf2);
        b.append("}");
        return b.toString();
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzdv<zzdr<zzcs>> zzb() {
        return this.zzb;
    }
}
