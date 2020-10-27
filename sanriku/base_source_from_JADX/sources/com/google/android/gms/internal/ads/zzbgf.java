package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;

public final class zzbgf {
    public static zzbek zza(Context context, zzbfz zzbfz, String str, boolean z, boolean z2, @Nullable zzdt zzdt, zzazz zzazz, zzaam zzaam, zzi zzi, zza zza, zzst zzst, zzrv zzrv, boolean z3) throws zzbew {
        try {
            return (zzbek) zzaze.zza(new zzbgi(context, zzbfz, str, z, z2, zzdt, zzazz, (zzaam) null, zzi, zza, zzst, zzrv, z3));
        } catch (Throwable th) {
            zzq.zzla().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbew("Webview initialization failed.", th);
        }
    }
}
