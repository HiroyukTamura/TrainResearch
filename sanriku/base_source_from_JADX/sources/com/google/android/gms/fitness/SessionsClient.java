package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResponse;
import com.google.android.gms.internal.fitness.zzau;
import com.google.android.gms.internal.fitness.zzea;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class SessionsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final SessionsApi zzih = new zzea();

    SessionsClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzau.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected SessionsClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzau.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> insertSession(SessionInsertRequest sessionInsertRequest) {
        return PendingResultUtil.toVoidTask(zzih.insertSession(asGoogleApiClient(), sessionInsertRequest));
    }

    public Task<SessionReadResponse> readSession(SessionReadRequest sessionReadRequest) {
        return PendingResultUtil.toResponseTask(zzih.readSession(asGoogleApiClient(), sessionReadRequest), new SessionReadResponse());
    }

    public Task<Void> registerForSessions(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzih.registerForSessions(asGoogleApiClient(), pendingIntent));
    }

    public Task<Void> startSession(Session session) {
        return PendingResultUtil.toVoidTask(zzih.startSession(asGoogleApiClient(), session));
    }

    public Task<List<Session>> stopSession(@Nullable String str) {
        return PendingResultUtil.toTask(zzih.stopSession(asGoogleApiClient(), str), zzq.zzho);
    }

    public Task<Void> unregisterForSessions(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(zzih.unregisterForSessions(asGoogleApiClient(), pendingIntent));
    }
}
