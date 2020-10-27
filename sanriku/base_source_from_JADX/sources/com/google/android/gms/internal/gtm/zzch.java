package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.util.VisibleForTesting;
import p009e.p010a.p011a.p012a.C0681a;

@Deprecated
@VisibleForTesting
public final class zzch {
    private static volatile Logger zzabk = new zzbr();

    @VisibleForTesting
    public static Logger getLogger() {
        return zzabk;
    }

    private static boolean isLoggable(int i) {
        return zzabk != null && zzabk.getLogLevel() <= i;
    }

    @VisibleForTesting
    public static void setLogger(Logger logger) {
        zzabk = logger;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzab(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzq(str);
        } else if (isLoggable(0)) {
            Log.v(zzby.zzzb.get(), str);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzac(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzt(str);
        } else if (isLoggable(2)) {
            Log.w(zzby.zzzb.get(), str);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.warn(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzf(String str, Object obj) {
        String str2;
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zze(str, obj);
        } else if (isLoggable(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                str2 = C0681a.m313a(valueOf.length() + C0681a.m336b(str, 1), str, ":", valueOf);
            } else {
                str2 = str;
            }
            Log.e(zzby.zzzb.get(), str2);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.error(str);
        }
    }
}
