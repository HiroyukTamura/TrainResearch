package com.google.android.gms.internal.ads;

final class zzedj {
    private static final zzedh zziaa = zzbgd();
    private static final zzedh zziab = new zzedk();

    static zzedh zzbgb() {
        return zziaa;
    }

    static zzedh zzbgc() {
        return zziab;
    }

    private static zzedh zzbgd() {
        try {
            return (zzedh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
