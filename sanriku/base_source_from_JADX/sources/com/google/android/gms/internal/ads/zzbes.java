package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import java.util.concurrent.Executor;

public final class zzbes {
    public static zzbek zza(Context context, zzbfz zzbfz, String str, boolean z, boolean z2, @Nullable zzdt zzdt, zzazz zzazz, zzaam zzaam, zzi zzi, zza zza, zzst zzst, zzrv zzrv, boolean z3) throws zzbew {
        zzzz.initialize(context);
        if (zzabz.zzcyb.get().booleanValue()) {
            return zzbgf.zza(context, zzbfz, str, z, z2, zzdt, zzazz, (zzaam) null, zzi, zza, zzst, zzrv, z3);
        }
        try {
            return (zzbek) zzaze.zza(new zzbeu(context, zzbfz, str, z, z2, zzdt, zzazz, (zzaam) null, zzi, zza, zzst, zzrv, z3));
        } catch (Throwable th) {
            throw new zzbew("Webview initialization failed.", th);
        }
    }

    public static zzdri<zzbek> zza(Context context, zzazz zzazz, String str, zzdt zzdt, zza zza) {
        return zzdqw.zzb(zzdqw.zzag(null), new zzber(context, zzdt, zzazz, zza, str), (Executor) zzbab.zzdzv);
    }
}
