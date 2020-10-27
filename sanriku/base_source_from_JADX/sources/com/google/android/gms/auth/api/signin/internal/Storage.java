package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import p009e.p010a.p011a.p012a.C0681a;

public class Storage {
    private static final Lock zaai = new ReentrantLock();
    private static Storage zaaj;
    private final Lock zaak = new ReentrantLock();
    private final SharedPreferences zaal;

    @VisibleForTesting
    private Storage(Context context) {
        this.zaal = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        zaai.lock();
        try {
            if (zaaj == null) {
                zaaj = new Storage(context.getApplicationContext());
            }
            return zaaj;
        } finally {
            zaai.unlock();
        }
    }

    private final void zaa(String str, String str2) {
        this.zaak.lock();
        try {
            this.zaal.edit().putString(str, str2).apply();
        } finally {
            this.zaak.unlock();
        }
    }

    private static String zab(String str, String str2) {
        return C0681a.m313a(C0681a.m336b(str2, C0681a.m336b(str, 1)), str, ":", str2);
    }

    @VisibleForTesting
    private final GoogleSignInAccount zad(String str) {
        String zaf;
        if (!TextUtils.isEmpty(str) && (zaf = zaf(zab("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.zaa(zaf);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @VisibleForTesting
    private final GoogleSignInOptions zae(String str) {
        String zaf;
        if (!TextUtils.isEmpty(str) && (zaf = zaf(zab("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.zab(zaf);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String zaf(String str) {
        this.zaak.lock();
        try {
            return this.zaal.getString(str, (String) null);
        } finally {
            this.zaak.unlock();
        }
    }

    private final void zag(String str) {
        this.zaak.lock();
        try {
            this.zaal.edit().remove(str).apply();
        } finally {
            this.zaak.unlock();
        }
    }

    @KeepForSdk
    public void clear() {
        this.zaak.lock();
        try {
            this.zaal.edit().clear().apply();
        } finally {
            this.zaak.unlock();
        }
    }

    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        return zad(zaf("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        return zae(zaf("defaultGoogleSignInAccount"));
    }

    @KeepForSdk
    public String getSavedRefreshToken() {
        return zaf("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        zaa("defaultGoogleSignInAccount", googleSignInAccount.zab());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String zab = googleSignInAccount.zab();
        zaa(zab("googleSignInAccount", zab), googleSignInAccount.zac());
        zaa(zab("googleSignInOptions", zab), googleSignInOptions.zae());
    }

    public final void zaf() {
        String zaf = zaf("defaultGoogleSignInAccount");
        zag("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(zaf)) {
            zag(zab("googleSignInAccount", zaf));
            zag(zab("googleSignInOptions", zaf));
        }
    }
}
