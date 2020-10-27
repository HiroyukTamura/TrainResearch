package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcom implements zzcnj<zzblx> {
    private final ScheduledExecutorService zzfky;
    /* access modifiers changed from: private */
    public final zzbra zzfoe;
    private final zzdrh zzfur;
    private final zzbmt zzgfe;
    private final zzcns zzgff;

    public zzcom(zzbmt zzbmt, zzcns zzcns, zzbra zzbra, ScheduledExecutorService scheduledExecutorService, zzdrh zzdrh) {
        this.zzgfe = zzbmt;
        this.zzgff = zzcns;
        this.zzfoe = zzbra;
        this.zzfky = scheduledExecutorService;
        this.zzfur = zzdrh;
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        return zzdha.zzgur.zzfll.zzarx() != null && this.zzgff.zza(zzdha, zzdgo);
    }

    public final zzdri<zzblx> zzb(zzdha zzdha, zzdgo zzdgo) {
        return this.zzfur.zzd(new zzcop(this, zzdha, zzdgo));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzblx zzc(zzdha zzdha, zzdgo zzdgo) throws Exception {
        return this.zzgfe.zza(new zzboi(zzdha, zzdgo, (String) null), new zzbnh(zzdha.zzgur.zzfll.zzarx(), new zzcoo(this, zzdha, zzdgo))).zzafh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdha zzdha, zzdgo zzdgo) {
        zzdqw.zza(zzdqw.zza(this.zzgff.zzb(zzdha, zzdgo), (long) zzdgo.zzgtz, TimeUnit.SECONDS, this.zzfky), new zzcor(this), this.zzfur);
    }
}
