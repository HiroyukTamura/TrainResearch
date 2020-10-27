package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcby implements Callable {
    private final zzdri zzflc;
    private final zzdri zzfmu;
    private final zzcbw zzfuu;
    private final zzdri zzfuv;
    private final zzdri zzfuw;
    private final zzdri zzfux;
    private final JSONObject zzfuy;
    private final zzdri zzfuz;
    private final zzdri zzfva;
    private final zzdri zzfvb;

    zzcby(zzcbw zzcbw, zzdri zzdri, zzdri zzdri2, zzdri zzdri3, zzdri zzdri4, zzdri zzdri5, JSONObject jSONObject, zzdri zzdri6, zzdri zzdri7, zzdri zzdri8) {
        this.zzfuu = zzcbw;
        this.zzfmu = zzdri;
        this.zzflc = zzdri2;
        this.zzfuv = zzdri3;
        this.zzfuw = zzdri4;
        this.zzfux = zzdri5;
        this.zzfuy = jSONObject;
        this.zzfuz = zzdri6;
        this.zzfva = zzdri7;
        this.zzfvb = zzdri8;
    }

    public final Object call() {
        zzdri zzdri = this.zzfmu;
        zzdri zzdri2 = this.zzflc;
        zzdri zzdri3 = this.zzfuv;
        zzdri zzdri4 = this.zzfuw;
        zzdri zzdri5 = this.zzfux;
        JSONObject jSONObject = this.zzfuy;
        zzdri zzdri6 = this.zzfuz;
        zzdri zzdri7 = this.zzfva;
        zzdri zzdri8 = this.zzfvb;
        zzbzx zzbzx = (zzbzx) zzdri.get();
        zzbzx.setImages((List) zzdri2.get());
        zzbzx.zza((zzacs) zzdri3.get());
        zzbzx.zzb((zzacs) zzdri4.get());
        zzbzx.zza((zzack) zzdri5.get());
        zzbzx.zzg(zzcca.zzj(jSONObject));
        zzbzx.zza(zzcca.zzk(jSONObject));
        zzbek zzbek = (zzbek) zzdri6.get();
        if (zzbek != null) {
            zzbzx.zzi(zzbek);
            zzbzx.zzab(zzbek.getView());
            zzbzx.zzb((zzxl) zzbek.zzzf());
        }
        zzbek zzbek2 = (zzbek) zzdri7.get();
        if (zzbek2 != null) {
            zzbzx.zzj(zzbek2);
        }
        for (zzccp zzccp : (List) zzdri8.get()) {
            int i = zzccp.type;
            if (i == 1) {
                zzbzx.zzn(zzccp.zzcc, zzccp.zzfvq);
            } else if (i == 2) {
                zzbzx.zza(zzccp.zzcc, zzccp.zzfvr);
            }
        }
        return zzbzx;
    }
}
