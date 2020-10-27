package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class zzaae {
    public static void zza(zzaac zzaac, @Nullable zzaad zzaad) {
        if (zzaad.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzaad.zzkr())) {
            zzaac.zza(zzaad.getContext(), zzaad.zzkr(), zzaad.zzrh(), zzaad.zzri());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
