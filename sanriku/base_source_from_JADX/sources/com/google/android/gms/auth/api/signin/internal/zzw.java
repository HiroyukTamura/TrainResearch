package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.UidVerifier;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzw extends zzq {
    private final Context mContext;

    public zzw(Context context) {
        this.mContext = context;
    }

    private final void zzp() {
        if (!UidVerifier.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid())) {
            throw new SecurityException(C0681a.m310a(52, "Calling UID ", Binder.getCallingUid(), " is not Google Play services."));
        }
    }

    public final void zzm() {
        zzp();
        Storage instance = Storage.getInstance(this.mContext);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        GoogleSignInClient client = GoogleSignIn.getClient(this.mContext, googleSignInOptions);
        if (savedDefaultGoogleSignInAccount != null) {
            client.revokeAccess();
        } else {
            client.signOut();
        }
    }

    public final void zzn() {
        zzp();
        zzo.zzd(this.mContext).clear();
    }
}
