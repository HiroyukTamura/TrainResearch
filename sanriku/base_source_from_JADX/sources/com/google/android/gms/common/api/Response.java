package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private T zzbb;

    public Response() {
    }

    protected Response(@NonNull T t) {
        this.zzbb = t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.zzbb;
    }

    public void setResult(@NonNull T t) {
        this.zzbb = t;
    }
}
