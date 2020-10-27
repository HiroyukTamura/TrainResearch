package com.google.android.gms.internal.ads;

public class zzaaz<T> {
    private final String zzcc;
    private final T zzcif;
    private final int zzcvg;

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzaaz(java.lang.String r1, T r2, java.lang.Integer r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zzcc = r1
            r0.zzcif = r2
            r0.zzcvg = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaz.<init>(java.lang.String, java.lang.Object, int):void");
    }

    public static zzaaz<Double> zzb(String str, double d) {
        return new zzaaz<>(str, Double.valueOf(d), zzabb.zzcvj);
    }

    public static zzaaz<Long> zzb(String str, long j) {
        return new zzaaz<>(str, Long.valueOf(j), zzabb.zzcvi);
    }

    public static zzaaz<Boolean> zzf(String str, boolean z) {
        return new zzaaz<>(str, Boolean.valueOf(z), zzabb.zzcvh);
    }

    public static zzaaz<String> zzi(String str, String str2) {
        return new zzaaz<>(str, str2, zzabb.zzcvk);
    }

    public T get() {
        zzaby zzrq = zzacb.zzrq();
        if (zzrq != null) {
            int i = zzaay.zzcvf[this.zzcvg - 1];
            if (i == 1) {
                return zzrq.zze(this.zzcc, ((Boolean) this.zzcif).booleanValue());
            }
            if (i == 2) {
                return zzrq.getLong(this.zzcc, ((Long) this.zzcif).longValue());
            }
            if (i == 3) {
                return zzrq.zza(this.zzcc, ((Double) this.zzcif).doubleValue());
            }
            if (i == 4) {
                return zzrq.get(this.zzcc, (String) this.zzcif);
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException("Flag is not initialized.");
    }
}
