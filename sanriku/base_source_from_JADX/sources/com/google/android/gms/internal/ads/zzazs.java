package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzazs implements zzazt {
    private final int zzdzl;
    private final Map zzdzm;

    zzazs(int i, Map map) {
        this.zzdzl = i;
        this.zzdzm = map;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzazq.zza(this.zzdzl, this.zzdzm, jsonWriter);
    }
}
