package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzcvv implements zzdah {
    private final ArrayList zzglx;

    zzcvv(ArrayList arrayList) {
        this.zzglx = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzglx);
    }
}
