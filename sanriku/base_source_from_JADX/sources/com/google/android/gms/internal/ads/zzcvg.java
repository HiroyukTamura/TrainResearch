package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzq;
import java.util.List;

public final class zzcvg implements zzdah<Bundle> {
    private final zzum zzbmp;
    private final List<Parcelable> zzglm;
    private final Context zzvf;

    public zzcvg(Context context, zzum zzum, List<Parcelable> list) {
        this.zzvf = context;
        this.zzbmp = zzum;
        this.zzglm = list;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (zzabm.zzcwz.get().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzq.zzkw();
            bundle2.putString("activity", zzaxa.zzat(this.zzvf));
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzbmp.width);
            bundle3.putInt("height", this.zzbmp.height);
            bundle2.putBundle("size", bundle3);
            if (this.zzglm.size() > 0) {
                List<Parcelable> list = this.zzglm;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
