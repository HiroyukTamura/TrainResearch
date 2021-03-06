package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface> extends GmsClient<T> {
    private final GmsClientEventManager zagw;

    public LegacyInternalGmsClient(Context context, int i, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, context.getMainLooper(), i, clientSettings);
        GmsClientEventManager gmsClientEventManager = new GmsClientEventManager(context.getMainLooper(), this);
        this.zagw = gmsClientEventManager;
        gmsClientEventManager.registerConnectionCallbacks(connectionCallbacks);
        this.zagw.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void checkAvailabilityAndConnect() {
        this.zagw.enableCallbacks();
        super.checkAvailabilityAndConnect();
    }

    public void disconnect() {
        this.zagw.disableCallbacks();
        super.disconnect();
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zagw.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zagw.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void onConnectedLocked(@NonNull T t) {
        super.onConnectedLocked(t);
        this.zagw.onConnectionSuccess(getConnectionHint());
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zagw.onConnectionFailure(connectionResult);
    }

    public void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        this.zagw.onUnintentionalDisconnection(i);
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zagw.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zagw.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zagw.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zagw.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}
