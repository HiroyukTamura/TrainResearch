// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.api.Api;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzbbz extends GoogleApiClient
{
    private final UnsupportedOperationException zzaCY;
    
    public zzbbz(final String message) {
        this.zzaCY = new UnsupportedOperationException(message);
    }
    
    @Override
    public ConnectionResult blockingConnect() {
        throw this.zzaCY;
    }
    
    @Override
    public ConnectionResult blockingConnect(final long n, @NonNull final TimeUnit timeUnit) {
        throw this.zzaCY;
    }
    
    @Override
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw this.zzaCY;
    }
    
    @Override
    public void connect() {
        throw this.zzaCY;
    }
    
    @Override
    public void disconnect() {
        throw this.zzaCY;
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        throw this.zzaCY;
    }
    
    @NonNull
    @Override
    public ConnectionResult getConnectionResult(@NonNull final Api<?> api) {
        throw this.zzaCY;
    }
    
    @Override
    public boolean hasConnectedApi(@NonNull final Api<?> api) {
        throw this.zzaCY;
    }
    
    @Override
    public boolean isConnected() {
        throw this.zzaCY;
    }
    
    @Override
    public boolean isConnecting() {
        throw this.zzaCY;
    }
    
    @Override
    public boolean isConnectionCallbacksRegistered(@NonNull final ConnectionCallbacks connectionCallbacks) {
        throw this.zzaCY;
    }
    
    @Override
    public boolean isConnectionFailedListenerRegistered(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        throw this.zzaCY;
    }
    
    @Override
    public void reconnect() {
        throw this.zzaCY;
    }
    
    @Override
    public void registerConnectionCallbacks(@NonNull final ConnectionCallbacks connectionCallbacks) {
        throw this.zzaCY;
    }
    
    @Override
    public void registerConnectionFailedListener(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        throw this.zzaCY;
    }
    
    @Override
    public void stopAutoManage(@NonNull final FragmentActivity fragmentActivity) {
        throw this.zzaCY;
    }
    
    @Override
    public void unregisterConnectionCallbacks(@NonNull final ConnectionCallbacks connectionCallbacks) {
        throw this.zzaCY;
    }
    
    @Override
    public void unregisterConnectionFailedListener(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        throw this.zzaCY;
    }
}
