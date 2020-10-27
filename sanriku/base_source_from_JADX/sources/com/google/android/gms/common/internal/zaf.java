package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zaf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ ConnectionCallbacks zaou;

    zaf(ConnectionCallbacks connectionCallbacks) {
        this.zaou = connectionCallbacks;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        this.zaou.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.zaou.onConnectionSuspended(i);
    }
}
