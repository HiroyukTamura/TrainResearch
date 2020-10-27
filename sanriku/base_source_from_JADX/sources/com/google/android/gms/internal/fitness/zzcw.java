package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.BleDevicesResult;

final class zzcw extends zzeo {
    private final BaseImplementation.ResultHolder<BleDevicesResult> zzmv;

    private zzcw(BaseImplementation.ResultHolder<BleDevicesResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    /* synthetic */ zzcw(BaseImplementation.ResultHolder resultHolder, zzcq zzcq) {
        this(resultHolder);
    }

    public final void zza(BleDevicesResult bleDevicesResult) {
        this.zzmv.setResult(bleDevicesResult);
    }
}
