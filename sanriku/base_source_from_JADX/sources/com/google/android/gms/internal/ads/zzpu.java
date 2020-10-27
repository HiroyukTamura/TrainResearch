package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzpu {
    private final String zzbna;
    private final JSONObject zzbnb;
    private final String zzbnc;
    private final String zzbnd;
    private final boolean zzbne = false;
    private final boolean zzbnf;

    public zzpu(String str, zzazz zzazz, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbnd = zzazz.zzbnd;
        this.zzbnb = jSONObject;
        this.zzbnc = str;
        this.zzbna = str2;
        this.zzbnf = z2;
    }

    public final boolean isNative() {
        return this.zzbnf;
    }

    public final String zzkq() {
        return this.zzbna;
    }

    public final String zzkr() {
        return this.zzbnd;
    }

    public final JSONObject zzks() {
        return this.zzbnb;
    }

    public final String zzkt() {
        return this.zzbnc;
    }
}
