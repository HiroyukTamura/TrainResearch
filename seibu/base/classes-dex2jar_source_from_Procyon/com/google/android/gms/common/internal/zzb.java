// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.ApiException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public final class zzb
{
    @NonNull
    public static ApiException zzx(@NonNull final Status status) {
        if (status.hasResolution()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
