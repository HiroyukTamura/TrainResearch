package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdmf;
import com.google.android.gms.internal.ads.zzdmm;

@ShowFirstParty
public final class zzdly {
    private final Looper zzhbp;
    private final Context zzvf;

    public zzdly(@NonNull Context context, @NonNull Looper looper) {
        this.zzvf = context;
        this.zzhbp = looper;
    }

    public final void zzgz(@NonNull String str) {
        new zzdlx(this.zzvf, this.zzhbp, (zzdmm) ((zzecd) zzdmm.zzaus().zzhc(this.zzvf.getPackageName()).zzb(zzdmm.zza.BLOCKED_IMPRESSION).zza(zzdmf.zzauq().zzhb(str).zzb(zzdmf.zza.BLOCKED_REASON_BACKGROUND)).zzbet())).zzaul();
    }
}
