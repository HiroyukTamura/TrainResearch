package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

public final class zzaot {
    private final zzbek zzdce;
    private final boolean zzdix;
    private final String zzdiy;

    public zzaot(zzbek zzbek, Map<String, String> map) {
        this.zzdce = zzbek;
        this.zzdiy = map.get("forceOrientation");
        this.zzdix = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean(map.get("allowOrientationChange")) : true;
    }

    public final void execute() {
        int i;
        if (this.zzdce == null) {
            zzazw.zzfc("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdiy)) {
            zzq.zzky();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdiy)) {
            zzq.zzky();
            i = 6;
        } else {
            i = this.zzdix ? -1 : zzq.zzky().zzxk();
        }
        this.zzdce.setRequestedOrientation(i);
    }
}
