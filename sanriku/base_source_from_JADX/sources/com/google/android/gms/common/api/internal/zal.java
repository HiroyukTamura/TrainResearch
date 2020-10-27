package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zal implements Runnable {
    private final zam zadk;
    final /* synthetic */ zak zadl;

    zal(zak zak, zam zam) {
        this.zadl = zak;
        this.zadk = zam;
    }

    @MainThread
    public final void run() {
        if (this.zadl.zadh) {
            ConnectionResult connectionResult = this.zadk.getConnectionResult();
            if (connectionResult.hasResolution()) {
                zak zak = this.zadl;
                zak.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zak.getActivity(), connectionResult.getResolution(), this.zadk.zap(), false), 1);
            } else if (this.zadl.zace.isUserResolvableError(connectionResult.getErrorCode())) {
                zak zak2 = this.zadl;
                zak2.zace.zaa(zak2.getActivity(), this.zadl.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zadl);
            } else if (connectionResult.getErrorCode() == 18) {
                Dialog zaa = GoogleApiAvailability.zaa(this.zadl.getActivity(), (DialogInterface.OnCancelListener) this.zadl);
                zak zak3 = this.zadl;
                zak3.zace.zaa(zak3.getActivity().getApplicationContext(), (zabp) new zan(this, zaa));
            } else {
                this.zadl.zaa(connectionResult, this.zadk.zap());
            }
        }
    }
}
