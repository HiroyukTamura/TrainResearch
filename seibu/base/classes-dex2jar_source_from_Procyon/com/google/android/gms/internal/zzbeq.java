// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.Api;

public abstract class zzbeq<A extends Api.zzb, TResult>
{
    protected abstract void zza(final A p0, final TaskCompletionSource<TResult> p1) throws RemoteException;
}
