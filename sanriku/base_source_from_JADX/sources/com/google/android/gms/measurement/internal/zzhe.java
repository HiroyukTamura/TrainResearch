package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzae;

@VisibleForTesting
public final class zzhe {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzae zzg;
    boolean zzh = true;
    Long zzi;

    @VisibleForTesting
    public zzhe(Context context, zzae zzae, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzae != null) {
            this.zzg = zzae;
            this.zzb = zzae.zzf;
            this.zzc = zzae.zze;
            this.zzd = zzae.zzd;
            this.zzh = zzae.zzc;
            this.zzf = zzae.zzb;
            Bundle bundle = zzae.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
