package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzacs;
    private final int zzdgl;
    private final String zzdhp;
    private final String zzelw;
    private final Bundle zzelx;
    private final Bundle zzely;
    private final int zzelz;
    private final boolean zzmo;
    private final Location zzmp;
    private final Context zzvf;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, String str3) {
        this.zzelw = str;
        this.zzelx = bundle;
        this.zzely = bundle2;
        this.zzvf = context;
        this.zzmo = z;
        this.zzmp = location;
        this.zzdgl = i;
        this.zzelz = i2;
        this.zzacs = str2;
        this.zzdhp = str3;
    }

    public String getBidResponse() {
        return this.zzelw;
    }

    public Context getContext() {
        return this.zzvf;
    }

    public Location getLocation() {
        return this.zzmp;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.zzacs;
    }

    public Bundle getMediationExtras() {
        return this.zzely;
    }

    public Bundle getServerParameters() {
        return this.zzelx;
    }

    public String getWatermark() {
        return this.zzdhp;
    }

    public boolean isTestRequest() {
        return this.zzmo;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdgl;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzelz;
    }
}
