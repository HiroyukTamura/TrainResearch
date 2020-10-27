package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

public final class zzakq<I, O> implements zzakh<I, O> {
    private final zzajf zzddz;
    /* access modifiers changed from: private */
    public final zzakj<O> zzdea;
    private final zzaki<I> zzdeb;
    private final String zzdec;

    zzakq(zzajf zzajf, String str, zzaki<I> zzaki, zzakj<O> zzakj) {
        this.zzddz = zzajf;
        this.zzdec = str;
        this.zzdeb = zzaki;
        this.zzdea = zzakj;
    }

    /* access modifiers changed from: private */
    public final void zza(zzajs zzajs, zzakd zzakd, I i, zzbaj<O> zzbaj) {
        try {
            zzq.zzkw();
            String zzxg = zzaxa.zzxg();
            zzafn.zzdam.zza(zzxg, (zzagi) new zzakv(this, zzajs, zzbaj));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzxg);
            jSONObject.put("args", this.zzdeb.zzj(i));
            zzakd.zza(this.zzdec, jSONObject);
        } catch (Exception e) {
            zzbaj.setException(e);
            zzazw.zzc("Unable to invokeJavascript", e);
            zzajs.release();
        } catch (Throwable th) {
            zzajs.release();
            throw th;
        }
    }

    public final zzdri<O> zzf(@Nullable I i) throws Exception {
        return zzi(i);
    }

    public final zzdri<O> zzi(I i) {
        zzbaj zzbaj = new zzbaj();
        zzajs zzb = this.zzddz.zzb((zzdt) null);
        zzb.zza(new zzakt(this, zzb, i, zzbaj), new zzaks(this, zzbaj, zzb));
        return zzbaj;
    }
}
