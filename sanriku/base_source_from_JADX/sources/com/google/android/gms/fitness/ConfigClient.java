package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.internal.fitness.zzcz;
import com.google.android.gms.internal.fitness.zzt;
import com.google.android.gms.tasks.Task;

public class ConfigClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final ConfigApi zzht = new zzcz();

    ConfigClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzt.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected ConfigClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzt.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<DataType> createCustomDataType(DataTypeCreateRequest dataTypeCreateRequest) {
        return PendingResultUtil.toTask(zzht.createCustomDataType(asGoogleApiClient(), dataTypeCreateRequest), zze.zzho);
    }

    public Task<Void> disableFit() {
        return PendingResultUtil.toVoidTask(zzht.disableFit(asGoogleApiClient()));
    }

    public Task<DataType> readDataType(String str) {
        return PendingResultUtil.toTask(zzht.readDataType(asGoogleApiClient(), str), zzd.zzho);
    }
}
