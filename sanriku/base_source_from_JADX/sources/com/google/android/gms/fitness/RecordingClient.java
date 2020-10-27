package com.google.android.gms.fitness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzai;
import com.google.android.gms.internal.fitness.zzdr;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class RecordingClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final RecordingApi zzie = new zzdr();

    RecordingClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzai.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected RecordingClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzai.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<List<Subscription>> listSubscriptions() {
        return PendingResultUtil.toTask(zzie.listSubscriptions(asGoogleApiClient()), zzm.zzho);
    }

    public Task<List<Subscription>> listSubscriptions(DataType dataType) {
        return PendingResultUtil.toTask(zzie.listSubscriptions(asGoogleApiClient(), dataType), zzl.zzho);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> subscribe(DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zzie.subscribe(asGoogleApiClient(), dataSource));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    @SuppressLint({"InlinedApi"})
    public Task<Void> subscribe(DataType dataType) {
        return PendingResultUtil.toVoidTask(zzie.subscribe(asGoogleApiClient(), dataType));
    }

    public Task<Void> unsubscribe(DataSource dataSource) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), dataSource));
    }

    public Task<Void> unsubscribe(DataType dataType) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), dataType));
    }

    public Task<Void> unsubscribe(Subscription subscription) {
        return PendingResultUtil.toVoidTask(zzie.unsubscribe(asGoogleApiClient(), subscription));
    }
}
