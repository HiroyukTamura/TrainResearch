package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzahb implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbaj zzbsv;

    zzahb(zzagu zzagu, zzbaj zzbaj) {
        this.zzbsv = zzbaj;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbsv.setException(new RuntimeException("Connection failed."));
    }
}
