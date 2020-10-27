package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzsc implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzrx zzbsk;

    zzsc(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbsk.lock) {
            try {
                if (this.zzbsk.zzbsg != null) {
                    zzsk unused = this.zzbsk.zzbsh = this.zzbsk.zzbsg.zzmy();
                }
            } catch (DeadObjectException e) {
                zzazw.zzc("Unable to obtain a cache service instance.", e);
                this.zzbsk.disconnect();
            }
            this.zzbsk.lock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbsk.lock) {
            zzsk unused = this.zzbsk.zzbsh = null;
            this.zzbsk.lock.notifyAll();
        }
    }
}
