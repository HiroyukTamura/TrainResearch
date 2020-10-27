package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

public final class zzdbi implements zzdak<zzdbf> {
    private final String packageName;
    private final zzdrh zzfur;
    private final zzarq zzgph;
    private final Context zzvf;

    public zzdbi(@Nullable zzarq zzarq, Context context, String str, zzdrh zzdrh) {
        this.zzgph = zzarq;
        this.zzvf = context;
        this.packageName = str;
        this.zzfur = zzdrh;
    }

    public final zzdri<zzdbf> zzaqa() {
        return this.zzfur.zzd(new zzdbh(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdbf zzaqt() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzarq zzarq = this.zzgph;
        if (zzarq != null) {
            zzarq.zza(this.zzvf, this.packageName, jSONObject);
        }
        return new zzdbf(jSONObject);
    }
}
