package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.fitness.zzf;

public final class zzai extends zzl<zzbz> {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Fitness.RECORDING_API", new zzak(), CLIENT_KEY);
    private static final Api.ClientKey<zzai> CLIENT_KEY = new Api.ClientKey<>();
    private static final zzf.zza zzmw = zzf.zza.FIT_RECORDING;
    public static final Api<Api.ApiOptions.HasGoogleSignInAccountOptions> zzmx = new Api<>("Fitness.RECORDING_CLIENT", new zzam(), CLIENT_KEY);

    private zzai(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzmw, connectionCallbacks, onConnectionFailedListener, clientSettings);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
        return queryLocalInterface instanceof zzbz ? (zzbz) queryLocalInterface : new zzby(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.fitness.RecordingApi";
    }
}
