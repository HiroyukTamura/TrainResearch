// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.Result;

public final class zzbes<R extends Result> extends TransformedResult<R> implements ResultCallback<R>
{
    private final Object zzaBW;
    private final WeakReference<GoogleApiClient> zzaBY;
    private ResultTransform<? super R, ? extends Result> zzaFa;
    private zzbes<? extends Result> zzaFb;
    private volatile ResultCallbacks<? super R> zzaFc;
    private PendingResult<R> zzaFd;
    private Status zzaFe;
    private final zzbeu zzaFf;
    private boolean zzaFg;
    
    public zzbes(final WeakReference<GoogleApiClient> zzaBY) {
        this.zzaFa = null;
        this.zzaFb = null;
        this.zzaFc = null;
        this.zzaFd = null;
        this.zzaBW = new Object();
        this.zzaFe = null;
        this.zzaFg = false;
        zzbo.zzb(zzaBY, "GoogleApiClient reference must not be null");
        this.zzaBY = zzaBY;
        final GoogleApiClient googleApiClient = this.zzaBY.get();
        Looper looper;
        if (googleApiClient != null) {
            looper = googleApiClient.getLooper();
        }
        else {
            looper = Looper.getMainLooper();
        }
        this.zzaFf = new zzbeu(this, looper);
    }
    
    private static void zzc(final Result obj) {
        if (!(obj instanceof Releasable)) {
            return;
        }
        try {
            ((Releasable)obj).release();
        }
        catch (RuntimeException ex) {
            final String value = String.valueOf(obj);
            Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(value).length() + 18).append("Unable to release ").append(value).toString(), (Throwable)ex);
        }
    }
    
    private final void zzqJ() {
        if (this.zzaFa != null || this.zzaFc != null) {
            final GoogleApiClient googleApiClient = this.zzaBY.get();
            if (!this.zzaFg && this.zzaFa != null && googleApiClient != null) {
                googleApiClient.zza(this);
                this.zzaFg = true;
            }
            if (this.zzaFe != null) {
                this.zzw(this.zzaFe);
                return;
            }
            if (this.zzaFd != null) {
                this.zzaFd.setResultCallback(this);
            }
        }
    }
    
    private final boolean zzqL() {
        final GoogleApiClient googleApiClient = this.zzaBY.get();
        return this.zzaFc != null && googleApiClient != null;
    }
    
    private final void zzv(final Status zzaFe) {
        synchronized (this.zzaBW) {
            this.zzw(this.zzaFe = zzaFe);
        }
    }
    
    private final void zzw(Status onFailure) {
        synchronized (this.zzaBW) {
            if (this.zzaFa != null) {
                onFailure = this.zzaFa.onFailure(onFailure);
                zzbo.zzb(onFailure, "onFailure must not return null");
                this.zzaFb.zzv(onFailure);
            }
            else if (this.zzqL()) {
                this.zzaFc.onFailure(onFailure);
            }
        }
    }
    
    @Override
    public final void andFinally(@NonNull final ResultCallbacks<? super R> zzaFc) {
    Label_0035_Outer:
        while (true) {
            final boolean b = true;
            while (true) {
            Label_0065:
                while (true) {
                    synchronized (this.zzaBW) {
                        if (this.zzaFc == null) {
                            final boolean b2 = true;
                            zzbo.zza(b2, (Object)"Cannot call andFinally() twice.");
                            if (this.zzaFa == null) {
                                final boolean b3 = b;
                                zzbo.zza(b3, (Object)"Cannot call then() and andFinally() on the same TransformedResult.");
                                this.zzaFc = zzaFc;
                                this.zzqJ();
                                return;
                            }
                            break Label_0065;
                        }
                    }
                    final boolean b2 = false;
                    continue Label_0035_Outer;
                }
                final boolean b3 = false;
                continue;
            }
        }
    }
    
    @Override
    public final void onResult(final R r) {
        while (true) {
            synchronized (this.zzaBW) {
                if (r.getStatus().isSuccess()) {
                    if (this.zzaFa != null) {
                        zzbeg.zzqj().submit(new zzbet(this, r));
                    }
                    else if (this.zzqL()) {
                        this.zzaFc.onSuccess((Object)r);
                    }
                    return;
                }
            }
            final Result result;
            this.zzv(result.getStatus());
            zzc(result);
        }
    }
    
    @NonNull
    @Override
    public final <S extends Result> TransformedResult<S> then(@NonNull final ResultTransform<? super R, ? extends S> zzaFa) {
    Label_0035_Outer:
        while (true) {
            final boolean b = true;
            while (true) {
            Label_0083:
                while (true) {
                    synchronized (this.zzaBW) {
                        if (this.zzaFa == null) {
                            final boolean b2 = true;
                            zzbo.zza(b2, (Object)"Cannot call then() twice.");
                            if (this.zzaFc == null) {
                                final boolean b3 = b;
                                zzbo.zza(b3, (Object)"Cannot call then() and andFinally() on the same TransformedResult.");
                                this.zzaFa = zzaFa;
                                final zzbes<Result> zzaFb = new zzbes<Result>(this.zzaBY);
                                this.zzaFb = zzaFb;
                                this.zzqJ();
                                return (TransformedResult<S>)zzaFb;
                            }
                            break Label_0083;
                        }
                    }
                    final boolean b2 = false;
                    continue Label_0035_Outer;
                }
                final boolean b3 = false;
                continue;
            }
        }
    }
    
    public final void zza(final PendingResult<?> zzaFd) {
        synchronized (this.zzaBW) {
            this.zzaFd = (PendingResult<R>)zzaFd;
            this.zzqJ();
        }
    }
    
    final void zzqK() {
        this.zzaFc = null;
    }
}
