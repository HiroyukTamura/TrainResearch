package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzays extends zzq<zzo> {
    private final Map<String, String> zzab;
    private final zzbaj<zzo> zzdya;
    private final zzazq zzdyb;

    public zzays(String str, zzbaj<zzo> zzbaj) {
        this(str, (Map<String, String>) null, zzbaj);
    }

    private zzays(String str, Map<String, String> map, zzbaj<zzo> zzbaj) {
        super(0, str, new zzayr(zzbaj));
        this.zzab = null;
        this.zzdya = zzbaj;
        zzazq zzazq = new zzazq();
        this.zzdyb = zzazq;
        zzazq.zza(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzz<zzo> zza(zzo zzo) {
        return zzz.zza(zzo, zzas.zzb(zzo));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zzo zzo = (zzo) obj;
        this.zzdyb.zza((Map<String, ?>) zzo.zzab, zzo.statusCode);
        zzazq zzazq = this.zzdyb;
        byte[] bArr = zzo.data;
        if (zzazq.isEnabled() && bArr != null) {
            zzazq.zzi(bArr);
        }
        this.zzdya.set(zzo);
    }
}
