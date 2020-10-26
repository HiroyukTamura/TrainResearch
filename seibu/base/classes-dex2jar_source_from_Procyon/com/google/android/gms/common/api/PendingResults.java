// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzbbe;
import com.google.android.gms.internal.zzbec;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzben;
import android.os.Looper;

public final class PendingResults
{
    private PendingResults() {
    }
    
    public static PendingResult<Status> canceledPendingResult() {
        final zzben zzben = new zzben(Looper.getMainLooper());
        zzben.cancel();
        return zzben;
    }
    
    public static <R extends Result> PendingResult<R> canceledPendingResult(final R r) {
        zzbo.zzb(r, "Result must not be null");
        zzbo.zzb(r.getStatus().getStatusCode() == 16, (Object)"Status code must be CommonStatusCodes.CANCELED");
        final zza zza = new zza(r);
        zza.cancel();
        return (PendingResult<R>)zza;
    }
    
    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(final R result) {
        zzbo.zzb(result, "Result must not be null");
        final zzc<Result> zzc = new zzc<Result>((GoogleApiClient)null);
        zzc.setResult(result);
        return new zzbec<R>((PendingResult<R>)zzc);
    }
    
    public static PendingResult<Status> immediatePendingResult(final Status result) {
        zzbo.zzb(result, "Result must not be null");
        final zzben zzben = new zzben(Looper.getMainLooper());
        zzben.setResult(result);
        return zzben;
    }
    
    public static <R extends Result> PendingResult<R> zza(final R result, final GoogleApiClient googleApiClient) {
        zzbo.zzb(result, "Result must not be null");
        zzbo.zzb(!result.getStatus().isSuccess(), (Object)"Status code must not be SUCCESS");
        final zzb<R> zzb = new zzb<R>(googleApiClient, result);
        zzb.setResult(result);
        return zzb;
    }
    
    public static PendingResult<Status> zza(final Status result, final GoogleApiClient googleApiClient) {
        zzbo.zzb(result, "Result must not be null");
        final zzben zzben = new zzben(googleApiClient);
        zzben.setResult(result);
        return zzben;
    }
    
    public static <R extends Result> OptionalPendingResult<R> zzb(final R result, final GoogleApiClient googleApiClient) {
        zzbo.zzb(result, "Result must not be null");
        final zzc<Result> zzc = new zzc<Result>(googleApiClient);
        zzc.setResult(result);
        return new zzbec<R>((PendingResult<R>)zzc);
    }
    
    static final class zza<R extends Result> extends zzbbe<R>
    {
        private final R zzaBi;
        
        public zza(final R zzaBi) {
            super(Looper.getMainLooper());
            this.zzaBi = zzaBi;
        }
        
        @Override
        protected final R zzb(final Status status) {
            if (status.getStatusCode() != this.zzaBi.getStatus().getStatusCode()) {
                throw new UnsupportedOperationException("Creating failed results is not supported");
            }
            return this.zzaBi;
        }
    }
    
    static final class zzb<R extends Result> extends zzbbe<R>
    {
        private final R zzaBj;
        
        public zzb(final GoogleApiClient googleApiClient, final R zzaBj) {
            super(googleApiClient);
            this.zzaBj = zzaBj;
        }
        
        @Override
        protected final R zzb(final Status status) {
            return this.zzaBj;
        }
    }
    
    static final class zzc<R extends Result> extends zzbbe<R>
    {
        public zzc(final GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
        
        @Override
        protected final R zzb(final Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }
}
