package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;

class zzl {
    private static final zzl zzao = new zzl(true, (String) null, (Throwable) null);
    private final Throwable cause;
    final boolean zzap;
    private final String zzaq;

    zzl(boolean z, String str, Throwable th) {
        this.zzap = z;
        this.zzaq = str;
        this.cause = th;
    }

    static zzl zza(@NonNull String str, @NonNull Throwable th) {
        return new zzl(false, str, th);
    }

    static zzl zza(Callable<String> callable) {
        return new zzn(callable);
    }

    static zzl zzb(@NonNull String str) {
        return new zzl(false, str, (Throwable) null);
    }

    static String zzc(String str, zzd zzd, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zzj("SHA-1").digest(zzd.getBytes())), Boolean.valueOf(z), "12451009.false"});
    }

    static zzl zze() {
        return zzao;
    }

    /* access modifiers changed from: package-private */
    public String getErrorMessage() {
        return this.zzaq;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() {
        if (!this.zzap && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.cause != null) {
                Log.d("GoogleCertificatesRslt", getErrorMessage(), this.cause);
            } else {
                Log.d("GoogleCertificatesRslt", getErrorMessage());
            }
        }
    }
}
