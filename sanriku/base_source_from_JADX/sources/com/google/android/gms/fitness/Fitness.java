package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.fitness.zzac;
import com.google.android.gms.internal.fitness.zzai;
import com.google.android.gms.internal.fitness.zzao;
import com.google.android.gms.internal.fitness.zzau;
import com.google.android.gms.internal.fitness.zzcr;
import com.google.android.gms.internal.fitness.zzcz;
import com.google.android.gms.internal.fitness.zzdc;
import com.google.android.gms.internal.fitness.zzdh;
import com.google.android.gms.internal.fitness.zzdr;
import com.google.android.gms.internal.fitness.zzdw;
import com.google.android.gms.internal.fitness.zzea;
import com.google.android.gms.internal.fitness.zzn;
import com.google.android.gms.internal.fitness.zzt;
import com.google.android.gms.internal.fitness.zzz;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API = null;
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> BLE_API = zzn.API;
    @Deprecated
    public static final BleApi BleApi = new zzcr();
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> CONFIG_API = zzt.API;
    @Deprecated
    public static final ConfigApi ConfigApi = new zzcz();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> GOALS_API = zzz.API;
    @Deprecated
    public static final GoalsApi GoalsApi = new zzdc();
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> HISTORY_API = zzac.API;
    @Deprecated
    public static final HistoryApi HistoryApi = new zzdh();
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> RECORDING_API = zzai.API;
    @Deprecated
    public static final RecordingApi RecordingApi = new zzdr();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final Scope SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
    public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> SENSORS_API = zzao.API;
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API = zzau.API;
    @Deprecated
    public static final SensorsApi SensorsApi = new zzdw();
    @Deprecated
    public static final SessionsApi SessionsApi = new zzea();

    private Fitness() {
    }

    @Deprecated
    public static BleClient getBleClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new BleClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    @Deprecated
    public static BleClient getBleClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new BleClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static ConfigClient getConfigClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new ConfigClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static ConfigClient getConfigClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new ConfigClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        if (longExtra == -1) {
            return -1;
        }
        return timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static GoalsClient getGoalsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new GoalsClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static GoalsClient getGoalsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new GoalsClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static HistoryClient getHistoryClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new HistoryClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static HistoryClient getHistoryClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new HistoryClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static RecordingClient getRecordingClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new RecordingClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static RecordingClient getRecordingClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new RecordingClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static SensorsClient getSensorsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new SensorsClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static SensorsClient getSensorsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new SensorsClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static SessionsClient getSessionsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new SessionsClient(activity, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(activity, googleSignInAccount));
    }

    public static SessionsClient getSessionsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount);
        return new SessionsClient(context, (Api.ApiOptions.HasGoogleSignInAccountOptions) new zzg(context, googleSignInAccount));
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        if (longExtra == -1) {
            return -1;
        }
        return timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }
}
