package com.google.android.gms.internal.ads;

public enum zzecq {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeaq.class, zzeaq.class, zzeaq.zzhtf),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzhzc;
    private final Class<?> zzhzd;
    private final Object zzhze;

    private zzecq(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzhzc = cls;
        this.zzhzd = cls2;
        this.zzhze = obj;
    }

    public final Class<?> zzbfq() {
        return this.zzhzd;
    }
}
