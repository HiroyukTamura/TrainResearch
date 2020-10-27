package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class zzami implements MediationAdRequest {
    private final String zzacs;
    private final int zzceh;
    private final boolean zzces;
    private final int zzdgl;
    private final int zzdgm;
    private final Date zzml;
    private final Set<String> zzmn;
    private final boolean zzmo;
    private final Location zzmp;

    public zzami(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zzml = date;
        this.zzceh = i;
        this.zzmn = set;
        this.zzmp = location;
        this.zzmo = z;
        this.zzdgl = i2;
        this.zzces = z2;
        this.zzdgm = i3;
        this.zzacs = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzml;
    }

    @Deprecated
    public final int getGender() {
        return this.zzceh;
    }

    public final Set<String> getKeywords() {
        return this.zzmn;
    }

    public final Location getLocation() {
        return this.zzmp;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzces;
    }

    public final boolean isTesting() {
        return this.zzmo;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdgl;
    }
}
