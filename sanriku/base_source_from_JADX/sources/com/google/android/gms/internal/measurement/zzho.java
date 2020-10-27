package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzho {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzho zzc;
    private static volatile zzho zzd;
    private static final zzho zze = new zzho(true);
    private final Map<zza, zzib.zzd<?, ?>> zzf;

    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            return this.zza == zza2.zza && this.zzb == zza2.zzb;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }
    }

    zzho() {
        this.zzf = new HashMap();
    }

    private zzho(boolean z) {
        this.zzf = Collections.emptyMap();
    }

    public static zzho zza() {
        zzho zzho = zzc;
        if (zzho == null) {
            synchronized (zzho.class) {
                zzho = zzc;
                if (zzho == null) {
                    zzho = zze;
                    zzc = zzho;
                }
            }
        }
        return zzho;
    }

    public static zzho zzb() {
        Class<zzho> cls = zzho.class;
        zzho zzho = zzd;
        if (zzho != null) {
            return zzho;
        }
        synchronized (cls) {
            zzho zzho2 = zzd;
            if (zzho2 != null) {
                return zzho2;
            }
            zzho zza2 = zzia.zza(cls);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzjj> zzib.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzf.get(new zza(containingtype, i));
    }
}
