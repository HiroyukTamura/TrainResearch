package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzsb implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzrx zzbsk;

    zzsb(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbsk.lock) {
            zzsk unused = this.zzbsk.zzbsh = null;
            if (this.zzbsk.zzbsg != null) {
                zzsg unused2 = this.zzbsk.zzbsg = null;
            }
            this.zzbsk.lock.notifyAll();
        }
    }
}
