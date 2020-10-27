package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbo;
import com.google.android.gms.internal.ads.zzbv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzdu extends zzdl {
    private zzdu(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    public static zzdu zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcm.zzmx);
    }

    public static zzdu zzb(String str, Context context, boolean z, int i) {
        zzdl.zza(context, z);
        zzdl.zza(str, context, z, i);
        return new zzdu(context, str, z, i);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzeo zzeo, Context context, zzbv.zza.C2654zza zza, zzbo.zza zza2) {
        if (zzeo.zzch() == null || !this.zzwb) {
            return super.zza(zzeo, context, zza, zza2);
        }
        int zzbv = zzeo.zzbv();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzeo, context, zza, zza2));
        arrayList.add(new zzfi(zzeo, "hYPTVQdTm2q1YMo1lUce4yXfJpjfBpohGFUC3CCt6OsJQwu7mUSAt5mBInaYKugO", "pf4sJGlvLCh5M9DSeQtdmDF5FY3IMGGhi6Z7oCoKXow=", zza, zzbv, 24));
        return arrayList;
    }
}
