package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzcwk implements zzdah {
    private final ArrayList zzglx;

    zzcwk(ArrayList arrayList) {
        this.zzglx = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzglx);
    }
}
