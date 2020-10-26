// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzbej;
import android.os.Handler;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzbdd;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.internal.zzbeq;
import com.google.android.gms.internal.zzbay;
import com.google.android.gms.internal.zzbas;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.zzbbw;
import com.google.android.gms.internal.zzbdj;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import android.app.Activity;
import android.os.Looper;
import android.accounts.Account;
import com.google.android.gms.internal.zzbdb;
import com.google.android.gms.internal.zzbem;
import com.google.android.gms.internal.zzbat;
import android.content.Context;

public class GoogleApi<O extends Api.ApiOptions>
{
    private final Context mContext;
    private final int mId;
    private final O zzaAJ;
    private final zzbat<O> zzaAK;
    private final GoogleApiClient zzaAL;
    private final zzbem zzaAM;
    protected final zzbdb zzaAN;
    private final Account zzajb;
    private final Api<O> zzayW;
    private final Looper zzrM;
    
    @MainThread
    private GoogleApi(@NonNull final Activity activity, final Api<O> zzayW, final O o, final zza zza) {
        zzbo.zzb(activity, "Null activity is not permitted.");
        zzbo.zzb(zzayW, "Api must not be null.");
        zzbo.zzb(zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.zzayW = zzayW;
        this.zzaAJ = null;
        this.zzrM = zza.zzaAQ;
        this.zzaAK = zzbat.zza(this.zzayW, this.zzaAJ);
        this.zzaAL = new zzbdj<Object>(this);
        this.zzaAN = zzbdb.zzay(this.mContext);
        this.mId = this.zzaAN.zzqm();
        this.zzaAM = zza.zzaAP;
        this.zzajb = zza.account;
        zzbbw.zza(activity, this.zzaAN, this.zzaAK);
        this.zzaAN.zzb(this);
    }
    
    @Deprecated
    public GoogleApi(@NonNull final Activity activity, final Api<O> api, final O o, final zzbem zzbem) {
        this(activity, (Api<Api.ApiOptions>)api, null, new zzd().zza(zzbem).zza(activity.getMainLooper()).zzpj());
    }
    
    protected GoogleApi(@NonNull final Context context, final Api<O> zzayW, final Looper zzrM) {
        zzbo.zzb(context, "Null context is not permitted.");
        zzbo.zzb(zzayW, "Api must not be null.");
        zzbo.zzb(zzrM, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzayW = zzayW;
        this.zzaAJ = null;
        this.zzrM = zzrM;
        this.zzaAK = zzbat.zzb(zzayW);
        this.zzaAL = new zzbdj<Object>(this);
        this.zzaAN = zzbdb.zzay(this.mContext);
        this.mId = this.zzaAN.zzqm();
        this.zzaAM = new zzbas();
        this.zzajb = null;
    }
    
    @Deprecated
    public GoogleApi(@NonNull final Context context, final Api<O> api, final O o, final Looper looper, final zzbem zzbem) {
        this(context, (Api<Api.ApiOptions>)api, null, new zzd().zza(looper).zza(zzbem).zzpj());
    }
    
    public GoogleApi(@NonNull final Context context, final Api<O> zzayW, final O zzaAJ, final zza zza) {
        zzbo.zzb(context, "Null context is not permitted.");
        zzbo.zzb(zzayW, "Api must not be null.");
        zzbo.zzb(zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zzayW = zzayW;
        this.zzaAJ = zzaAJ;
        this.zzrM = zza.zzaAQ;
        this.zzaAK = zzbat.zza(this.zzayW, this.zzaAJ);
        this.zzaAL = new zzbdj<Object>(this);
        this.zzaAN = zzbdb.zzay(this.mContext);
        this.mId = this.zzaAN.zzqm();
        this.zzaAM = zza.zzaAP;
        this.zzajb = zza.account;
        this.zzaAN.zzb(this);
    }
    
    @Deprecated
    public GoogleApi(@NonNull final Context context, final Api<O> api, final O o, final zzbem zzbem) {
        this(context, (Api<Api.ApiOptions>)api, o, new zzd().zza(zzbem).zzpj());
    }
    
    private final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zza(final int n, @NonNull final T t) {
        t.zzpC();
        this.zzaAN.zza((GoogleApi<Api.ApiOptions>)this, n, (zzbay<? extends Result, Api.zzb>)t);
        return t;
    }
    
    private final <TResult, A extends Api.zzb> Task<TResult> zza(final int n, @NonNull final zzbeq<A, TResult> zzbeq) {
        final TaskCompletionSource<TResult> taskCompletionSource = new TaskCompletionSource<TResult>();
        this.zzaAN.zza((GoogleApi<Api.ApiOptions>)this, n, (zzbeq<Api.zzb, TResult>)zzbeq, taskCompletionSource, this.zzaAM);
        return taskCompletionSource.getTask();
    }
    
    public final Context getApplicationContext() {
        return this.mContext;
    }
    
    public final int getInstanceId() {
        return this.mId;
    }
    
    public final Looper getLooper() {
        return this.zzrM;
    }
    
    @WorkerThread
    public Api.zze zza(final Looper looper, final zzbdd<O> zzbdd) {
        return (Api.zze)this.zzayW.zzpc().zza(this.mContext, looper, new GoogleApiClient.Builder(this.mContext).zze(this.zzajb).zzpn(), this.zzaAJ, zzbdd, zzbdd);
    }
    
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zza(@NonNull final T t) {
        return this.zza(0, t);
    }
    
    public zzbej zza(final Context context, final Handler handler) {
        return new zzbej(context, handler);
    }
    
    public final <TResult, A extends Api.zzb> Task<TResult> zza(final zzbeq<A, TResult> zzbeq) {
        return this.zza(0, zzbeq);
    }
    
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zzb(@NonNull final T t) {
        return this.zza(1, t);
    }
    
    public final <TResult, A extends Api.zzb> Task<TResult> zzb(final zzbeq<A, TResult> zzbeq) {
        return this.zza(1, zzbeq);
    }
    
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zzc(@NonNull final T t) {
        return this.zza(2, t);
    }
    
    public final Api<O> zzpg() {
        return this.zzayW;
    }
    
    public final zzbat<O> zzph() {
        return this.zzaAK;
    }
    
    public final GoogleApiClient zzpi() {
        return this.zzaAL;
    }
    
    public static final class zza
    {
        public static final zza zzaAO;
        public final Account account;
        public final zzbem zzaAP;
        public final Looper zzaAQ;
        
        static {
            zzaAO = new zzd().zzpj();
        }
        
        private zza(final zzbem zzaAP, final Account account, final Looper zzaAQ) {
            this.zzaAP = zzaAP;
            this.account = account;
            this.zzaAQ = zzaAQ;
        }
    }
}
