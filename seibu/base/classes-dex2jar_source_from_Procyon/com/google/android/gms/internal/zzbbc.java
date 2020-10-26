// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zzbbc implements Runnable
{
    private final zzbbb zzaBR;
    final /* synthetic */ zzbba zzaBS;
    
    zzbbc(final zzbba zzaBS, final zzbbb zzaBR) {
        this.zzaBS = zzaBS;
        this.zzaBR = zzaBR;
    }
    
    @MainThread
    @Override
    public final void run() {
        if (!this.zzaBS.mStarted) {
            return;
        }
        final ConnectionResult zzpz = this.zzaBR.zzpz();
        if (zzpz.hasResolution()) {
            this.zzaBS.zzaEG.startActivityForResult(GoogleApiActivity.zza((Context)this.zzaBS.getActivity(), zzpz.getResolution(), this.zzaBR.zzpy(), false), 1);
            return;
        }
        if (this.zzaBS.zzaBd.isUserResolvableError(zzpz.getErrorCode())) {
            this.zzaBS.zzaBd.zza(this.zzaBS.getActivity(), this.zzaBS.zzaEG, zzpz.getErrorCode(), 2, (DialogInterface$OnCancelListener)this.zzaBS);
            return;
        }
        if (zzpz.getErrorCode() == 18) {
            GoogleApiAvailability.zza(this.zzaBS.getActivity().getApplicationContext(), new zzbbd(this, GoogleApiAvailability.zza(this.zzaBS.getActivity(), (DialogInterface$OnCancelListener)this.zzaBS)));
            return;
        }
        this.zzaBS.zza(zzpz, this.zzaBR.zzpy());
    }
}
