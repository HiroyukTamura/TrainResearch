package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

public final class zzdcn implements zzegz<ApplicationInfo> {
    private final zzdcl zzgpz;

    public zzdcn(zzdcl zzdcl) {
        this.zzgpz = zzdcl;
    }

    public static ApplicationInfo zzb(zzdcl zzdcl) {
        return (ApplicationInfo) zzehf.zza(zzdcl.zzara(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzgpz);
    }
}
