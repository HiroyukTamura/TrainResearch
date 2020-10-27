package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;

final class zzja implements zzkb {
    private static final zzjk zzb = new zziz();
    private final zzjk zza;

    public zzja() {
        this(new zzjc(zzhz.zza(), zza()));
    }

    private zzja(zzjk zzjk) {
        this.zza = (zzjk) zzie.zza(zzjk, "messageInfoFactory");
    }

    private static zzjk zza() {
        try {
            return (zzjk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }

    private static boolean zza(zzjh zzjh) {
        return zzjh.zza() == zzib.zzf.zzh;
    }

    public final <T> zzkc<T> zza(Class<T> cls) {
        Class<zzib> cls2 = zzib.class;
        zzke.zza((Class<?>) cls);
        zzjh zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            return cls2.isAssignableFrom(cls) ? zzjp.zza(zzke.zzc(), zzhs.zza(), zzb2.zzc()) : zzjp.zza(zzke.zza(), zzhs.zzb(), zzb2.zzc());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean zza2 = zza(zzb2);
            zzjr zzb3 = zzjt.zzb();
            zzit zzb4 = zzit.zzb();
            zzku<?, ?> zzc = zzke.zzc();
            if (zza2) {
                return zzjn.zza(cls, zzb2, zzb3, zzb4, zzc, zzhs.zza(), zzji.zzb());
            }
            return zzjn.zza(cls, zzb2, zzb3, zzb4, zzc, (zzhq<?>) null, zzji.zzb());
        }
        boolean zza3 = zza(zzb2);
        zzjr zza4 = zzjt.zza();
        zzit zza5 = zzit.zza();
        if (zza3) {
            return zzjn.zza(cls, zzb2, zza4, zza5, zzke.zza(), zzhs.zzb(), zzji.zza());
        }
        return zzjn.zza(cls, zzb2, zza4, zza5, zzke.zzb(), (zzhq<?>) null, zzji.zza());
    }
}
