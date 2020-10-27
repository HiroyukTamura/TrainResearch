package com.google.android.gms.internal.fitness;

public enum zzjl {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzff.zzri),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzwp;

    private zzjl(Object obj) {
        this.zzwp = obj;
    }
}
