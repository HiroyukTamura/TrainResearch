package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.C0654R;

public final class zzuv {
    private final String zzbsc;
    private final AdSize[] zzcfn;

    public zzuv(Context context, AttributeSet attributeSet) {
        IllegalArgumentException illegalArgumentException;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0654R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(C0654R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C0654R.styleable.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = !TextUtils.isEmpty(string2);
        if (z && !z2) {
            this.zzcfn = zzce(string);
        } else if (!z && z2) {
            this.zzcfn = zzce(string2);
        } else if (z) {
            throw illegalArgumentException;
        } else {
            illegalArgumentException = new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
            throw illegalArgumentException;
        }
        String string3 = obtainAttributes.getString(C0654R.styleable.AdsAttrs_adUnitId);
        this.zzbsc = string3;
        if (TextUtils.isEmpty(string3)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] zzce(String str) {
        String[] split = str.split("\\s*,\\s*");
        int length = split.length;
        AdSize[] adSizeArr = new AdSize[length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    adSizeArr[i] = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(trim.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(trim) : new String("Could not parse XML attribute \"adSize\": "));
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(trim)) {
                adSizeArr[i] = AdSize.FLUID;
            } else if ("ICON".equals(trim)) {
                adSizeArr[i] = AdSize.zzace;
            } else {
                throw new IllegalArgumentException(trim.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(trim) : new String("Could not parse XML attribute \"adSize\": "));
            }
        }
        if (length != 0) {
            return adSizeArr;
        }
        throw new IllegalArgumentException(str.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(str) : new String("Could not parse XML attribute \"adSize\": "));
    }

    public final String getAdUnitId() {
        return this.zzbsc;
    }

    public final AdSize[] zzy(boolean z) {
        if (z || this.zzcfn.length == 1) {
            return this.zzcfn;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
