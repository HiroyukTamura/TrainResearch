// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.BinderThread;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.view.View;
import com.google.android.gms.common.internal.zzr;
import java.util.Map;
import android.accounts.Account;
import java.util.Collection;
import java.util.HashSet;
import com.google.android.gms.auth.api.signin.internal.zzy;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbr;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.internal.zzq;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzbej extends zzctp implements ConnectionCallbacks, OnConnectionFailedListener
{
    private static Api.zza<? extends zzctk, zzctl> zzaEV;
    private final Context mContext;
    private final Handler mHandler;
    private final Api.zza<? extends zzctk, zzctl> zzaAx;
    private zzq zzaCA;
    private zzctk zzaDh;
    private final boolean zzaEW;
    private zzbel zzaEX;
    private Set<Scope> zzame;
    
    static {
        zzbej.zzaEV = zzctg.zzajS;
    }
    
    @WorkerThread
    public zzbej(final Context mContext, final Handler mHandler) {
        this.mContext = mContext;
        this.mHandler = mHandler;
        this.zzaAx = zzbej.zzaEV;
        this.zzaEW = true;
    }
    
    @WorkerThread
    public zzbej(final Context mContext, final Handler mHandler, @NonNull final zzq zzq, final Api.zza<? extends zzctk, zzctl> zzaAx) {
        this.mContext = mContext;
        this.mHandler = mHandler;
        this.zzaCA = zzbo.zzb(zzq, "ClientSettings must not be null");
        this.zzame = zzq.zzrn();
        this.zzaAx = zzaAx;
        this.zzaEW = false;
    }
    
    @WorkerThread
    private final void zzc(final zzctx zzctx) {
        final ConnectionResult zzpz = zzctx.zzpz();
        if (zzpz.isSuccess()) {
            final zzbr zzAx = zzctx.zzAx();
            final ConnectionResult zzpz2 = zzAx.zzpz();
            if (!zzpz2.isSuccess()) {
                final String value = String.valueOf(zzpz2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(value).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(value).toString(), (Throwable)new Exception());
                this.zzaEX.zzh(zzpz2);
                ((Api.zze)this.zzaDh).disconnect();
                return;
            }
            this.zzaEX.zzb(zzAx.zzrH(), this.zzame);
        }
        else {
            this.zzaEX.zzh(zzpz);
        }
        ((Api.zze)this.zzaDh).disconnect();
    }
    
    @WorkerThread
    @Override
    public final void onConnected(@Nullable final Bundle bundle) {
        this.zzaDh.zza(this);
    }
    
    @WorkerThread
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult connectionResult) {
        this.zzaEX.zzh(connectionResult);
    }
    
    @WorkerThread
    @Override
    public final void onConnectionSuspended(final int n) {
        ((Api.zze)this.zzaDh).disconnect();
    }
    
    @WorkerThread
    public final void zza(final zzbel zzaEX) {
        if (this.zzaDh != null) {
            ((Api.zze)this.zzaDh).disconnect();
        }
        if (this.zzaEW) {
            final GoogleSignInOptions zzmO = zzy.zzaj(this.mContext).zzmO();
            HashSet<Scope> zzame;
            if (zzmO == null) {
                zzame = new HashSet<Scope>();
            }
            else {
                zzame = new HashSet<Scope>(zzmO.zzmA());
            }
            this.zzame = zzame;
            this.zzaCA = new zzq(null, this.zzame, null, 0, null, null, null, zzctl.zzbCM);
        }
        this.zzaCA.zzc(System.identityHashCode(this));
        this.zzaDh = (zzctk)this.zzaAx.zza(this.mContext, this.mHandler.getLooper(), this.zzaCA, this.zzaCA.zzrt(), this, this);
        this.zzaEX = zzaEX;
        this.zzaDh.connect();
    }
    
    @BinderThread
    @Override
    public final void zzb(final zzctx zzctx) {
        this.mHandler.post((Runnable)new zzbek(this, zzctx));
    }
    
    public final void zzqI() {
        if (this.zzaDh != null) {
            ((Api.zze)this.zzaDh).disconnect();
        }
    }
    
    public final zzctk zzqy() {
        return this.zzaDh;
    }
}
