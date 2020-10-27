package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzcqi {
    /* access modifiers changed from: private */
    public final Clock zzbnt;
    /* access modifiers changed from: private */
    public final zzcqk zzggl;
    private final List<String> zzggm = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzggn;

    public zzcqi(Clock clock, zzcqk zzcqk) {
        this.zzbnt = clock;
        this.zzggl = zzcqk;
        this.zzggn = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcuc)).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 33));
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            sb2 = C0681a.m313a(C0681a.m336b(str2, C0681a.m336b(sb2, 1)), sb2, ".", str2);
        }
        this.zzggm.add(sb2);
    }

    /* access modifiers changed from: package-private */
    public final <T> zzdri<T> zza(zzdgq zzdgq, zzdgo zzdgo, zzdri<T> zzdri) {
        long elapsedRealtime = this.zzbnt.elapsedRealtime();
        String str = zzdgo.zzdfq;
        if (str != null) {
            zzdqw.zza(zzdri, new zzcql(this, str, elapsedRealtime, zzdgo, zzdgq), zzbab.zzdzw);
        }
        return zzdri;
    }

    public final String zzape() {
        return TextUtils.join("_", this.zzggm);
    }
}
