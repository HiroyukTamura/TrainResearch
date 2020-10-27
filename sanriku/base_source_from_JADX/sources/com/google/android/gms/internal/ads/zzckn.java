package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzckn {
    private final Executor executor;
    private final zzdhe zzfll;
    private final zzazz zzgbn;
    private final Context zzvf;

    public zzckn(Context context, zzazz zzazz, zzdhe zzdhe, Executor executor2) {
        this.zzvf = context;
        this.zzgbn = zzazz;
        this.zzfll = zzdhe;
        this.executor = executor2;
    }

    public final zzdri<zzdha> zzaos() {
        zzakp zzb = zzq.zzlj().zzb(this.zzvf, this.zzgbn);
        zzakl<JSONObject> zzakl = zzakk.zzddu;
        zzakh<I, O> zza = zzb.zza("google.afma.response.normalize", zzakl, zzakl);
        return zzdqw.zzb(zzdqw.zzb(zzdqw.zzb(zzdqw.zzag(""), new zzckm(this, this.zzfll.zzguw.zzceu), this.executor), new zzckp(zza), this.executor), new zzcko(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzo(JSONObject jSONObject) throws Exception {
        return zzdqw.zzag(new zzdha(new zzdgv(this.zzfll), zzdgy.zza(new StringReader(jSONObject.toString()))));
    }
}
