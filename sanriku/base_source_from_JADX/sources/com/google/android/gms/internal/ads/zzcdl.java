package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzcdl extends zzadn {
    @Nullable
    private final String zzflf;
    private final zzbzx zzfqb;
    private final zzbzm zzftd;

    public zzcdl(@Nullable String str, zzbzm zzbzm, zzbzx zzbzx) {
        this.zzflf = str;
        this.zzftd = zzbzm;
        this.zzfqb = zzbzx;
    }

    public final void destroy() throws RemoteException {
        this.zzftd.destroy();
    }

    public final String getAdvertiser() throws RemoteException {
        return this.zzfqb.getAdvertiser();
    }

    public final String getBody() throws RemoteException {
        return this.zzfqb.getBody();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzfqb.getCallToAction();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.zzfqb.getExtras();
    }

    public final String getHeadline() throws RemoteException {
        return this.zzfqb.getHeadline();
    }

    public final List<?> getImages() throws RemoteException {
        return this.zzfqb.getImages();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzflf;
    }

    public final zzxl getVideoController() throws RemoteException {
        return this.zzfqb.getVideoController();
    }

    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzftd.zzg(bundle);
    }

    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzftd.zzi(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzftd.zzh(bundle);
    }

    public final IObjectWrapper zzrz() throws RemoteException {
        return ObjectWrapper.wrap(this.zzftd);
    }

    public final zzack zzsb() throws RemoteException {
        return this.zzfqb.zzsb();
    }

    public final IObjectWrapper zzsc() throws RemoteException {
        return this.zzfqb.zzsc();
    }

    public final zzacs zzsd() throws RemoteException {
        return this.zzfqb.zzsd();
    }
}
