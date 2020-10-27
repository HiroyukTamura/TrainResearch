package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zabx implements RemoteCall {
    private final RegistrationMethods.Builder zaki;

    zabx(RegistrationMethods.Builder builder) {
        this.zaki = builder;
    }

    public final void accept(Object obj, Object obj2) {
        this.zaki.zaa((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
