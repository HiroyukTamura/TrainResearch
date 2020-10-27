package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzayj {
    /* access modifiers changed from: private */
    public final List<String> zzdxl = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdxm = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdxn = new ArrayList();

    public final zzayj zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzdxl.size()) {
            double doubleValue = this.zzdxn.get(i).doubleValue();
            double doubleValue2 = this.zzdxm.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzdxl.add(i, str);
        this.zzdxn.add(i, Double.valueOf(d));
        this.zzdxm.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzayi zzxw() {
        return new zzayi(this);
    }
}
