package com.google.android.gms.internal.gtm;

public enum zzul {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzps.zzavx),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzbbx;

    private zzul(Object obj) {
        this.zzbbx = obj;
    }
}
