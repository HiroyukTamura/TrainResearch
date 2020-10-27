package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public final class zzacd extends zzacn {
    private static final int zzcyh = Color.rgb(12, 174, 206);
    private static final int zzcyi;
    private static final int zzcyj;
    private static final int zzcyk = zzcyh;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzcyl;
    private final List<zzace> zzcym = new ArrayList();
    private final List<zzacs> zzcyn = new ArrayList();
    private final int zzcyo;
    private final int zzcyp;
    private final boolean zzcyq;

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzcyi = rgb;
        zzcyj = rgb;
    }

    public zzacd(String str, List<zzace> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzcyl = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzace zzace = list.get(i3);
                this.zzcym.add(zzace);
                this.zzcyn.add(zzace);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzcyj;
        this.textColor = num2 != null ? num2.intValue() : zzcyk;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzcyo = i;
        this.zzcyp = i2;
        this.zzcyq = z;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getText() {
        return this.zzcyl;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final List<zzacs> zzrr() {
        return this.zzcyn;
    }

    public final List<zzace> zzrs() {
        return this.zzcym;
    }

    public final int zzrt() {
        return this.zzcyo;
    }

    public final int zzru() {
        return this.zzcyp;
    }
}
