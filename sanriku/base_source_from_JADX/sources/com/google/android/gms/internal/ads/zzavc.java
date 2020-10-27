package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final /* synthetic */ class zzavc implements zzavk {
    private final Context zzcit;
    private final String zzdbv;

    zzavc(Context context, String str) {
        this.zzcit = context;
        this.zzdbv = str;
    }

    public final void zza(zzbgr zzbgr) {
        Context context = this.zzcit;
        zzbgr.zzb(ObjectWrapper.wrap(context), this.zzdbv, context.getPackageName());
    }
}
