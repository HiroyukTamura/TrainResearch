package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import p009e.p010a.p011a.p012a.C0681a;

final class zzagy implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbaj zzbsv;
    private final /* synthetic */ zzagu zzdbf;

    zzagy(zzagu zzagu, zzbaj zzbaj) {
        this.zzdbf = zzagu;
        this.zzbsv = zzbaj;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zzbsv.set(this.zzdbf.zzdbd.zzso());
        } catch (DeadObjectException e) {
            this.zzbsv.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zzbsv.setException(new RuntimeException(C0681a.m309a(34, "onConnectionSuspended: ", i)));
    }
}
