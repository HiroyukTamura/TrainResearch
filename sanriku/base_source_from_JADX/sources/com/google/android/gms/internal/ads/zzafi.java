package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

public final class zzafi implements zzaga<Object> {
    private final zzafl zzczw;

    public zzafi(zzafl zzafl) {
        this.zzczw = zzafl;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zzazw.zzfc("App event with no name parameter.");
        } else {
            this.zzczw.onAppEvent(str, map.get("info"));
        }
    }
}
