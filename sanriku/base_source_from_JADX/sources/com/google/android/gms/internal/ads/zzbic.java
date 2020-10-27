package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

final class zzbic extends zzdbc {
    private zzehm<String> zzeqh;
    private zzehm<zzchl> zzeqx;
    private zzehm<Map<zzdkr, zzchl>> zzeqz;
    private zzehm<Set<zzbvt<zzdla>>> zzerb;
    private zzehm<Set<zzbvt<zzdla>>> zzeri;
    private zzehm zzerj;
    private zzehm<zzdku> zzerk;
    private zzehm<ApplicationInfo> zzeru;
    private zzehm<zzdcg> zzesz;
    private final /* synthetic */ zzbhw zzewb;
    private final zzdcl zzezu;
    private zzehm<zzday> zzezv;
    private zzehm<String> zzezw;
    private zzehm<zzdbi> zzezx;
    private zzehm<Integer> zzezy;
    private zzehm<zzdbm> zzezz;
    private zzehm<zzdbs> zzfaa;
    private zzehm<zzdbx> zzfab;
    private zzehm<Boolean> zzfac;
    private zzehm<zzdck> zzfad;
    private zzehm<zzdcy> zzfae;
    private zzehm<zzchl> zzfaf;
    private zzehm<zzchl> zzfag;
    private zzehm<zzchl> zzfah;

    private zzbic(zzbhw zzbhw, zzdcl zzdcl) {
        this.zzewb = zzbhw;
        this.zzezu = zzdcl;
        this.zzezv = new zzdaz(zzbjt.zzfgf, this.zzewb.zzeoa, this.zzewb.zzenv, zzdjt.zzatr());
        this.zzezw = new zzdco(zzdcl);
        this.zzezx = new zzdbk(zzbhn.zzenn, this.zzewb.zzeoa, this.zzezw, zzdjt.zzatr());
        this.zzezy = new zzdcp(zzdcl);
        this.zzezz = new zzdbq(zzbjt.zzfgf, this.zzezy, this.zzewb.zzeoa, this.zzewb.zzeot, this.zzewb.zzenv, zzdjt.zzatr());
        this.zzfaa = new zzdbu(zzbjn.zzfgb, zzdjt.zzatr(), this.zzewb.zzeoa);
        this.zzfab = new zzdbz(zzbjp.zzfgc, zzdjt.zzatr(), this.zzezw);
        this.zzfac = new zzdcq(zzdcl);
        this.zzeru = new zzdcn(zzdcl);
        this.zzesz = new zzdci(this.zzewb.zzeov, this.zzewb.zzenv, this.zzfac, this.zzeru);
        this.zzfad = new zzdcm(zzbjr.zzfgd, this.zzewb.zzenv, this.zzewb.zzeoa);
        this.zzfae = new zzdda(zzdjt.zzatr());
        this.zzeqh = new zzdcs(zzdcl);
        this.zzeqx = zzeha.zzar(zzcha.zzann());
        this.zzfaf = zzeha.zzar(zzcgy.zzanm());
        this.zzfag = zzeha.zzar(zzchc.zzanp());
        this.zzfah = zzeha.zzar(zzche.zzanr());
        this.zzeqz = ((zzehd) ((zzehd) ((zzehd) ((zzehd) zzehb.zzhw(4).zza(zzdkr.GMS_SIGNALS, this.zzeqx)).zza(zzdkr.BUILD_URL, this.zzfaf)).zza(zzdkr.HTTP, this.zzfag)).zza(zzdkr.PRE_PROCESS, this.zzfah)).zzbis();
        this.zzerb = zzeha.zzar(new zzchg(this.zzeqh, this.zzewb.zzeoa, zzdjt.zzatr(), this.zzeqz));
        zzehi<Set<zzbvt<zzdla>>> zzbit = zzehi.zzar(0, 1).zzau(this.zzerb).zzbit();
        this.zzeri = zzbit;
        this.zzerj = zzdlc.zzaq(zzbit);
        this.zzerk = zzeha.zzar(zzdkz.zzv(zzdjt.zzatr(), this.zzewb.zzenv, this.zzerj));
    }

