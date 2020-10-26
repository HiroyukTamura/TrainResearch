// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import android.os.TransactionTooLargeException;
import android.os.Build$VERSION;
import com.google.android.gms.common.api.Status;
import android.os.RemoteException;

public abstract class zzbam
{
    private int zzamr;
    
    public zzbam(final int zzamr) {
        this.zzamr = zzamr;
    }
    
    private static Status zza(final RemoteException ex) {
        final StringBuilder sb = new StringBuilder();
        if (Build$VERSION.SDK_INT >= 15 && ex instanceof TransactionTooLargeException) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(ex.getLocalizedMessage());
        return new Status(8, sb.toString());
    }
    
    public abstract void zza(@NonNull final zzbbt p0, final boolean p1);
    
    public abstract void zza(final zzbdd<?> p0) throws DeadObjectException;
    
    public abstract void zzp(@NonNull final Status p0);
}
