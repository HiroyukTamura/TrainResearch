package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzqp {
    private static volatile boolean zzaxh = false;
    private static final Class<?> zzaxi = zzop();
    private static volatile zzqp zzaxj;
    static final zzqp zzaxk = new zzqp(true);
    private final Map<zza, zzrc.zzd<?, ?>> zzaxl;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return this.object == zza.object && this.number == zza.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzqp() {
        this.zzaxl = new HashMap();
    }

    private zzqp(boolean z) {
        this.zzaxl = Collections.emptyMap();
    }

    static zzqp zzoo() {
        return zzra.zzd(zzqp.class);
    }

    private static Class<?> zzop() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzqp zzoq() {
        return zzqo.zzon();
    }

    public static zzqp zzor() {
        zzqp zzqp = zzaxj;
        if (zzqp == null) {
            synchronized (zzqp.class) {
                zzqp = zzaxj;
                if (zzqp == null) {
                    zzqp = zzqo.zzoo();
                    zzaxj = zzqp;
                }
            }
        }
        return zzqp;
    }

    public final <ContainingType extends zzsk> zzrc.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzaxl.get(new zza(containingtype, i));
    }
}
