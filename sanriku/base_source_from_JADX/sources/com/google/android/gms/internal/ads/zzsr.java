package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzsr implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbaj zzbsv;
    private final /* synthetic */ zzsl zzbsw;

    zzsr(zzsl zzsl, zzbaj zzbaj) {
        this.zzbsw = zzsl;
        this.zzbsv = zzbaj;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbsw.lock) {
            this.zzbsv.setException(new RuntimeException("Connection failed."));
        }
    }
}
