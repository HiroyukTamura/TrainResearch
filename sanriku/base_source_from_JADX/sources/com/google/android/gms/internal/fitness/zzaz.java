package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class zzaz<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzau> {
    public zzaz(GoogleApiClient googleApiClient) {
        super((Api<?>) zzau.API, googleApiClient);
    }
}
