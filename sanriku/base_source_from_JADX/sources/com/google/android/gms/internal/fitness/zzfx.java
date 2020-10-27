package com.google.android.gms.internal.fitness;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfx {
    private static volatile boolean zzrz = false;
    private static boolean zzsa = true;
    private static final Class<?> zzsb = zzaz();
    private static volatile zzfx zzsc;
    private static final zzfx zzsd = new zzfx(true);
    private final Map<Object, Object> zzse;

    zzfx() {
        this.zzse = new HashMap();
    }

    private zzfx(boolean z) {
        this.zzse = Collections.emptyMap();
    }

    private static Class<?> zzaz() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzfx zzba() {
        zzfx zzfx = zzsc;
        if (zzfx == null) {
            synchronized (zzfx.class) {
                zzfx = zzsc;
                if (zzfx == null) {
                    zzfx = zzsd;
                    zzsc = zzfx;
                }
            }
        }
        return zzfx;
    }
}
