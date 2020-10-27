package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class zzat<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzao> {
    public zzat(GoogleApiClient googleApiClient) {
        super((Api<?>) zzao.API, googleApiClient);
    }
}
