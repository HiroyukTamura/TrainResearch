package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

public final class zzdcw implements zzegz<zzdaj<JSONObject>> {
    public static zzdaj<JSONObject> zza(zzavv zzavv, Object obj, zzdbe zzdbe, zzdcb zzdcb, zzegt<zzday> zzegt, zzegt<zzdbi> zzegt2, zzegt<zzdbm> zzegt3, zzegt<zzdbs> zzegt4, zzegt<zzdbx> zzegt5, zzegt<zzdcg> zzegt6, zzegt<zzdck> zzegt7, zzegt<zzdcy> zzegt8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdbt) obj);
        hashSet.add(zzdbe);
        hashSet.add(zzdcb);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsa)).booleanValue()) {
            hashSet.add(zzegt.get());
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsb)).booleanValue()) {
            hashSet.add(zzegt2.get());
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsc)).booleanValue()) {
            hashSet.add(zzegt3.get());
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsd)).booleanValue()) {
            hashSet.add(zzegt4.get());
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsh)).booleanValue()) {
            hashSet.add(new zzcyv(zzegt6.get(), ((Long) zzvj.zzpv().zzd(zzzz.zzcpg)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsj)).booleanValue()) {
            hashSet.add(zzegt7.get());
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcsk)).booleanValue()) {
            hashSet.add(zzegt8.get());
        }
        return (zzdaj) zzehf.zza(new zzdaj(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
