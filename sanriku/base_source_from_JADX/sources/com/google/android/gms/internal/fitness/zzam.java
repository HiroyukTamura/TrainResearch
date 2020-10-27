package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

final class zzam extends Api.AbstractClientBuilder<zzai, Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private zzam() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions = (Api.ApiOptions.HasGoogleSignInAccountOptions) obj;
        return new zzai(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
