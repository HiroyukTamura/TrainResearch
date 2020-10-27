package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzgf {
    private Tracker zzrl;
    private Context zzrm;
    private GoogleAnalytics zzro;

    public zzgf(Context context) {
        this.zzrm = context;
    }

    private final synchronized void zzbn(String str) {
        if (this.zzro == null) {
            GoogleAnalytics instance = GoogleAnalytics.getInstance(this.zzrm);
            this.zzro = instance;
            instance.setLogger(new zzgg());
            this.zzrl = this.zzro.newTracker(str);
        }
    }

    public final Tracker zzbm(String str) {
        zzbn(str);
        return this.zzrl;
    }
}
