package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.internal.ShowFirstParty;

public final class CredentialsOptions extends Auth.AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = ((CredentialsOptions) new Builder().zzd());

    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        /* renamed from: build */
        public final CredentialsOptions zzd() {
            return new CredentialsOptions(this);
        }

        public final Builder forceEnableSaveDialog() {
            this.zzu = true;
            return this;
        }

        @ShowFirstParty
        public final /* synthetic */ Auth.AuthCredentialsOptions.Builder zzc(String str) {
            this.zzn = str;
            return this;
        }
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
