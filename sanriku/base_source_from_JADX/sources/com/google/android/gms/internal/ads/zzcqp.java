package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzcqp<AdT> implements zzdqj<zzdha, AdT> {
    private final Executor executor;
    private final zzdld zzfgl;
    private final ScheduledExecutorService zzfif;
    private final zzdku zzflm;
    private final zzbra zzfoe;
    private final zzbnx<AdT> zzggv;
    private final zzcqi zzggw;

    public zzcqp(zzdku zzdku, zzcqi zzcqi, zzbra zzbra, zzdld zzdld, zzbnx<AdT> zzbnx, Executor executor2, ScheduledExecutorService scheduledExecutorService) {
        this.zzflm = zzdku;
        this.zzggw = zzcqi;
        this.zzfoe = zzbra;
        this.zzfgl = zzdld;
        this.zzggv = zzbnx;
        this.executor = executor2;
        this.zzfif = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdha zzdha, zzdgo zzdgo, zzcnj zzcnj, Throwable th) throws Exception {
        return this.zzggw.zza(zzdha.zzgus.zzgup, zzdgo, zzdqw.zza(zzcnj.zzb(zzdha, zzdgo), (long) zzdgo.zzgtz, TimeUnit.MILLISECONDS, this.zzfif));
    }

    public final /* synthetic */ zzdri zzf(Object obj) throws Exception {
        zzdha zzdha = (zzdha) obj;
        zzdkd<E, I> zzaud = this.zzflm.zzu(zzdkr.RENDER_CONFIG_INIT).zze(zzdqw.immediateFailedFuture(new zzcqm("No ad configs", 3))).zzaud();
        this.zzfoe.zza(new zzbkf(zzdha, this.zzfgl), this.executor);
        int i = 0;
        for (zzdgo next : zzdha.zzgus.zzguo) {
            Iterator<String> it = next.zzgtk.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next2 = it.next();
                    zzcnj<AdT> zze = this.zzggv.zze(next.zzgtl, next2);
                    if (zze != null && zze.zza(zzdha, next)) {
                        zzdkm<I> zza = this.zzflm.zza(zzdkr.RENDER_CONFIG_WATERFALL, zzaud);
                        StringBuilder sb = new StringBuilder(C0681a.m336b(next2, 26));
                        sb.append("render-config-");
                        sb.append(i);
                        sb.append("-");
                        sb.append(next2);
                        zzaud = zza.zzgv(sb.toString()).zza(Throwable.class, new zzcqo(this, zzdha, next, zze)).zzaud();
                        break;
                    }
                } else {
                    break;
                }
            }
            i++;
        }
        return zzaud;
    }
}
