package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.ads.zzbv;

@ShowFirstParty
public final class zzdlu {
    public static zzbv.zza zzj(Context context, String str, String str2) {
        return new zzdlt(context, str, str2).zzdx(FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
    }
}
