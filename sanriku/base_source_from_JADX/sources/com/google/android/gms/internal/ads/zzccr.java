package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzc;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzccr {
    private final Executor zzfhi;
    private final zzdhe zzfll;
    private final zzcey zzfud;

    public zzccr(zzdhe zzdhe, Executor executor, zzcey zzcey) {
        this.zzfll = zzdhe;
        this.zzfhi = executor;
        this.zzfud = zzcey;
    }

    private final void zzk(zzbek zzbek) {
        zzbek.zza("/video", (zzaga<? super zzbek>) zzafn.zzdaj);
        zzbek.zza("/videoMeta", (zzaga<? super zzbek>) zzafn.zzdak);
        zzbek.zza("/precache", (zzaga<? super zzbek>) new zzbdu());
        zzbek.zza("/delayPageLoaded", (zzaga<? super zzbek>) zzafn.zzdan);
        zzbek.zza("/instrument", (zzaga<? super zzbek>) zzafn.zzdal);
        zzbek.zza("/log", (zzaga<? super zzbek>) zzafn.zzdae);
        zzbek.zza("/videoClicked", (zzaga<? super zzbek>) zzafn.zzdaf);
        zzbek.zzabj().zzay(true);
        zzbek.zza("/click", (zzaga<? super zzbek>) zzafn.zzdaa);
        if (this.zzfll.zzdno != null) {
            zzbek.zzabj().zzaz(true);
            zzbek.zza("/open", (zzaga<? super zzbek>) new zzage((zzc) null, (zzaor) null));
            return;
        }
        zzbek.zzabj().zzaz(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(String str, String str2, Object obj) throws Exception {
        zzbek zza = this.zzfud.zza(zzum.zzph(), false);
        zzbak zzl = zzbak.zzl(zza);
        zzk(zza);
        zza.zza(this.zzfll.zzdno != null ? zzbfz.zzacn() : zzbfz.zzacm());
        zza.zzabj().zza((zzbfv) new zzccu(this, zza, zzl));
        zza.zzb(str, str2, (String) null);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(JSONObject jSONObject, zzbek zzbek) throws Exception {
        zzbak zzl = zzbak.zzl(zzbek);
        zzbek.zza(this.zzfll.zzdno != null ? zzbfz.zzacn() : zzbfz.zzacm());
        zzbek.zzabj().zza((zzbfv) new zzccx(this, zzbek, zzl));
        zzbek.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbek zzbek, zzbak zzbak, boolean z) {
        if (z) {
            if (!(this.zzfll.zzguv == null || zzbek.zzzf() == null)) {
                zzbek.zzzf().zzb(this.zzfll.zzguv);
            }
            zzbak.zzyj();
            return;
        }
        zzbak.setException(new zzcqm("Instream video Web View failed to load.", 0));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbek zzbek, zzbak zzbak, boolean z) {
        if (!(this.zzfll.zzguv == null || zzbek.zzzf() == null)) {
            zzbek.zzzf().zzb(this.zzfll.zzguv);
        }
        zzbak.zzyj();
    }

    public final zzdri<zzbek> zzn(JSONObject jSONObject) {
        return zzdqw.zzb(zzdqw.zzb(zzdqw.zzag(null), new zzccs(this), this.zzfhi), new zzccq(this, jSONObject), this.zzfhi);
    }

    public final zzdri<zzbek> zzo(String str, String str2) {
        return zzdqw.zzb(zzdqw.zzag(null), new zzcct(this, str, str2), this.zzfhi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzq(Object obj) throws Exception {
        zzbek zza = this.zzfud.zza(zzum.zzph(), false);
        zzbak zzl = zzbak.zzl(zza);
        zzk(zza);
        zza.zzabj().zza((zzbfy) new zzccv(zzl));
        zza.loadUrl((String) zzvj.zzpv().zzd(zzzz.zzcos));
        return zzl;
    }
}
