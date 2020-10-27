package com.google.android.gms.internal.ads;

final class zzdlr extends zzdln {
    private String zzhbe;
    private Boolean zzhbf;
    private Boolean zzhbg;

    zzdlr() {
    }

    public final zzdlo zzaue() {
        String str = "";
        if (this.zzhbe == null) {
            str = str.concat(" clientVersion");
        }
        if (this.zzhbf == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhbg == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdlp(this.zzhbe, this.zzhbf.booleanValue(), this.zzhbg.booleanValue());
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    public final zzdln zzbq(boolean z) {
        this.zzhbf = Boolean.valueOf(z);
        return this;
    }

    public final zzdln zzbr(boolean z) {
        this.zzhbg = true;
        return this;
    }

    public final zzdln zzgy(String str) {
        if (str != null) {
            this.zzhbe = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }
}
