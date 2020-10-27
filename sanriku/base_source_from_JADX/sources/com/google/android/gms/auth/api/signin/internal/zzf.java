package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzf extends AsyncTaskLoader<Void> implements SignInConnectionListener {
    private Semaphore zzcb = new Semaphore(0);
    private Set<GoogleApiClient> zzcc;

    public zzf(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzcc = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzi */
    public final Void loadInBackground() {
        int i = 0;
        for (GoogleApiClient maybeSignIn : this.zzcc) {
            if (maybeSignIn.maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zzcb.tryAcquire(i, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public final void onComplete() {
        this.zzcb.release();
    }

    /* access modifiers changed from: protected */
    public final void onStartLoading() {
        this.zzcb.drainPermits();
        forceLoad();
    }
}
