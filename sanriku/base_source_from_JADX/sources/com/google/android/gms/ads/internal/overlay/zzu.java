package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzub;

public final class zzu extends zzapf {
    private Activity zzaad;
    private boolean zzdjw = false;
    private AdOverlayInfoParcel zzdld;
    private boolean zzdle = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdld = adOverlayInfoParcel;
        this.zzaad = activity;
    }

    private final synchronized void zzur() {
        if (!this.zzdle) {
            if (this.zzdld.zzdkt != null) {
                this.zzdld.zzdkt.zztz();
            }
            this.zzdle = true;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void onBackPressed() throws RemoteException {
    }

    public final void onCreate(Bundle bundle) {
        zzo zzo;
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdld;
        if (adOverlayInfoParcel != null && !z) {
            if (bundle == null) {
                zzub zzub = adOverlayInfoParcel.zzceb;
                if (zzub != null) {
                    zzub.onAdClicked();
                }
                if (!(this.zzaad.getIntent() == null || !this.zzaad.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zzdld.zzdkt) == null)) {
                    zzo.zzua();
                }
            }
            zzq.zzku();
            Activity activity = this.zzaad;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdld;
            if (!zzb.zza((Context) activity, adOverlayInfoParcel2.zzdks, adOverlayInfoParcel2.zzdkx)) {
                this.zzaad.finish();
                return;
            }
            return;
        }
        this.zzaad.finish();
    }

    public final void onDestroy() throws RemoteException {
        if (this.zzaad.isFinishing()) {
            zzur();
        }
    }

    public final void onPause() throws RemoteException {
        zzo zzo = this.zzdld.zzdkt;
        if (zzo != null) {
            zzo.onPause();
        }
        if (this.zzaad.isFinishing()) {
            zzur();
        }
    }

    public final void onRestart() throws RemoteException {
    }

    public final void onResume() throws RemoteException {
        if (this.zzdjw) {
            this.zzaad.finish();
            return;
        }
        this.zzdjw = true;
        zzo zzo = this.zzdld.zzdkt;
        if (zzo != null) {
            zzo.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdjw);
    }

    public final void onStart() throws RemoteException {
    }

    public final void onStop() throws RemoteException {
        if (this.zzaad.isFinishing()) {
            zzur();
        }
    }

    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzdp() throws RemoteException {
    }

    public final boolean zzuh() throws RemoteException {
        return false;
    }
}
