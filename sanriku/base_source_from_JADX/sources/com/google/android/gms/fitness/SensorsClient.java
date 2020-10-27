package com.google.android.gms.fitness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.internal.fitness.zzao;
import com.google.android.gms.internal.fitness.zzdw;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class SensorsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final SensorsApi zzif = new zzdw();

    SensorsClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzao.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected SensorsClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzao.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> add(SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzif.add(asGoogleApiClient(), sensorRequest, pendingIntent));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> add(SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        ListenerHolder registerListener = registerListener(onDataPointListener, OnDataPointListener.class.getSimpleName());
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(registerListener).register(new zzp(this, registerListener, sensorRequest)).unregister(new zzn(this, registerListener)).build());
    }

    public Task<List<DataSource>> findDataSources(DataSourcesRequest dataSourcesRequest) {
        return PendingResultUtil.toTask(zzif.findDataSources(asGoogleApiClient(), dataSourcesRequest), zzo.zzho);
    }

    public Task<Void> remove(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzif.remove(asGoogleApiClient(), pendingIntent));
    }

    public Task<Boolean> remove(OnDataPointListener onDataPointListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(onDataPointListener, OnDataPointListener.class.getSimpleName()));
    }
}
