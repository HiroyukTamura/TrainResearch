package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcpn implements zzcpk<zzbzm> {
    private final zzdrh zzfur;
    private final zzbyp zzgfy;
    private final zzcbw zzgfz;
    private final zzdhp<zzcdt> zzgga;

    public zzcpn(zzbyp zzbyp, zzdrh zzdrh, zzcbw zzcbw, zzdhp<zzcdt> zzdhp) {
        this.zzgfy = zzbyp;
        this.zzfur = zzdrh;
        this.zzgfz = zzcbw;
        this.zzgga = zzdhp;
    }

    private final zzdri<zzbzm> zzb(zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) {
        zzdri<zzcdt> zzasg = this.zzgga.zzasg();
        zzdri<zzbzx> zza = this.zzgfz.zza(zzdha, zzdgo, jSONObject);
        return zzdqw.zzb((zzdri<? extends V>[]) new zzdri[]{zzasg, zza}).zza(new zzcpq(this, zza, zzasg, zzdha, zzdgo, jSONObject), this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbzm zza(zzdri zzdri, zzdri zzdri2, zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) throws Exception {
        zzbzx zzbzx = (zzbzx) zzdri.get();
        zzcdt zzcdt = (zzcdt) zzdri2.get();
        zzbzz zza = this.zzgfy.zza(new zzboi(zzdha, zzdgo, (String) null), new zzcaj(zzbzx), new zzbza(jSONObject, zzcdt));
        zza.zzaep().zzamo();
        zza.zzaeq().zzb(zzcdt);
        zza.zzaer().zzl(zzbzx.zzalb());
        return zza.zzaeo();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzcdt zzcdt, JSONObject jSONObject) throws Exception {
        this.zzgga.zzd(zzdqw.zzag(zzcdt));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdqw.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzake("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdgo zzdgo, zzcdt zzcdt) throws Exception {
        JSONObject zza = zzayu.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdgo.zzgtr.zzfpz);
        jSONObject.put("sdk_params", zza);
        return zzdqw.zzb(zzcdt.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new zzcpo(this, zzcdt), (Executor) this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdha zzdha, zzdgo zzdgo, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdqw.immediateFailedFuture(new zzcjk(3));
        }
        int i = 0;
        if (zzdha.zzgur.zzfll.zzgkg <= 1) {
            return zzdqw.zzb(zzb(zzdha, zzdgo, jSONArray.getJSONObject(0)), zzcpr.zzdsc, (Executor) this.zzfur);
        }
        int length = jSONArray.length();
        this.zzgga.zzdw(Math.min(length, zzdha.zzgur.zzfll.zzgkg));
        ArrayList arrayList = new ArrayList(zzdha.zzgur.zzfll.zzgkg);
        while (i < zzdha.zzgur.zzfll.zzgkg) {
            arrayList.add(i < length ? zzb(zzdha, zzdgo, jSONArray.getJSONObject(i)) : zzdqw.immediateFailedFuture(new zzcjk(3)));
            i++;
        }
        return zzdqw.zzag(arrayList);
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        zzdgs zzdgs = zzdgo.zzgtr;
        return (zzdgs == null || zzdgs.zzfpz == null) ? false : true;
    }

    public final zzdri<List<zzdri<zzbzm>>> zzb(zzdha zzdha, zzdgo zzdgo) {
        return zzdqw.zzb(zzdqw.zzb(this.zzgga.zzasg(), new zzcpm(this, zzdgo), (Executor) this.zzfur), new zzcpp(this, zzdha, zzdgo), (Executor) this.zzfur);
    }
}
