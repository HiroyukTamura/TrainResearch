package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

public final class zzale extends zzbgu {
    private final AppMeasurementSdk zzden;

    zzale(AppMeasurementSdk appMeasurementSdk) {
        this.zzden = appMeasurementSdk;
    }

    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzden.beginAdUnitExposure(str);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzden.clearConditionalUserProperty(str, str2, bundle);
    }

    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzden.endAdUnitExposure(str);
    }

    public final long generateEventId() throws RemoteException {
        return this.zzden.generateEventId();
    }

    public final String getAppIdOrigin() throws RemoteException {
        return this.zzden.getAppIdOrigin();
    }

    public final String getAppInstanceId() throws RemoteException {
        return this.zzden.getAppInstanceId();
    }

    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzden.getConditionalUserProperties(str, str2);
    }

    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzden.getCurrentScreenClass();
    }

    public final String getCurrentScreenName() throws RemoteException {
        return this.zzden.getCurrentScreenName();
    }

    public final String getGmpAppId() throws RemoteException {
        return this.zzden.getGmpAppId();
    }

    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzden.getMaxUserProperties(str);
    }

    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzden.getUserProperties(str, str2, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzden.logEvent(str, str2, bundle);
    }

    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzden.performAction(bundle);
    }

    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzden.performActionWithResponse(bundle);
    }

    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzden.setConditionalUserProperty(bundle);
    }

    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzden.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzden.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}
