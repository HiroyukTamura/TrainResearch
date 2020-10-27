package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;

public final class zzbbp extends zzbbh {
    @Nullable
    public final zzbbi zza(Context context, zzbbx zzbbx, int i, boolean z, zzaam zzaam, zzbby zzbby) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbca zzbca = new zzbca(context, zzbbx.zzzk(), zzbbx.getRequestId(), zzaam, zzbbx.zzzg());
        if (i == 2) {
            return new zzbce(context, zzbca, zzbbx, z, zzbbh.zza(zzbbx), zzbby);
        }
        return new zzbav(context, z, zzbbh.zza(zzbbx), zzbby, new zzbca(context, zzbbx.zzzk(), zzbbx.getRequestId(), zzaam, zzbbx.zzzg()));
    }
}
