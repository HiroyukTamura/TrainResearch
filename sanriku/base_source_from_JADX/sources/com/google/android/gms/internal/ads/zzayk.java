package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSheetDialog;

public final class zzayk {
    public final int count;
    public final String name;
    private final double zzdxo;
    private final double zzdxp;
    public final double zzdxq;

    public zzayk(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdxp = d;
        this.zzdxo = d2;
        this.zzdxq = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzayk)) {
            return false;
        }
        zzayk zzayk = (zzayk) obj;
        return Objects.equal(this.name, zzayk.name) && this.zzdxo == zzayk.zzdxo && this.zzdxp == zzayk.zzdxp && this.count == zzayk.count && Double.compare(this.zzdxq, zzayk.zzdxq) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzdxo), Double.valueOf(this.zzdxp), Double.valueOf(this.zzdxq), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("minBound", Double.valueOf(this.zzdxp)).add("maxBound", Double.valueOf(this.zzdxo)).add("percent", Double.valueOf(this.zzdxq)).add(RFGSheetDialog.ARG_COUNT, Integer.valueOf(this.count)).toString();
    }
}
