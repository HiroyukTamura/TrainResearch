package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzamq implements NativeMediationAdRequest {
    private final String zzacs;
    private final int zzceh;
    private final boolean zzces;
    private final int zzdgl;
    private final int zzdgm;
    private final zzaci zzdhc;
    private final List<String> zzdhd = new ArrayList();
    private final Map<String, Boolean> zzdhe = new HashMap();
    private final Date zzml;
    private final Set<String> zzmn;
    private final boolean zzmo;
    private final Location zzmp;

    public zzamq(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzaci zzaci, List<String> list, boolean z2, int i3, String str) {
        Map<String, Boolean> map;
        String str2;
        boolean z3;
        this.zzml = date;
        this.zzceh = i;
        this.zzmn = set;
        this.zzmp = location;
        this.zzmo = z;
        this.zzdgl = i2;
        this.zzdhc = zzaci;
        this.zzces = z2;
        this.zzdgm = i3;
        this.zzacs = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            map = this.zzdhe;
                            str2 = split[1];
                            z3 = true;
                        } else if ("false".equals(split[2])) {
                            map = this.zzdhe;
                            str2 = split[1];
                            z3 = false;
                        }
                        map.put(str2, z3);
                    }
                } else {
                    this.zzdhd.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzxw.zzqq().zzqb();
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

    public final NativeAdOptions getNativeAdOptions() {
        zzze zzze;
        if (this.zzdhc == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdhc.zzcyt).setImageOrientation(this.zzdhc.zzbkx).setRequestMultipleImages(this.zzdhc.zzbkz);
        zzaci zzaci = this.zzdhc;
        if (zzaci.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzaci.zzbla);
        }
        zzaci zzaci2 = this.zzdhc;
        if (zzaci2.versionCode >= 3 && (zzze = zzaci2.zzcyu) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzze));
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzxw.zzqq().zzqc();
    }

    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdhd;
        if (list != null) {
            return list.contains(ExifInterface.GPS_MEASUREMENT_2D) || this.zzdhd.contains("6");
        }
        return false;
    }

    public final boolean isContentAdRequested() {
        List<String> list = this.zzdhd;
        if (list != null) {
            return list.contains("1") || this.zzdhd.contains("6");
        }
        return false;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzces;
    }

    public final boolean isTesting() {
        return this.zzmo;
    }

    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdhd;
        return list != null && list.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdgl;
    }

    public final boolean zztw() {
        List<String> list = this.zzdhd;
        return list != null && list.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }

    public final Map<String, Boolean> zztx() {
        return this.zzdhe;
    }
}
