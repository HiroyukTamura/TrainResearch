package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zas implements zabs {
    private final /* synthetic */ zaq zaet;

    private zas(zaq zaq) {
        this.zaet = zaq;
    }

    /* synthetic */ zas(zaq zaq, zat zat) {
        this(zaq);
    }

    public final void zab(int i, boolean z) {
        this.zaet.zaer.lock();
        try {
            if (!this.zaet.zaeq && this.zaet.zaep != null) {
                if (this.zaet.zaep.isSuccess()) {
                    boolean unused = this.zaet.zaeq = true;
                    this.zaet.zaej.onConnectionSuspended(i);
                }
            }
            boolean unused2 = this.zaet.zaeq = false;
            this.zaet.zaa(i, z);
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    public final void zab(@Nullable Bundle bundle) {
        this.zaet.zaer.lock();
        try {
            this.zaet.zaa(bundle);
            ConnectionResult unused = this.zaet.zaeo = ConnectionResult.RESULT_SUCCESS;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }

    public final void zac(@NonNull ConnectionResult connectionResult) {
        this.zaet.zaer.lock();
        try {
            ConnectionResult unused = this.zaet.zaeo = connectionResult;
            this.zaet.zav();
        } finally {
            this.zaet.zaer.unlock();
        }
    }
}
