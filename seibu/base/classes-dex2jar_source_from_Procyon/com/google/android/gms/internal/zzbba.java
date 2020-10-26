// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcelable;
import android.os.Bundle;
import android.content.DialogInterface;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicReference;
import android.content.DialogInterface$OnCancelListener;

public abstract class zzbba extends zzbds implements DialogInterface$OnCancelListener
{
    protected volatile boolean mStarted;
    protected final AtomicReference<zzbbb> zzaBN;
    private final Handler zzaBO;
    protected final GoogleApiAvailability zzaBd;
    
    protected zzbba(final zzbdt zzbdt) {
        this(zzbdt, GoogleApiAvailability.getInstance());
    }
    
    private zzbba(final zzbdt zzbdt, final GoogleApiAvailability zzaBd) {
        super(zzbdt);
        this.zzaBN = new AtomicReference<zzbbb>(null);
        this.zzaBO = new Handler(Looper.getMainLooper());
        this.zzaBd = zzaBd;
    }
    
    private static int zza(@Nullable final zzbbb zzbbb) {
        if (zzbbb == null) {
            return -1;
        }
        return zzbbb.zzpy();
    }
    
    @Override
    public final void onActivityResult(int intExtra, int n, final Intent intent) {
        final int n2 = 13;
        final zzbbb zzbbb = this.zzaBN.get();
        zzbbb newValue = null;
        Label_0045: {
            switch (intExtra) {
                case 2: {
                    final int googlePlayServicesAvailable = this.zzaBd.isGooglePlayServicesAvailable((Context)this.getActivity());
                    if (googlePlayServicesAvailable == 0) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (zzbbb == null) {
                        return;
                    }
                    newValue = zzbbb;
                    intExtra = n;
                    if (zzbbb.zzpz().getErrorCode() != 18) {
                        break Label_0045;
                    }
                    newValue = zzbbb;
                    intExtra = n;
                    if (googlePlayServicesAvailable == 18) {
                        return;
                    }
                    break Label_0045;
                }
                case 1: {
                    if (n == -1) {
                        intExtra = 1;
                        newValue = zzbbb;
                        break Label_0045;
                    }
                    if (n == 0) {
                        intExtra = n2;
                        if (intent != null) {
                            intExtra = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                        }
                        newValue = new zzbbb(new ConnectionResult(intExtra, null), zza(zzbbb));
                        this.zzaBN.set(newValue);
                        intExtra = 0;
                        break Label_0045;
                    }
                    break;
                }
            }
            intExtra = 0;
            newValue = zzbbb;
        }
        if (intExtra != 0) {
            this.zzpx();
        }
        else if (newValue != null) {
            this.zza(newValue.zzpz(), newValue.zzpy());
        }
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        this.zza(new ConnectionResult(13, null), zza(this.zzaBN.get()));
        this.zzpx();
    }
    
    @Override
    public final void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            final AtomicReference<zzbbb> zzaBN = this.zzaBN;
            zzbbb newValue;
            if (bundle.getBoolean("resolving_error", false)) {
                newValue = new zzbbb(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            }
            else {
                newValue = null;
            }
            zzaBN.set(newValue);
        }
    }
    
    @Override
    public final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final zzbbb zzbbb = this.zzaBN.get();
        if (zzbbb != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzbbb.zzpy());
            bundle.putInt("failed_status", zzbbb.zzpz().getErrorCode());
            bundle.putParcelable("failed_resolution", (Parcelable)zzbbb.zzpz().getResolution());
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }
    
    @Override
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }
    
    protected abstract void zza(final ConnectionResult p0, final int p1);
    
    public final void zzb(final ConnectionResult connectionResult, final int n) {
        final zzbbb newValue = new zzbbb(connectionResult, n);
        if (this.zzaBN.compareAndSet(null, newValue)) {
            this.zzaBO.post((Runnable)new zzbbc(this, newValue));
        }
    }
    
    protected abstract void zzps();
    
    protected final void zzpx() {
        this.zzaBN.set(null);
        this.zzps();
    }
}
