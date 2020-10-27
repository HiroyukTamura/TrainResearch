package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;

final class zzcrg implements zzbxz {
    private final zzazz zzbml;
    private final zzdgo zzfkd;
    private final zzdhe zzfll;
    private final zzcey zzfud;
    private final zzdri<zzcen> zzgft;
    private final zzbek zzghd;
    private final Context zzvf;

    private zzcrg(Context context, zzcey zzcey, zzdhe zzdhe, zzazz zzazz, zzdgo zzdgo, zzdri<zzcen> zzdri, zzbek zzbek) {
        this.zzvf = context;
        this.zzfud = zzcey;
        this.zzfll = zzdhe;
        this.zzbml = zzazz;
        this.zzfkd = zzdgo;
        this.zzgft = zzdri;
        this.zzghd = zzbek;
    }

    public final void zza(boolean z, Context context) {
        zzbek zzbek;
        zzcen zzcen = (zzcen) zzdqw.zzb(this.zzgft);
        try {
            zzdgo zzdgo = this.zzfkd;
            if (this.zzghd.zzaby()) {
                if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclh)).booleanValue()) {
                    zzbek zzc = this.zzfud.zzc(this.zzfll.zzbmp);
                    zzagl.zza(zzc, (zzagk) zzcen.zzafx());
                    zzcfo zzcfo = new zzcfo();
                    zzcfo.zzc(this.zzvf, zzc.getView());
                    zzcen.zzaez().zzb(zzc, true);
                    zzc.zzabj().zza((zzbfv) new zzcrj(zzcfo, zzc));
                    zzbfw zzabj = zzc.zzabj();
                    zzc.getClass();
                    zzabj.zza(zzcri.zzq(zzc));
                    zzc.zzb(zzdgo.zzgtr.zzdku, zzdgo.zzgtr.zzdkw, (String) null);
                    zzbek = zzc;
                    zzbek.zzba(true);
                    zzq.zzkw();
                    boolean zzbb = zzaxa.zzbb(this.zzvf);
                    zzdgo zzdgo2 = this.zzfkd;
                    zzg zzg = new zzg(false, zzbb, false, 0.0f, -1, z, zzdgo2.zzfin, zzdgo2.zzbmh);
                    zzq.zzkv();
                    zzbxp zzafq = zzcen.zzafq();
                    zzdgo zzdgo3 = this.zzfkd;
                    int i = zzdgo3.zzgty;
                    zzazz zzazz = this.zzbml;
                    String str = zzdgo3.zzdny;
                    zzdgs zzdgs = zzdgo3.zzgtr;
                    String str2 = zzdgs.zzdku;
                    zzn.zza(context, new AdOverlayInfoParcel((zzub) null, (zzo) zzafq, (zzt) null, zzbek, i, zzazz, str, zzg, str2, zzdgs.zzdkw), true);
                }
            }
            zzbek = this.zzghd;
            zzbek.zzba(true);
            zzq.zzkw();
            boolean zzbb2 = zzaxa.zzbb(this.zzvf);
            zzdgo zzdgo22 = this.zzfkd;
            zzg zzg2 = new zzg(false, zzbb2, false, 0.0f, -1, z, zzdgo22.zzfin, zzdgo22.zzbmh);
            zzq.zzkv();
            zzbxp zzafq2 = zzcen.zzafq();
            zzdgo zzdgo32 = this.zzfkd;
            int i2 = zzdgo32.zzgty;
            zzazz zzazz2 = this.zzbml;
            String str3 = zzdgo32.zzdny;
            zzdgs zzdgs2 = zzdgo32.zzgtr;
            String str22 = zzdgs2.zzdku;
            zzn.zza(context, new AdOverlayInfoParcel((zzub) null, (zzo) zzafq2, (zzt) null, zzbek, i2, zzazz2, str3, zzg2, str22, zzdgs2.zzdkw), true);
        } catch (zzbew e) {
            zzazw.zzc("", e);
        }
    }
}
