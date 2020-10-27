package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import java.util.regex.Pattern;

public final class zzchn implements zzbrb, zzbrp, zzbtt {
    private final zzdha zzepv;
    private final zzdgo zzfgk;
    private final zzchz zzfiq;
    private final zzdhm zzfyt;
    @Nullable
    private Boolean zzfyu;
    private final boolean zzfyv = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcub)).booleanValue();
    private final Context zzvf;

    public zzchn(Context context, zzdhm zzdhm, zzchz zzchz, zzdha zzdha, zzdgo zzdgo) {
        this.zzvf = context;
        this.zzfyt = zzdhm;
        this.zzfiq = zzchz;
        this.zzepv = zzdha;
        this.zzfgk = zzdgo;
    }

    private final boolean zzanu() {
        if (this.zzfyu == null) {
            synchronized (this) {
                if (this.zzfyu == null) {
                    zzzk zzzk = zzzz.zzcne;
                    zzq.zzkw();
                    this.zzfyu = Boolean.valueOf(zzf((String) zzvj.zzpv().zzd(zzzk), zzaxa.zzbc(this.zzvf)));
                }
            }
        }
        return this.zzfyu.booleanValue();
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzq.zzla().zza(e, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzchy zzgf(String str) {
        zzchy zzc = this.zzfiq.zzaoa().zza(this.zzepv.zzgus.zzgup).zzc(this.zzfgk);
        zzc.zzq("action", str);
        if (!this.zzfgk.zzgts.isEmpty()) {
            zzc.zzq("ancn", this.zzfgk.zzgts.get(0));
        }
        return zzc;
    }

    public final void onAdImpression() {
        if (zzanu()) {
            zzgf("impression").zzany();
        }
    }

    public final void zza(zzbxy zzbxy) {
        if (this.zzfyv) {
            zzchy zzgf = zzgf("ifts");
            zzgf.zzq("reason", "exception");
            if (!TextUtils.isEmpty(zzbxy.getMessage())) {
                zzgf.zzq(NotificationCompat.CATEGORY_MESSAGE, zzbxy.getMessage());
            }
            zzgf.zzany();
        }
    }

    public final void zzais() {
        if (this.zzfyv) {
            zzchy zzgf = zzgf("ifts");
            zzgf.zzq("reason", "blocked");
            zzgf.zzany();
        }
    }

    public final void zzaiy() {
        if (zzanu()) {
            zzgf("adapter_impression").zzany();
        }
    }

    public final void zzaiz() {
        if (zzanu()) {
            zzgf("adapter_shown").zzany();
        }
    }

    public final void zzf(int i, @Nullable String str) {
        if (this.zzfyv) {
            zzchy zzgf = zzgf("ifts");
            zzgf.zzq("reason", "adapter");
            if (i >= 0) {
                zzgf.zzq("arec", String.valueOf(i));
            }
            String zzgs = this.zzfyt.zzgs(str);
            if (zzgs != null) {
                zzgf.zzq("areec", zzgs);
            }
            zzgf.zzany();
        }
    }
}
