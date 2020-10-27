package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import p009e.p010a.p011a.p012a.C0681a;

public final class zad<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> extends zac {
    private final A zacp;

    public zad(int i, A a) {
        super(i);
        this.zacp = a;
    }

    public final void zaa(@NonNull Status status) {
        this.zacp.setFailedResult(status);
    }

    public final void zaa(@NonNull zaz zaz, boolean z) {
        zaz.zaa((BasePendingResult<? extends Result>) this.zacp, z);
    }

    public final void zaa(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        this.zacp.setFailedResult(new Status(10, C0681a.m313a(C0681a.m336b(localizedMessage, simpleName.length() + 2), simpleName, ": ", localizedMessage)));
    }

    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            this.zacp.run(zaa.zaad());
        } catch (RuntimeException e) {
            zaa(e);
        }
    }
}
