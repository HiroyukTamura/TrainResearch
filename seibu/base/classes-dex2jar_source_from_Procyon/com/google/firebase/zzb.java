// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbem;

public final class zzb implements zzbem
{
    @Override
    public final Exception zzq(final Status status) {
        if (status.getStatusCode() == 8) {
            return new FirebaseException(status.zzpq());
        }
        return new FirebaseApiNotAvailableException(status.zzpq());
    }
}
