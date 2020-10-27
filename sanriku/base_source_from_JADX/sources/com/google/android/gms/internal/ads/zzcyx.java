package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzcyx implements zzdah<Bundle>, zzdak<zzdah<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdly;

    zzcyx(ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdly = packageInfo;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        return zzdqw.zzag(this);
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdly;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
    }
}
