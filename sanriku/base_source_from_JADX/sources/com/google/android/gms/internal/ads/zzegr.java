package com.google.android.gms.internal.ads;

public abstract class zzegr {
    public static zzegr zzn(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzego(cls.getSimpleName()) : new zzegq(cls.getSimpleName());
    }

    public abstract void zzig(String str);
}
