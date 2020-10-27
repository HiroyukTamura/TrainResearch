package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

public class MediationConfiguration {
    private final Bundle zzelx;
    private final AdFormat zzemb;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzemb = adFormat;
        this.zzelx = bundle;
    }

    public AdFormat getFormat() {
        return this.zzemb;
    }

    public Bundle getServerParameters() {
        return this.zzelx;
    }
}
