package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbsf;
import java.util.Iterator;

public final class zzcru<AdT, AdapterT, ListenerT extends zzbsf> implements zzcnj<AdT> {
    private final zzcnk<AdapterT, ListenerT> zzffp;
    private final zzdku zzflm;
    private final zzcnm<AdT, AdapterT, ListenerT> zzghq;
    private final zzdrh zzghr;

    public zzcru(zzdku zzdku, zzdrh zzdrh, zzcnk<AdapterT, ListenerT> zzcnk, zzcnm<AdT, AdapterT, ListenerT> zzcnm) {
        this.zzflm = zzdku;
        this.zzghr = zzdrh;
        this.zzghq = zzcnm;
        this.zzffp = zzcnk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl, Void voidR) throws Exception {
        return this.zzghq.zzb(zzdha, zzdgo, zzcnl);
    }

    public final boolean zza(zzdha zzdha, zzdgo zzdgo) {
        return !zzdgo.zzgts.isEmpty();
    }

    public final zzdri<AdT> zzb(zzdha zzdha, zzdgo zzdgo) {
        zzcnl<AdapterT, ListenerT> zzcnl;
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        Iterator<String> it = zzdgo.zzgts.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcnl = null;
                break;
            }
            try {
                zzcnl = this.zzffp.zzf(it.next(), zzdgo.zzgtu);
                break;
            } catch (zzdhk unused) {
            }
        }
        if (zzcnl == null) {
            return zzdqw.immediateFailedFuture(new zzcpy("unable to instantiate mediation adapter class"));
        }
        zzbaj zzbaj = new zzbaj();
        zzcnl.zzgel.zza(new zzcrz(this, zzbaj));
        if (zzdgo.zzdpp) {
            Bundle bundle = zzdha.zzgur.zzfll.zzguw.zzcen;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzflm.zzu(zzdkr.ADAPTER_LOAD_AD_SYN).zza((zzdke) new zzcrx(this, zzdha, zzdgo, zzcnl), this.zzghr).zzw(zzdkr.ADAPTER_LOAD_AD_ACK).zze(zzbaj).zzw(zzdkr.ADAPTER_WRAP_ADAPTER).zzb(new zzcrw(this, zzdha, zzdgo, zzcnl)).zzaud();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdha zzdha, zzdgo zzdgo, zzcnl zzcnl) throws Exception {
        this.zzghq.zza(zzdha, zzdgo, zzcnl);
    }
}
