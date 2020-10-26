// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Set;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.ConnectionResult;
import android.support.v4.util.ArrayMap;

public final class zzbav
{
    private final ArrayMap<zzbat<?>, ConnectionResult> zzaAB;
    private final TaskCompletionSource<Void> zzaBG;
    private int zzaBH;
    private boolean zzaBI;
    
    public zzbav(final Iterable<? extends GoogleApi<?>> iterable) {
        this.zzaBG = new TaskCompletionSource<Void>();
        this.zzaBI = false;
        this.zzaAB = new ArrayMap<zzbat<?>, ConnectionResult>();
        final Iterator<? extends GoogleApi<?>> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.zzaAB.put(((GoogleApi<?>)iterator.next()).zzph(), null);
        }
        this.zzaBH = this.zzaAB.keySet().size();
    }
    
    public final Task<Void> getTask() {
        return this.zzaBG.getTask();
    }
    
    public final void zza(final zzbat<?> zzbat, final ConnectionResult connectionResult) {
        this.zzaAB.put(zzbat, connectionResult);
        --this.zzaBH;
        if (!connectionResult.isSuccess()) {
            this.zzaBI = true;
        }
        if (this.zzaBH == 0) {
            if (!this.zzaBI) {
                this.zzaBG.setResult(null);
                return;
            }
            this.zzaBG.setException(new zza(this.zzaAB));
        }
    }
    
    public final Set<zzbat<?>> zzpt() {
        return this.zzaAB.keySet();
    }
    
    public final void zzpu() {
        this.zzaBG.setResult(null);
    }
}
