package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzdw implements SensorsApi {
    private final PendingResult<Status> zza(GoogleApiClient googleApiClient, @Nullable zzu zzu, @Nullable PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzeb(this, googleApiClient, zzu, pendingIntent));
    }

    private final PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzu zzu, PendingIntent pendingIntent) {
        return googleApiClient.enqueue(new zzdy(this, googleApiClient, sensorRequest, zzu, pendingIntent));
    }

    public final PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, (zzu) null, pendingIntent);
    }

    public final PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, zzam.zzaa().zza(onDataPointListener, googleApiClient.getLooper()), (PendingIntent) null);
    }

    public final PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.enqueue(new zzdz(this, googleApiClient, dataSourcesRequest));
    }

    public final PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, (zzu) null, pendingIntent);
    }

    public final PendingResult<Status> remove(GoogleApiClient googleApiClient, OnDataPointListener onDataPointListener) {
        zzak zzb = zzam.zzaa().zzb(onDataPointListener, googleApiClient.getLooper());
        return zzb == null ? PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient) : zza(googleApiClient, zzb, (PendingIntent) null);
    }
}
