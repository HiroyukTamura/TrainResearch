package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

public final class zzdan implements zzdah<Bundle> {
    private final boolean zzdqh;
    private final boolean zzdqi;
    private final String zzdqj;
    private final boolean zzdqk;
    private final boolean zzdql;
    private final boolean zzdqm;
    private final String zzdqn;
    private final String zzdqo;
    private final String zzdqp;
    private final boolean zzdqq;
    private final ArrayList<String> zzgor;
    private final String zzgos;
    private final String zzgot;
    private final long zzgou;

    public zzdan(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, String str3, String str4, String str5, boolean z6, String str6, long j) {
        this.zzdqh = z;
        this.zzdqi = z2;
        this.zzdqj = str;
        this.zzdqk = z3;
        this.zzdql = z4;
        this.zzdqm = z5;
        this.zzdqn = str2;
        this.zzgor = arrayList;
        this.zzdqo = str3;
        this.zzdqp = str4;
        this.zzgos = str5;
        this.zzdqq = z6;
        this.zzgot = str6;
        this.zzgou = j;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zzdqh);
        bundle.putBoolean("coh", this.zzdqi);
        bundle.putString("gl", this.zzdqj);
        bundle.putBoolean("simulator", this.zzdqk);
        bundle.putBoolean("is_latchsky", this.zzdql);
        bundle.putBoolean("is_sidewinder", this.zzdqm);
        bundle.putString("hl", this.zzdqn);
        if (!this.zzgor.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzgor);
        }
        bundle.putString("mv", this.zzdqo);
        bundle.putString("submodel", this.zzgot);
        Bundle zza = zzdhj.zza(bundle, "device");
        bundle.putBundle("device", zza);
        zza.putString("build", this.zzgos);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcom)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzgou);
        }
        Bundle zza2 = zzdhj.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdqq);
        if (!TextUtils.isEmpty(this.zzdqp)) {
            Bundle zza3 = zzdhj.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.zzdqp);
        }
    }
}
