package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcbw {
    private final zzdrh zzfur;
    private final zzcca zzfus;
    private final zzcck zzfut;

    public zzcbw(zzdrh zzdrh, zzcca zzcca, zzcck zzcck) {
        this.zzfur = zzdrh;
        this.zzfus = zzcca;
        this.zzfut = zzcck;
    }

    public final zzdri<zzbzx> zza(zzdha zzdha, zzdgo zzdgo, JSONObject jSONObject) {
        JSONObject optJSONObject;
        zzdri zzb;
        JSONObject jSONObject2 = jSONObject;
        zzdha zzdha2 = zzdha;
        zzdri zzd = this.zzfur.zzd(new zzcbz(this, zzdha, zzdgo, jSONObject2));
        zzdri<List<zzace>> zzd2 = this.zzfus.zzd(jSONObject2, "images");
        zzdri<zzace> zzc = this.zzfus.zzc(jSONObject2, "secondary_image");
        zzdri<zzace> zzc2 = this.zzfus.zzc(jSONObject2, "app_icon");
        zzdri<zzacd> zze = this.zzfus.zze(jSONObject2, "attribution");
        zzdri<zzbek> zzm = this.zzfus.zzm(jSONObject2);
        zzcca zzcca = this.zzfus;
        if (jSONObject2.optBoolean("enable_omid") && (optJSONObject = jSONObject2.optJSONObject("omid_settings")) != null) {
            String optString = optJSONObject.optString("omid_html");
            if (!TextUtils.isEmpty(optString)) {
                zzb = zzdqw.zzb(zzdqw.zzag(null), new zzcce(zzcca, optString), (Executor) zzbab.zzdzv);
                zzdri zzdri = zzb;
                zzdri<List<zzccp>> zzg = this.zzfut.zzg(jSONObject2, "custom_assets");
                return zzdqw.zza((zzdri<? extends V>[]) new zzdri[]{zzd, zzd2, zzc, zzc2, zze, zzm, zzdri, zzg}).zza(new zzcby(this, zzd, zzd2, zzc2, zzc, zze, jSONObject, zzm, zzdri, zzg), this.zzfur);
            }
        }
        zzb = zzdqw.zzag(null);
        zzdri zzdri2 = zzb;
        zzdri<List<zzccp>> zzg2 = this.zzfut.zzg(jSONObject2, "custom_assets");
        return zzdqw.zza((zzdri<? extends V>[]) new zzdri[]{zzd, zzd2, zzc, zzc2, zze, zzm, zzdri2, zzg2}).zza(new zzcby(this, zzd, zzd2, zzc2, zzc, zze, jSONObject, zzm, zzdri2, zzg2), this.zzfur);
    }
}
