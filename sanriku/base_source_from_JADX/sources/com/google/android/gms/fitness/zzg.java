package com.google.android.gms.fitness;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;

@ShowFirstParty
public final class zzg implements Api.ApiOptions.HasGoogleSignInAccountOptions {
    private final GoogleSignInAccount zzhv;

    public zzg(Context context, GoogleSignInAccount googleSignInAccount) {
        if ("<<default account>>".equals(googleSignInAccount.getEmail())) {
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                this.zzhv = null;
                return;
            }
        }
        this.zzhv = googleSignInAccount;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof zzg) && Objects.equal(((zzg) obj).zzhv, this.zzhv);
        }
        return true;
    }

    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzhv;
    }

    public final int hashCode() {
        GoogleSignInAccount googleSignInAccount = this.zzhv;
        if (googleSignInAccount != null) {
            return googleSignInAccount.hashCode();
        }
        return 0;
    }
}
