package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import p009e.p010a.p011a.p012a.C0681a;

public class zzazw {
    public static boolean isLoggable(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }

    public static void zzb(String str, Throwable th) {
        if (isLoggable(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void zze(String str, @Nullable Throwable th) {
        if (isLoggable(5)) {
            String zzfd = zzfd(str);
            if (th != null) {
                zzd(zzfd, th);
            } else {
                zzfc(zzfd);
            }
        }
    }

    public static void zzed(String str) {
        if (isLoggable(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zzfa(String str) {
        if (isLoggable(6)) {
            Log.e("Ads", str);
        }
    }

    public static void zzfb(String str) {
        if (isLoggable(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzfc(String str) {
        if (isLoggable(5)) {
            Log.w("Ads", str);
        }
    }

    @VisibleForTesting
    private static String zzfd(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(C0681a.m336b(str, 13));
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zzfe(String str) {
        zze(str, (Throwable) null);
    }
}
