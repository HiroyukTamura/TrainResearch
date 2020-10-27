package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzckg extends zzcke {
    /* access modifiers changed from: private */
    public static final Pattern zzgbh = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfky;
    private final zzdhe zzfll;
    private final zzdrh zzfur;
    private final zzcjn zzgbf;
    /* access modifiers changed from: private */
    public final zzcmv zzgbg;

    zzckg(zzbth zzbth, zzdhe zzdhe, zzcjn zzcjn, zzdrh zzdrh, ScheduledExecutorService scheduledExecutorService, zzcmv zzcmv) {
        super(zzbth);
        this.zzfll = zzdhe;
        this.zzgbf = zzcjn;
        this.zzfur = zzdrh;
        this.zzfky = scheduledExecutorService;
        this.zzgbg = zzcmv;
    }

    public final zzdri<zzdha> zzb(zzarj zzarj) throws zzcjk {
        zzdri<zzdha> zzb = zzdqw.zzb(this.zzgbf.zze(zzarj), new zzckj(this), (Executor) this.zzfur);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrq)).booleanValue()) {
            zzb = zzdqw.zzb(zzdqw.zza(zzb, (long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcrr)).intValue(), TimeUnit.SECONDS, this.zzfky), TimeoutException.class, zzcki.zzbly, zzbab.zzdzw);
        }
        zzdqw.zza(zzb, new zzckl(this), zzbab.zzdzw);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzd(InputStream inputStream) throws Exception {
        return zzdqw.zzag(new zzdha(new zzdgv(this.zzfll), zzdgy.zza(new InputStreamReader(inputStream))));
    }
}
