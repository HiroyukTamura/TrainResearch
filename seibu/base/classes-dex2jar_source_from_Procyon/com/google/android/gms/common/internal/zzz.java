// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.zzc;
import android.support.annotation.NonNull;
import java.util.Iterator;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import android.accounts.Account;
import com.google.android.gms.common.api.Api;
import android.os.IInterface;

public abstract class zzz<T extends IInterface> extends zzd<T> implements zze, zzad
{
    private final zzq zzaCA;
    private final Account zzajb;
    private final Set<Scope> zzame;
    
    protected zzz(final Context context, final Looper looper, final int n, final zzq zzq, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzae.zzaC(context), GoogleApiAvailability.getInstance(), n, zzq, zzbo.zzu(connectionCallbacks), zzbo.zzu(onConnectionFailedListener));
    }
    
    private zzz(final Context context, final Looper looper, final zzae zzae, final GoogleApiAvailability googleApiAvailability, final int n, final zzq zzaCA, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzf zzf;
        if (connectionCallbacks == null) {
            zzf = null;
        }
        else {
            zzf = new zzaa(connectionCallbacks);
        }
        com.google.android.gms.common.internal.zzg zzg;
        if (onConnectionFailedListener == null) {
            zzg = null;
        }
        else {
            zzg = new zzab(onConnectionFailedListener);
        }
        super(context, looper, zzae, googleApiAvailability, n, zzf, zzg, zzaCA.zzrr());
        this.zzaCA = zzaCA;
        this.zzajb = zzaCA.getAccount();
        final Set<Scope> zzro = zzaCA.zzro();
        final Set<Scope> zzb = this.zzb(zzro);
        final Iterator<Scope> iterator = zzb.iterator();
        while (iterator.hasNext()) {
            if (!zzro.contains(iterator.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zzame = zzb;
    }
    
    @Override
    public final Account getAccount() {
        return this.zzajb;
    }
    
    @NonNull
    protected Set<Scope> zzb(@NonNull final Set<Scope> set) {
        return set;
    }
    
    @Override
    public com.google.android.gms.common.zzc[] zzrd() {
        return new com.google.android.gms.common.zzc[0];
    }
    
    @Override
    protected final Set<Scope> zzrh() {
        return this.zzame;
    }
    
    protected final zzq zzry() {
        return this.zzaCA;
    }
}
