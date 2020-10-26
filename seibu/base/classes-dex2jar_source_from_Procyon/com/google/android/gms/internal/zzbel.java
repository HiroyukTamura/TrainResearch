// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.zzal;
import android.support.annotation.WorkerThread;

@WorkerThread
public interface zzbel
{
    void zzb(final zzal p0, final Set<Scope> p1);
    
    void zzh(final ConnectionResult p0);
}
