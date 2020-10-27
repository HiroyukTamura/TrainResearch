package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzazp implements zzazt {
    private final String zzdbv;
    private final Map zzdca;
    private final String zzdcd;
    private final byte[] zzdzg;

    zzazp(String str, String str2, Map map, byte[] bArr) {
        this.zzdcd = str;
        this.zzdbv = str2;
        this.zzdca = map;
        this.zzdzg = bArr;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzazq.zza(this.zzdcd, this.zzdbv, this.zzdca, this.zzdzg, jsonWriter);
    }
}
