package com.google.android.gms.internal.fitness;

import com.google.android.gms.internal.fitness.zzgg;

final class zzhb implements zzib {
    private static final zzhl zzxd = new zzhe();
    private final zzhl zzxc;

    public zzhb() {
        this(new zzhd(zzgh.zzbn(), zzcb()));
    }

    private zzhb(zzhl zzhl) {
        this.zzxc = (zzhl) zzgk.zza(zzhl, "messageInfoFactory");
    }

    private static boolean zza(zzhm zzhm) {
        return zzhm.zzch() == zzgg.zze.zzvt;
    }

    private static zzhl zzcb() {
        try {
            return (zzhl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzxd;
        }
    }

    public final <T> zzic<T> zzd(Class<T> cls) {
        Class<zzgg> cls2 = zzgg.class;
        zzie.zzf((Class<?>) cls);
        zzhm zzc = this.zzxc.zzc(cls);
        if (zzc.zzci()) {
            return cls2.isAssignableFrom(cls) ? zzhr.zza(zzie.zzcx(), zzfy.zzbc(), zzc.zzcj()) : zzhr.zza(zzie.zzcv(), zzfy.zzbd(), zzc.zzcj());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean zza = zza(zzc);
            zzht zzcl = zzhv.zzcl();
            zzgy zzca = zzgy.zzca();
            zziu<?, ?> zzcx = zzie.zzcx();
            if (zza) {
                return zzhs.zza(cls, zzc, zzcl, zzca, zzcx, zzfy.zzbc(), zzhj.zzcf());
            }
            return zzhs.zza(cls, zzc, zzcl, zzca, zzcx, (zzfw<?>) null, zzhj.zzcf());
        }
        boolean zza2 = zza(zzc);
        zzht zzck = zzhv.zzck();
        zzgy zzbz = zzgy.zzbz();
        if (zza2) {
            return zzhs.zza(cls, zzc, zzck, zzbz, zzie.zzcv(), zzfy.zzbd(), zzhj.zzce());
        }
        return zzhs.zza(cls, zzc, zzck, zzbz, zzie.zzcw(), (zzfw<?>) null, zzhj.zzce());
    }
}
