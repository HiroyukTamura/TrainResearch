package com.google.android.gms.ads.rewarded;

public class ServerSideVerificationOptions {
    private final String zzdrf;
    private final String zzdrg;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String zzdrf = "";
        /* access modifiers changed from: private */
        public String zzdrg = "";

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public final Builder setCustomData(String str) {
            this.zzdrg = str;
            return this;
        }

        public final Builder setUserId(String str) {
            this.zzdrf = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.zzdrf = builder.zzdrf;
        this.zzdrg = builder.zzdrg;
    }

    public String getCustomData() {
        return this.zzdrg;
    }

    public String getUserId() {
        return this.zzdrf;
    }
}
