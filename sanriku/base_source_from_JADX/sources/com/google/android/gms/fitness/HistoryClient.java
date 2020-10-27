package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.internal.fitness.zzac;
import com.google.android.gms.internal.fitness.zzdh;
import com.google.android.gms.tasks.Task;

public class HistoryClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final HistoryApi zzhx = new zzdh();

    HistoryClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzac.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected HistoryClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzac.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> deleteData(DataDeleteRequest dataDeleteRequest) {
        return PendingResultUtil.toVoidTask(zzhx.deleteData(asGoogleApiClient(), dataDeleteRequest));
    }

    public Task<Void> insertData(DataSet dataSet) {
        return PendingResultUtil.toVoidTask(zzhx.insertData(asGoogleApiClient(), dataSet));
    }

    public Task<DataSet> readDailyTotal(DataType dataType) {
        return PendingResultUtil.toTask(zzhx.readDailyTotal(asGoogleApiClient(), dataType), zzk.zzho);
    }

    public Task<DataSet> readDailyTotalFromLocalDevice(DataType dataType) {
        return PendingResultUtil.toTask(zzhx.readDailyTotalFromLocalDevice(asGoogleApiClient(), dataType), zzj.zzho);
    }

    public Task<DataReadResponse> readData(DataReadRequest dataReadRequest) {
        return PendingResultUtil.toResponseTask(zzhx.readData(asGoogleApiClient(), dataReadRequest), new DataReadResponse());
    }

    public Task<Void> registerDataUpdateListener(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return PendingResultUtil.toVoidTask(zzhx.registerDataUpdateListener(asGoogleApiClient(), dataUpdateListenerRegistrationRequest));
    }

    public Task<Void> unregisterDataUpdateListener(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzhx.unregisterDataUpdateListener(asGoogleApiClient(), pendingIntent));
    }

    public Task<Void> updateData(DataUpdateRequest dataUpdateRequest) {
        return PendingResultUtil.toVoidTask(zzhx.updateData(asGoogleApiClient(), dataUpdateRequest));
    }
}
