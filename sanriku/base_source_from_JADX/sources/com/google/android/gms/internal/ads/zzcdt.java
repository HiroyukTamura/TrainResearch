package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcdt {
    private final zzbes zzbnm;
    private final zzazz zzdls;
    private final zzdt zzejl;
    private final Executor zzfhi;
    private final zza zzfvf;
    /* access modifiers changed from: private */
    public final zzcdy zzfwf = new zzcdy((zzcdu) null);
    private final zzagg zzfwg;
    private zzdri<zzbek> zzfwh;
    private final Context zzvf;

    zzcdt(zzced zzced) {
        this.zzvf = zzced.zzvf;
        this.zzfhi = zzced.zzfhi;
        this.zzejl = zzced.zzejl;
        this.zzdls = zzced.zzdls;
        this.zzfvf = zzced.zzfvf;
        this.zzbnm = zzced.zzbnm;
        this.zzfwg = new zzagg();
    }

    public final synchronized void destroy() {
        if (this.zzfwh != null) {
            zzdqw.zza(this.zzfwh, new zzcdu(this), this.zzfhi);
            this.zzfwh = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(String str, JSONObject jSONObject, zzbek zzbek) throws Exception {
        return this.zzfwg.zza(zzbek, str, jSONObject);
    }

    public final synchronized void zza(String str, zzaga<Object> zzaga) {
        if (this.zzfwh != null) {
            zzdqw.zza(this.zzfwh, new zzcdx(this, str, zzaga), this.zzfhi);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzfwh != null) {
            zzdqw.zza(this.zzfwh, new zzcdz(this, str, map), this.zzfhi);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzaga<T> zzaga) {
        zza(str, (zzaga<Object>) new zzcec(this, weakReference, str, zzaga, (zzcdu) null));
    }

    public final synchronized void zzamp() {
        zzdri<zzbek> zzb = zzdqw.zzb(zzbes.zza(this.zzvf, this.zzdls, (String) zzvj.zzpv().zzd(zzzz.zzcoq), this.zzejl, this.zzfvf), new zzcds(this), this.zzfhi);
        this.zzfwh = zzb;
        zzbaf.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzaga<Object> zzaga) {
        if (this.zzfwh != null) {
            zzdqw.zza(this.zzfwh, new zzcdw(this, str, zzaga), this.zzfhi);
        }
    }

    public final synchronized zzdri<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzfwh == null) {
            return zzdqw.zzag(null);
        }
        return zzdqw.zzb(this.zzfwh, new zzcdv(this, str, jSONObject), this.zzfhi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbek zzm(zzbek zzbek) {
        zzbek.zza("/result", (zzaga<? super zzbek>) this.zzfwg);
        zzbfw zzabj = zzbek.zzabj();
        zzcdy zzcdy = this.zzfwf;
        zzabj.zza((zzub) null, zzcdy, zzcdy, zzcdy, zzcdy, false, (zzagd) null, new zzc(this.zzvf, (zzaun) null, (zzaqy) null), (zzapa) null, (zzaun) null);
        return zzbek;
    }
}
