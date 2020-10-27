package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.fitness.data.Goal;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.internal.fitness.zzdc;
import com.google.android.gms.internal.fitness.zzz;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class GoalsClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final GoalsApi zzhw = new zzdc();

    GoalsClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzz.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected GoalsClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzz.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<List<Goal>> readCurrentGoals(GoalsReadRequest goalsReadRequest) {
        return PendingResultUtil.toTask(zzhw.readCurrentGoals(asGoogleApiClient(), goalsReadRequest), zzi.zzho);
    }
}
