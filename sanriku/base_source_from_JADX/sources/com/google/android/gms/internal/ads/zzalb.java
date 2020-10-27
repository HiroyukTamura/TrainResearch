package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzalb<I, O> implements zzdqj<I, O> {
    /* access modifiers changed from: private */
    public final zzakj<O> zzdea;
    private final zzaki<I> zzdeb;
    private final String zzdec;
    private final zzdri<zzakd> zzdeh;

    zzalb(zzdri<zzakd> zzdri, String str, zzaki<I> zzaki, zzakj<O> zzakj) {
        this.zzdeh = zzdri;
        this.zzdec = str;
        this.zzdeb = zzaki;
        this.zzdea = zzakj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(Object obj, zzakd zzakd) throws Exception {
        zzbaj zzbaj = new zzbaj();
        zzq.zzkw();
        String zzxg = zzaxa.zzxg();
        zzafn.zzdam.zza(zzxg, (zzagi) new zzald(this, zzbaj));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzxg);
        jSONObject.put("args", this.zzdeb.zzj(obj));
        zzakd.zza(this.zzdec, jSONObject);
        return zzbaj;
    }

    public final zzdri<O> zzf(I i) throws Exception {
        return zzdqw.zzb(this.zzdeh, new zzala(this, i), (Executor) zzbab.zzdzw);
    }
}
