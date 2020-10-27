package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbiv;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzbgy implements zzbjv {
    private static zzbgy zzeng;

    public static zzbgy zza(Context context, zzalp zzalp, int i) {
        zzbgy zzf = zzf(context, i);
        zzf.zzada().zzb(zzalp);
        return zzf;
    }

    @Deprecated
    private static zzbgy zza(zzazz zzazz, Context context, zzbiv.zza zza) {
        zzbgy zzbgy;
        synchronized (zzbgy.class) {
            if (zzeng == null) {
                zzeng = new zzbim().zzc(new zzbhb(new zzbhb.zza().zza(zzazz).zzbu(context))).zza(new zzbiv(zza)).zzafn();
                zzzz.initialize(context);
                zzq.zzla().zzd(context, zzazz);
                zzq.zzlc().initialize(context);
                zzq.zzkw().zzao(context);
                zzq.zzkw().zzap(context);
                zzawp.zzan(context);
                zzq.zzkz().initialize(context);
                zzq.zzlr().initialize(context);
                if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsz)).booleanValue()) {
                    new zzcnf(context, zzazz, new zzst(new zzsy(context)), new zzcmp(new zzcmn(context), zzeng.zzacy())).zzapc();
                }
            }
            zzbgy = zzeng;
        }
        return zzbgy;
    }

    @Deprecated
    public static zzbgy zzf(Context context, int i) {
        synchronized (zzbgy.class) {
            if (zzeng == null) {
                return zza(new zzazz(201004000, i, true, false), context, (zzbiv.zza) new zzbht());
            }
            zzbgy zzbgy = zzeng;
            return zzbgy;
        }
    }

    public final zzdbc zza(zzarj zzarj, int i) {
        return zza(new zzdcl(zzarj, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzdbc zza(zzdcl zzdcl);

    public abstract Executor zzacv();

    public abstract ScheduledExecutorService zzacw();

    public abstract Executor zzacx();

    public abstract zzdrh zzacy();

    public abstract zzbte zzacz();

    public abstract zzcfz zzada();

    public abstract zzbja zzadb();

    public abstract zzbms zzadc();

    public abstract zzblk zzadd();

    public abstract zzddo zzade();

    public abstract zzbxq zzadf();

    public abstract zzbyo zzadg();

    public abstract zzcer zzadh();

    public abstract zzdgf zzadi();

    public abstract zzcue zzadj();

    public abstract zzdhp<zzcdt> zzadk();
}
