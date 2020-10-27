package com.google.android.gms.internal.ads;

public enum zzefp {
    DOUBLE(zzefw.DOUBLE, 1),
    FLOAT(zzefw.FLOAT, 5),
    INT64(zzefw.LONG, 0),
    UINT64(zzefw.LONG, 0),
    INT32(zzefw.INT, 0),
    FIXED64(zzefw.LONG, 1),
    FIXED32(zzefw.INT, 5),
    BOOL(zzefw.BOOLEAN, 0),
    STRING(zzefw.STRING, 2),
    GROUP(zzefw.MESSAGE, 3),
    MESSAGE(zzefw.MESSAGE, 2),
    BYTES(zzefw.BYTE_STRING, 2),
    UINT32(zzefw.INT, 0),
    ENUM(zzefw.ENUM, 0),
    SFIXED32(zzefw.INT, 5),
    SFIXED64(zzefw.LONG, 1),
    SINT32(zzefw.INT, 0),
    SINT64(zzefw.LONG, 0);
    
    private final zzefw zzied;
    private final int zziee;

    private zzefp(zzefw zzefw, int i) {
        this.zzied = zzefw;
        this.zziee = i;
    }

    public final zzefw zzbhn() {
        return this.zzied;
    }

    public final int zzbho() {
        return this.zziee;
    }
}
