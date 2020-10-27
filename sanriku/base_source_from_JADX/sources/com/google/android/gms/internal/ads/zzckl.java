package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

final class zzckl implements zzdqx<zzdha> {
    private final /* synthetic */ zzckg zzgbk;

    zzckl(zzckg zzckg) {
        this.zzgbk = zzckg;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdha zzdha = (zzdha) obj;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue()) {
            this.zzgbk.zzgbg.zzds(zzdha.zzgus.zzgup.responseCode);
            this.zzgbk.zzgbg.zzeq(zzdha.zzgus.zzgup.zzgda);
        }
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue()) {
            Matcher matcher = zzckg.zzgbh.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzgbk.zzgbg.zzds(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
