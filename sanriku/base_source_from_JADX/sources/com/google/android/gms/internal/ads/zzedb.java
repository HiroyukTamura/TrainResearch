package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

final class zzedb implements zzeej {
    private static final zzedl zzhzs = new zzede();
    private final zzedl zzhzr;

    public zzedb() {
        this(new zzedd(zzecb.zzben(), zzbfw()));
    }

    private zzedb(zzedl zzedl) {
        this.zzhzr = (zzedl) zzecg.zza(zzedl, "messageInfoFactory");
    }

    private static boolean zza(zzedm zzedm) {
        return zzedm.zzbge() == zzecd.zzf.zzhyj;
    }

    private static zzedl zzbfw() {
        try {
            return (zzedl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzhzs;
        }
    }

    public final <T> zzeek<T> zzg(Class<T> cls) {
        Class<zzecd> cls2 = zzecd.class;
        zzeem.zzi(cls);
        zzedm zzd = this.zzhzr.zzd(cls);
        if (zzd.zzbgf()) {
            return cls2.isAssignableFrom(cls) ? zzedu.zza(zzeem.zzbgx(), zzebu.zzbeh(), zzd.zzbgg()) : zzedu.zza(zzeem.zzbgv(), zzebu.zzbei(), zzd.zzbgg());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean zza = zza(zzd);
            zzedw zzbgi = zzedy.zzbgi();
            zzecy zzbfv = zzecy.zzbfv();
            zzefc<?, ?> zzbgx = zzeem.zzbgx();
            if (zza) {
                return zzeds.zza(cls, zzd, zzbgi, zzbfv, zzbgx, zzebu.zzbeh(), zzedj.zzbgc());
            }
            return zzeds.zza(cls, zzd, zzbgi, zzbfv, zzbgx, (zzebs<?>) null, zzedj.zzbgc());
        }
        boolean zza2 = zza(zzd);
        zzedw zzbgh = zzedy.zzbgh();
        zzecy zzbfu = zzecy.zzbfu();
        if (zza2) {
            return zzeds.zza(cls, zzd, zzbgh, zzbfu, zzeem.zzbgv(), zzebu.zzbei(), zzedj.zzbgb());
        }
        return zzeds.zza(cls, zzd, zzbgh, zzbfu, zzeem.zzbgw(), (zzebs<?>) null, zzedj.zzbgb());
    }
}
