package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzcvs implements zzdah<Bundle> {
    private final String zzacf;
    private final zzum zzbmp;
    private final float zzbpk;
    private final boolean zzcey;
    private final int zzdji;
    private final int zzdjj;
    private final String zzgls;
    private final String zzglt;
    private final boolean zzglu;

    public zzcvs(zzum zzum, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzum, "the adSize must not be null");
        this.zzbmp = zzum;
        this.zzacf = str;
        this.zzcey = z;
        this.zzgls = str2;
        this.zzbpk = f;
        this.zzdji = i;
        this.zzdjj = i2;
        this.zzglt = str3;
        this.zzglu = z2;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdhj.zza(bundle, "smart_w", "full", this.zzbmp.width == -1);
        zzdhj.zza(bundle, "smart_h", "auto", this.zzbmp.height == -2);
        zzdhj.zza(bundle, "ene", (Boolean) true, this.zzbmp.zzcez);
        zzdhj.zza(bundle, "rafmt", "102", this.zzbmp.zzcfc);
        zzdhj.zza(bundle, "rafmt", "103", this.zzbmp.zzcfd);
        zzdhj.zza(bundle, "inline_adaptive_slot", (Boolean) true, this.zzglu);
        zzdhj.zza(bundle, "format", this.zzacf);
        zzdhj.zza(bundle, "fluid", "height", this.zzcey);
        String str = this.zzgls;
        zzdhj.zza(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zzbpk);
        bundle.putInt("sw", this.zzdji);
        bundle.putInt("sh", this.zzdjj);
        String str2 = this.zzglt;
        zzdhj.zza(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzum[] zzumArr = this.zzbmp.zzcex;
        if (zzumArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zzbmp.height);
            bundle2.putInt("width", this.zzbmp.width);
            bundle2.putBoolean("is_fluid_height", this.zzbmp.zzcey);
            arrayList.add(bundle2);
        } else {
            for (zzum zzum : zzumArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzum.zzcey);
                bundle3.putInt("height", zzum.height);
                bundle3.putInt("width", zzum.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
