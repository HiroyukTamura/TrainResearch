package com.google.android.gms.internal.measurement;

public enum zzlh {
    DOUBLE(zzlo.DOUBLE, 1),
    FLOAT(zzlo.FLOAT, 5),
    INT64(zzlo.LONG, 0),
    UINT64(zzlo.LONG, 0),
    INT32(zzlo.INT, 0),
    FIXED64(zzlo.LONG, 1),
    FIXED32(zzlo.INT, 5),
    BOOL(zzlo.BOOLEAN, 0),
    STRING(zzlo.STRING, 2),
    GROUP(zzlo.MESSAGE, 3),
    MESSAGE(zzlo.MESSAGE, 2),
    BYTES(zzlo.BYTE_STRING, 2),
    UINT32(zzlo.INT, 0),
    ENUM(zzlo.ENUM, 0),
    SFIXED32(zzlo.INT, 5),
    SFIXED64(zzlo.LONG, 1),
    SINT32(zzlo.INT, 0),
    SINT64(zzlo.LONG, 0);
    
    private final zzlo zzs;
    private final int zzt;

    private zzlh(zzlo zzlo, int i) {
        this.zzs = zzlo;
        this.zzt = i;
    }

    public final zzlo zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
