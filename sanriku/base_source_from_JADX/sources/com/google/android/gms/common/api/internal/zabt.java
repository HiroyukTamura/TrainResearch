package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabt extends zak {
    private TaskCompletionSource<Void> zajs = new TaskCompletionSource<>();

    private zabt(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
    }

    public static zabt zac(Activity activity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zabt zabt = (zabt) fragment.getCallbackOrNull("GmsAvailabilityHelper", zabt.class);
        if (zabt == null) {
            return new zabt(fragment);
        }
        if (zabt.zajs.getTask().isComplete()) {
            zabt.zajs = new TaskCompletionSource<>();
        }
        return zabt;
    }

    public final Task<Void> getTask() {
        return this.zajs.getTask();
    }

    public void onDestroy() {
        super.onDestroy();
        this.zajs.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* access modifiers changed from: protected */
    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zajs.setException(ApiExceptionUtil.fromStatus(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution())));
    }

    /* access modifiers changed from: protected */
    public final void zam() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        if (lifecycleActivity == null) {
            this.zajs.trySetException(new ApiException(new Status(8)));
            return;
        }
        int isGooglePlayServicesAvailable = this.zace.isGooglePlayServicesAvailable(lifecycleActivity);
        if (isGooglePlayServicesAvailable == 0) {
            this.zajs.trySetResult(null);
        } else if (!this.zajs.getTask().isComplete()) {
            zab(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null), 0);
        }
    }
}
