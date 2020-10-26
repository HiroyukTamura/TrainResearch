// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;

public abstract class zzbay<R extends Result, A extends Api.zzb> extends zzbbe<R> implements zzbaz<R>
{
    private final Api.zzc<A> zzaBM;
    private final Api<?> zzayW;
    
    @Deprecated
    protected zzbay(final Api.zzc<A> zzc, final GoogleApiClient googleApiClient) {
        super(zzbo.zzb(googleApiClient, "GoogleApiClient must not be null"));
        this.zzaBM = (Api.zzc<A>)zzbo.zzu((Api.zzc)zzc);
        this.zzayW = null;
    }
    
    protected zzbay(final Api<?> zzayW, final GoogleApiClient googleApiClient) {
        super(zzbo.zzb(googleApiClient, "GoogleApiClient must not be null"));
        this.zzaBM = (Api.zzc<A>)zzayW.zzpd();
        this.zzayW = zzayW;
    }
    
    private final void zzc(final RemoteException ex) {
        this.zzr(new Status(8, ex.getLocalizedMessage(), null));
    }
    
    protected abstract void zza(final A p0) throws RemoteException;
    
    public final void zzb(final A a) throws DeadObjectException {
        try {
            this.zza(a);
        }
        catch (DeadObjectException ex) {
            this.zzc((RemoteException)ex);
            throw ex;
        }
        catch (RemoteException ex2) {
            this.zzc(ex2);
        }
    }
    
    public final Api.zzc<A> zzpd() {
        return this.zzaBM;
    }
    
    public final Api<?> zzpg() {
        return this.zzayW;
    }
    
    @Override
    public final void zzr(final Status status) {
        zzbo.zzb(!status.isSuccess(), (Object)"Failed result must not be success");
        this.setResult(this.zzb(status));
    }
}
