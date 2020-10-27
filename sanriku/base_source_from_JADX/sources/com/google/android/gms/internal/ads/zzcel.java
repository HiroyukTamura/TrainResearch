package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;

public final class zzcel extends zzbns {
    private final zzate zzdri;
    private final WeakReference<zzbek> zzfor;
    private final zzbvg zzfos;
    private final zzbom zzfou;
    private final zzdly zzfov;
    private final zzbre zzfow;
    private final zzbxz zzfoz;
    private boolean zzfvz = false;
    private final zzbsl zzfwn;
    private final Context zzvf;

    zzcel(zzbnv zzbnv, Context context, @Nullable zzbek zzbek, zzbxz zzbxz, zzbvg zzbvg, zzbre zzbre, zzbsl zzbsl, zzbom zzbom, zzdgo zzdgo, zzdly zzdly) {
        super(zzbnv);
        this.zzvf = context;
        this.zzfoz = zzbxz;
        this.zzfor = new WeakReference<>(zzbek);
        this.zzfos = zzbvg;
        this.zzfow = zzbre;
        this.zzfwn = zzbsl;
        this.zzfou = zzbom;
        this.zzfov = zzdly;
        this.zzdri = new zzaub(zzdgo.zzdoi);
    }

    public final void finalize() throws Throwable {
        try {
            zzbek zzbek = (zzbek) this.zzfor.get();
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcty)).booleanValue()) {
                if (!this.zzfvz && zzbek != null) {
                    zzdrh zzdrh = zzbab.zzdzv;
                    zzbek.getClass();
                    zzdrh.execute(zzcek.zzh(zzbek));
                }
            } else if (zzbek != null) {
                zzbek.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzfwn.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzfou.isClosed();
    }

    public final boolean zzamq() {
        return this.zzfvz;
    }

    public final boolean zzb(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcla)).booleanValue()) {
            zzq.zzkw();
            if (zzaxa.zzau(this.zzvf)) {
                zzazw.zzfc("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzfow.zzais();
                if (((Boolean) zzvj.zzpv().zzd(zzzz.zzclb)).booleanValue()) {
                    this.zzfov.zzgz(this.zzfgj.zzgus.zzgup.zzdoh);
                }
                return false;
            }
        }
        if (this.zzfvz) {
            zzazw.zzfc("The rewarded ad have been showed.");
            this.zzfow.zzf(1, (String) null);
            return false;
        }
        this.zzfvz = true;
        this.zzfos.zzajn();
        Context context = activity;
        if (activity == null) {
            context = this.zzvf;
        }
        try {
            this.zzfoz.zza(z, context);
            return true;
        } catch (zzbxy e) {
            this.zzfow.zza(e);
            return false;
        }
    }

    public final zzate zzqt() {
        return this.zzdri;
    }

    public final boolean zzqu() {
        zzbek zzbek = (zzbek) this.zzfor.get();
        return zzbek != null && !zzbek.zzaby();
    }
}
