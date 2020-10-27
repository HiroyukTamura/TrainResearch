package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzng {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbem;
    public final String zzben;
    public final boolean zzbeo;
    public final boolean zzbep;
    public final int zzbeq;
    public final int zzber;
    public final int zzbes;
    public final boolean zzbet;
    public final boolean zzbeu;
    public final boolean zzbev;

    public zzng() {
        this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zzng(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbem = null;
        this.zzben = null;
        this.zzbeo = false;
        this.zzbep = true;
        this.zzbeq = Integer.MAX_VALUE;
        this.zzber = Integer.MAX_VALUE;
        this.zzbes = Integer.MAX_VALUE;
        this.zzbet = true;
        this.zzbeu = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbev = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzng.class == obj.getClass()) {
            zzng zzng = (zzng) obj;
            return this.zzbep == zzng.zzbep && this.zzbeq == zzng.zzbeq && this.zzber == zzng.zzber && this.zzbet == zzng.zzbet && this.zzbeu == zzng.zzbeu && this.zzbev == zzng.zzbev && this.viewportWidth == zzng.viewportWidth && this.viewportHeight == zzng.viewportHeight && this.zzbes == zzng.zzbes && TextUtils.equals((CharSequence) null, (CharSequence) null) && TextUtils.equals((CharSequence) null, (CharSequence) null);
        }
    }

    public final int hashCode() {
        throw null;
    }
}
