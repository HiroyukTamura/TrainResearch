package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

final class zzrz implements zzta {
    private static final zzsj zzbcn = new zzsa();
    private final zzsj zzbcm;

    public zzrz() {
        this(new zzsb(zzrb.zzpc(), zzqe()));
    }

    private zzrz(zzsj zzsj) {
        this.zzbcm = (zzsj) zzre.zza(zzsj, "messageInfoFactory");
    }

    private static boolean zza(zzsi zzsi) {
        return zzsi.zzql() == zzrc.zze.zzbaz;
    }

    private static zzsj zzqe() {
        try {
            return (zzsj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzbcn;
        }
    }

    public final <T> zzsz<T> zzh(Class<T> cls) {
        Class<zzrc> cls2 = zzrc.class;
        zztb.zzj(cls);
        zzsi zzf = this.zzbcm.zzf(cls);
        if (zzf.zzqm()) {
            return cls2.isAssignableFrom(cls) ? zzsp.zza(zztb.zzqx(), zzqs.zzot(), zzf.zzqn()) : zzsp.zza(zztb.zzqv(), zzqs.zzou(), zzf.zzqn());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean zza = zza(zzf);
            zzsr zzqq = zzst.zzqq();
            zzru zzqd = zzru.zzqd();
            zztr<?, ?> zzqx = zztb.zzqx();
            if (zza) {
                return zzso.zza(cls, zzf, zzqq, zzqd, zzqx, zzqs.zzot(), zzsh.zzqj());
            }
            return zzso.zza(cls, zzf, zzqq, zzqd, zzqx, (zzqq<?>) null, zzsh.zzqj());
        }
        boolean zza2 = zza(zzf);
        zzsr zzqp = zzst.zzqp();
        zzru zzqc = zzru.zzqc();
        if (zza2) {
            return zzso.zza(cls, zzf, zzqp, zzqc, zztb.zzqv(), zzqs.zzou(), zzsh.zzqi());
        }
        return zzso.zza(cls, zzf, zzqp, zzqc, zztb.zzqw(), (zzqq<?>) null, zzsh.zzqi());
    }
}
