package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

final class zzr extends Api.AbstractClientBuilder<zzn, Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private zzr() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions = (Api.ApiOptions.HasGoogleSignInAccountOptions) obj;
        return new zzn(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
