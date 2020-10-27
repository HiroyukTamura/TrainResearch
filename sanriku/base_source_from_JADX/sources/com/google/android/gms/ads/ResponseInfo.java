package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzxg;

public final class ResponseInfo {
    private final zzxg zzacv;

    private ResponseInfo(zzxg zzxg) {
        this.zzacv = zzxg;
    }

    @Nullable
    public static ResponseInfo zza(@Nullable zzxg zzxg) {
        if (zzxg != null) {
            return new ResponseInfo(zzxg);
        }
        return null;
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        try {
            return this.zzacv.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    @Nullable
    public final String getResponseId() {
        try {
            return this.zzacv.getResponseId();
        } catch (RemoteException e) {
            zzazw.zzc("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }
}
