package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

public final class zzcoi implements zzcnj<zzbws> {
    private final zzdgm zzfgh;
    private final Executor zzfhi;
    private final zzbxr zzgfa;
    private final Context zzvf;

    public zzcoi(Context context, Executor executor, zzbxr zzbxr, zzdgm zzdgm) {
        this.zzvf = context;
        this.zzgfa = zzbxr;
        this.zzfhi = executor;
        this.zzfgh = zzdgm;
    }

    private static String zzd(zzdgo zzdgo) {
        try {
            return zzdgo.zzgtu.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(Uri uri, zzdha zzdha, zzdgo zzdgo, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzd zzd = new zzd(build.intent);
            zzbaj zzbaj = new zzbaj();
            zzbwu zza = this.zzgfa.zza(new zzboi(zzdha, zzdgo, (String) null), new zzbwx(new zzcok(zzbaj)));
            zzbaj.set(new AdOverlayInfoParcel(zzd, (zzub) null, zza.zzafp(), (zzt) null, new zzazz(0, 0, false)));
            this.zzfgh.zzvx();
            return zzdqw.zzag(zza.zzafo());
        } catch (Throwable th) {
            zzazw.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        return (this.zzvf instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaaw.zzj(this.zzvf) && !TextUtils.isEmpty(zzd(zzdgo));
    }

    public final zzdri<zzbws> zzb(zzdha zzdha, zzdgo zzdgo) {
        String zzd = zzd(zzdgo);
        return zzdqw.zzb(zzdqw.zzag(null), new zzcol(this, zzd != null ? Uri.parse(zzd) : null, zzdha, zzdgo), this.zzfhi);
    }
}
