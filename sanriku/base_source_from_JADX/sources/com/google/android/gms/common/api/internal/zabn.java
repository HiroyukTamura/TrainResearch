package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

public final class zabn<O extends Api.ApiOptions> extends zaag {
    private final GoogleApi<O> zajj;

    public zabn(GoogleApi<O> googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zajj = googleApi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        return this.zajj.doRead(t);
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        return this.zajj.doWrite(t);
    }

    public final Context getContext() {
        return this.zajj.getApplicationContext();
    }

    public final Looper getLooper() {
        return this.zajj.getLooper();
    }

    public final void zaa(zack zack) {
    }

    public final void zab(zack zack) {
    }
}
