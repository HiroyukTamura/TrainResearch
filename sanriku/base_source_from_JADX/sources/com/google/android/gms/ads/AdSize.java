package com.google.android.gms.ads;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzvj;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    public static final AdSize zzace = new AdSize(50, 50, "50x50_mb");
    private final int height;
    private final int width;
    private final String zzacf;
    private boolean zzacg;
    private boolean zzach;
    private int zzaci;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r6, int r7) {
        /*
            r5 = this;
            r0 = -1
            if (r6 != r0) goto L_0x0006
            java.lang.String r0 = "FULL"
            goto L_0x000a
        L_0x0006:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        L_0x000a:
            r1 = -2
            if (r7 != r1) goto L_0x0010
            java.lang.String r1 = "AUTO"
            goto L_0x0014
        L_0x0010:
            java.lang.String r1 = java.lang.String.valueOf(r7)
        L_0x0014:
            r2 = 4
            int r2 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r0, (int) r2)
            int r2 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r1, (int) r2)
            java.lang.String r3 = "x"
            java.lang.String r4 = "_as"
            java.lang.String r0 = p009e.p010a.p011a.p012a.C0681a.m314a((int) r2, (java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r1, (java.lang.String) r4)
            r5.<init>(r6, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(C0681a.m309a(37, "Invalid width for AdSize: ", i));
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.width = i;
            this.height = i2;
            this.zzacf = str;
        } else {
            throw new IllegalArgumentException(C0681a.m309a(38, "Invalid height for AdSize: ", i2));
        }
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzazm.zza(context, i, 50, 0);
        zza.zzacg = true;
        return zza;
    }

    @Deprecated
    public static AdSize getCurrentOrientationBannerAdSizeWithWidth(Context context, int i) {
        return getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int zze = zzazm.zze(context, 0);
        if (zze == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzaci = zze;
        adSize.zzach = true;
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzazm.zza(context, i, 50, 2);
        zza.zzacg = true;
        return zza;
    }

    @Deprecated
    public static AdSize getLandscapeBannerAdSizeWithWidth(Context context, int i) {
        return getLandscapeAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i) {
        int zze = zzazm.zze(context, 2);
        AdSize adSize = new AdSize(i, 0);
        if (zze == -1) {
            return INVALID;
        }
        adSize.zzaci = zze;
        adSize.zzach = true;
        return adSize;
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize zza = zzazm.zza(context, i, 50, 1);
        zza.zzacg = true;
        return zza;
    }

    @Deprecated
    public static AdSize getPortraitBannerAdSizeWithWidth(Context context, int i) {
        return getPortraitAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i) {
        int zze = zzazm.zze(context, 1);
        AdSize adSize = new AdSize(i, 0);
        if (zze == -1) {
            return INVALID;
        }
        adSize.zzaci = zze;
        adSize.zzach = true;
        return adSize;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.width == adSize.width && this.height == adSize.height && this.zzacf.equals(adSize.zzacf);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.height;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzum.zzc(context.getResources().getDisplayMetrics());
        }
        zzvj.zzpr();
        return zzazm.zzc(context, this.height);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.width;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -1) {
            return zzum.zzb(context.getResources().getDisplayMetrics());
        }
        zzvj.zzpr();
        return zzazm.zzc(context, this.width);
    }

    public final int hashCode() {
        return this.zzacf.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.height == -2;
    }

    public final boolean isFluid() {
        return this.width == -3 && this.height == -4;
    }

    public final boolean isFullWidth() {
        return this.width == -1;
    }

    public final String toString() {
        return this.zzacf;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        this.zzach = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdr() {
        return this.zzacg;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzds() {
        return this.zzach;
    }

    /* access modifiers changed from: package-private */
    public final int zzdt() {
        return this.zzaci;
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i) {
        this.zzaci = i;
    }
}
