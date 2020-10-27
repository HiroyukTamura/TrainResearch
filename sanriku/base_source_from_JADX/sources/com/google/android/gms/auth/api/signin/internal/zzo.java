package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzo {
    @Nullable
    private static zzo zzci;
    @VisibleForTesting
    private Storage zzcj;
    @Nullable
    @VisibleForTesting
    private GoogleSignInAccount zzck;
    @Nullable
    @VisibleForTesting
    private GoogleSignInOptions zzcl = this.zzcj.getSavedDefaultGoogleSignInOptions();

    private zzo(Context context) {
        Storage instance = Storage.getInstance(context);
        this.zzcj = instance;
        this.zzck = instance.getSavedDefaultGoogleSignInAccount();
    }

    public static synchronized zzo zzd(@NonNull Context context) {
        zzo zze;
        synchronized (zzo.class) {
            zze = zze(context.getApplicationContext());
        }
        return zze;
    }

    private static synchronized zzo zze(Context context) {
        synchronized (zzo.class) {
            if (zzci != null) {
                zzo zzo = zzci;
                return zzo;
            }
            zzo zzo2 = new zzo(context);
            zzci = zzo2;
            return zzo2;
        }
    }

    public final synchronized void clear() {
        this.zzcj.clear();
        this.zzck = null;
        this.zzcl = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzcj.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzck = googleSignInAccount;
        this.zzcl = googleSignInOptions;
    }

    @Nullable
    public final synchronized GoogleSignInAccount zzk() {
        return this.zzck;
    }

    @Nullable
    public final synchronized GoogleSignInOptions zzl() {
        return this.zzcl;
    }
}