    private final zzdcb zzaet() {
        return new zzdcb((zzzi) zzehf.zza(new zzzi(), "Cannot return null from a non-@Nullable @Provides method"), zzdjt.zzats(), (List) zzehf.zza(this.zzezu.zzaqz(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzdbe zzaeu() {
        return new zzdbe(zzbjq.zzagi(), zzdjt.zzats(), (String) zzehf.zza(this.zzezu.zzaqw(), "Cannot return null from a non-@Nullable @Provides method"), this.zzezu.zzaqx());
    }

    public final zzdaj<JSONObject> zzaev() {
        zzdrh zzats = zzdjt.zzats();
        long longValue = ((Long) zzvj.zzpv().zzd(zzzz.zzcpg)).longValue();
        long longValue2 = ((Long) zzvj.zzpv().zzd(zzzz.zzcpo)).longValue();
        return zzdao.zza(zzats, zzdpb.zza((zzdak) zzehf.zza(new zzcyv(new zzdbx(zzbjm.zzage(), zzdjt.zzats(), zzdco.zzc(this.zzezu)), 0, (ScheduledExecutorService) this.zzewb.zzenv.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdak) zzehf.zza(new zzcyv(new zzdcg(zzbiz.zzb(this.zzewb.zzenr), (ScheduledExecutorService) this.zzewb.zzenv.get(), this.zzezu.zzaqy(), zzdcn.zzb(this.zzezu)), longValue, (ScheduledExecutorService) this.zzewb.zzenv.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdak) zzehf.zza(new zzcyv(new zzdck(zzbjo.zzagg(), (ScheduledExecutorService) this.zzewb.zzenv.get(), zzbhe.zza(this.zzewb.zzens)), longValue2, (ScheduledExecutorService) this.zzewb.zzenv.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdak) zzehf.zza(new zzcyv(new zzday(zzbjq.zzagi(), zzbhe.zza(this.zzewb.zzens), (ScheduledExecutorService) this.zzewb.zzenv.get(), zzdjt.zzats()), 0, (ScheduledExecutorService) this.zzewb.zzenv.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdak) zzehf.zza(new zzcyv(new zzdcy(zzdjt.zzats()), 0, (ScheduledExecutorService) this.zzewb.zzenv.get()), "Cannot return null from a non-@Nullable @Provides method"), (zzdak) zzehf.zza(zzdcr.zzard(), "Cannot return null from a non-@Nullable @Provides method"), new zzdbi((zzarq) null, zzbhe.zza(this.zzewb.zzens), zzdco.zzc(this.zzezu), zzdjt.zzats()), new zzdbs(zzbjk.zzagc(), zzdjt.zzats(), zzbhe.zza(this.zzewb.zzens)), zzaet(), zzaeu(), new zzdbm(zzbjq.zzagi(), this.zzezu.zzarc(), zzbhe.zza(this.zzewb.zzens), (zzawd) this.zzewb.zzeot.get(), (ScheduledExecutorService) this.zzewb.zzenv.get(), zzdjt.zzats()), (zzdak) this.zzewb.zzeou.get()));
    }

    public final zzdaj<JSONObject> zzaew() {
        return zzdcw.zza(zzbjm.zzage(), this.zzewb.zzeou.get(), zzaeu(), zzaet(), zzeha.zzas(this.zzezv), zzeha.zzas(this.zzezx), zzeha.zzas(this.zzezz), zzeha.zzas(this.zzfaa), zzeha.zzas(this.zzfab), zzeha.zzas(this.zzesz), zzeha.zzas(this.zzfad), zzeha.zzas(this.zzfae), zzdjt.zzats(), (ScheduledExecutorService) this.zzewb.zzenv.get());
    }

    public final zzdku zzaex() {
        return this.zzerk.get();
    }
}
