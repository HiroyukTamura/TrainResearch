package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzawr;

public final class zzr extends zzc {
    public zzr(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        zzawr.zzeg("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdjz = 3;
        this.zzaad.finish();
    }
}
