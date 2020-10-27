package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

final class zzaok implements zzo {
    private final /* synthetic */ zzaol zzdhz;

    zzaok(zzaol zzaol) {
        this.zzdhz = zzaol;
    }

    public final void onPause() {
        zzazw.zzed("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzazw.zzed("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zztz() {
        zzazw.zzed("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdhz.zzdib.onAdClosed(this.zzdhz);
    }

    public final void zzua() {
        zzazw.zzed("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdhz.zzdib.onAdOpened(this.zzdhz);
    }
}
