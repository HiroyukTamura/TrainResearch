package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.zac;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp {
    public static final Status zalb = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zalc = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zald = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacq zale = new zaco(this);

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zahd = map;
    }

    public final void release() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zald.toArray(zalc)) {
            basePendingResult.zaa((zacq) null);
            if (basePendingResult.zal() != null) {
                basePendingResult.setResultCallback((ResultCallback) null);
                IBinder serviceBrokerBinder = this.zahd.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa((zacq) new zacr(basePendingResult, (zac) null, serviceBrokerBinder, (zaco) null));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zaa((zacq) null);
                    basePendingResult.cancel();
                    basePendingResult.zal().intValue();
                    throw null;
                } else {
                    zacr zacr = new zacr(basePendingResult, (zac) null, serviceBrokerBinder, (zaco) null);
                    basePendingResult.zaa((zacq) zacr);
                    try {
                        serviceBrokerBinder.linkToDeath(zacr, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.cancel();
                        basePendingResult.zal().intValue();
                        throw null;
                    }
                }
            } else if (!basePendingResult.zaq()) {
            }
            this.zald.remove(basePendingResult);
        }
    }

    public final void zabv() {
        for (BasePendingResult zab : (BasePendingResult[]) this.zald.toArray(zalc)) {
            zab.zab(zalb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult<? extends Result> basePendingResult) {
        this.zald.add(basePendingResult);
        basePendingResult.zaa(this.zale);
    }
}
