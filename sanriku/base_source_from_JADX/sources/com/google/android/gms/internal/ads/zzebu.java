package com.google.android.gms.internal.ads;

final class zzebu {
    private static final zzebs<?> zzhux = new zzebr();
    private static final zzebs<?> zzhuy = zzbeg();

    private static zzebs<?> zzbeg() {
        try {
            return (zzebs) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzebs<?> zzbeh() {
        return zzhux;
    }

    static zzebs<?> zzbei() {
        zzebs<?> zzebs = zzhuy;
        if (zzebs != null) {
            return zzebs;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
