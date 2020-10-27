package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

public enum zzcd implements zzecf {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzeci<zzcd> zzeh = null;
    private final int value;

    static {
        zzeh = new zzcg();
    }

    private zzcd(int i) {
        this.value = i;
    }

    public static zzcd zzk(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzech zzx() {
        return zzcf.zzej;
    }

    public final String toString() {
        return "<" + zzcd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    public final int zzw() {
        return this.value;
    }
}
