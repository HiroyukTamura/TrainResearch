package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Common {
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zapv;
    public static final zab zapw = new zae();

    static {
        zac zac = new zac();
        zapv = zac;
        API = new Api<>("Common.API", zac, CLIENT_KEY);
    }
}
