package com.google.android.gms.internal.measurement;

import android.os.Binder;

public final /* synthetic */ class zzcp {
    public static <V> V zza(zzco<V> zzco) {
        long clearCallingIdentity;
        try {
            return zzco.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = zzco.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
