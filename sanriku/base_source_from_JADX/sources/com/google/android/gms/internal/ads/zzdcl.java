package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;

public final class zzdcl {
    private final zzarj zzgbt;
    private final int zzgpk;

    public zzdcl(zzarj zzarj, int i) {
        this.zzgbt = zzarj;
        this.zzgpk = i;
    }

    public final String zzaqv() {
        return this.zzgbt.packageName;
    }

    public final String zzaqw() {
        return this.zzgbt.zzdpe.getString("ms");
    }

    @Nullable
    public final PackageInfo zzaqx() {
        return this.zzgbt.zzdly;
    }

    public final boolean zzaqy() {
        return this.zzgbt.zzdpf;
    }

    public final List<String> zzaqz() {
        return this.zzgbt.zzdmi;
    }

    public final ApplicationInfo zzara() {
        return this.zzgbt.applicationInfo;
    }

    public final String zzarb() {
        return this.zzgbt.zzdpg;
    }

    public final int zzarc() {
        return this.zzgpk;
    }
}
