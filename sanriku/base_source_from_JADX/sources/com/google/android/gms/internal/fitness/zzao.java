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

public final class zzao extends zzl<zzcb> {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Fitness.SENSORS_API", new zzaq(), CLIENT_KEY);
    private static final Api.ClientKey<zzao> CLIENT_KEY = new Api.ClientKey<>();
    private static final zzf.zza zzmw = zzf.zza.FIT_SENSORS;
    public static final Api<Api.ApiOptions.HasGoogleSignInAccountOptions> zzmx = new Api<>("Fitness.SENSORS_CLIENT", new zzas(), CLIENT_KEY);

    private zzao(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzmw, connectionCallbacks, onConnectionFailedListener, clientSettings);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
        return queryLocalInterface instanceof zzcb ? (zzcb) queryLocalInterface : new zzca(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.fitness.SensorsApi";
    }
}
