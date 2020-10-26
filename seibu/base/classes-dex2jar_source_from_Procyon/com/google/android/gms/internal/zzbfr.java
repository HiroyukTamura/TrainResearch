// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzbfr implements zzbfq
{
    @Override
    public final PendingResult<Status> zzd(final GoogleApiClient googleApiClient) {
        return googleApiClient.zze((PendingResult<Status>)new zzbfs(this, googleApiClient));
    }
}
