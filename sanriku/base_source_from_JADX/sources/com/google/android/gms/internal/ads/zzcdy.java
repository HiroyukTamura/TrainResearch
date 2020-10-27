package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;

final class zzcdy implements zzo, zzt, zzafj, zzafl, zzub {
    private zzub zzceb;
    private zzafj zzczu;
    private zzafl zzczw;
    private zzo zzdkt;
    private zzt zzdkx;

    private zzcdy() {
    }

    /* synthetic */ zzcdy(zzcdu zzcdu) {
        this();
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzub zzub, zzafj zzafj, zzo zzo, zzafl zzafl, zzt zzt) {
        this.zzceb = zzub;
        this.zzczu = zzafj;
        this.zzdkt = zzo;
        this.zzczw = zzafl;
        this.zzdkx = zzt;
    }

    public final synchronized void onAdClicked() {
        if (this.zzceb != null) {
            this.zzceb.onAdClicked();
        }
    }

    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        if (this.zzczw != null) {
            this.zzczw.onAppEvent(str, str2);
        }
    }

    public final synchronized void onPause() {
        if (this.zzdkt != null) {
            this.zzdkt.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.zzdkt != null) {
            this.zzdkt.onResume();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzczu != null) {
            this.zzczu.zza(str, bundle);
        }
    }

    public final synchronized void zztz() {
        if (this.zzdkt != null) {
            this.zzdkt.zztz();
        }
    }

    public final synchronized void zzua() {
        if (this.zzdkt != null) {
            this.zzdkt.zzua();
        }
    }

    public final synchronized void zzuq() {
        if (this.zzdkx != null) {
            this.zzdkx.zzuq();
        }
    }
}
