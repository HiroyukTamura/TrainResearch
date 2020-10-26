// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collection;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.Api;
import android.support.annotation.NonNull;
import android.app.PendingIntent;
import android.app.Application;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import android.os.Message;
import java.util.Iterator;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApi;
import android.os.HandlerThread;
import com.google.android.gms.common.util.zza;
import java.util.concurrent.ConcurrentHashMap;
import android.os.Looper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import com.google.android.gms.common.GoogleApiAvailability;
import android.os.Handler;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import android.os.Handler$Callback;

public final class zzbdb implements Handler$Callback
{
    public static final Status zzaEc;
    private static final Status zzaEd;
    private static zzbdb zzaEf;
    private static final Object zzuF;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability zzaBd;
    private final Map<zzbat<?>, zzbdd<?>> zzaCB;
    private long zzaDB;
    private long zzaDC;
    private long zzaEe;
    private int zzaEg;
    private final AtomicInteger zzaEh;
    private final AtomicInteger zzaEi;
    private zzbbw zzaEj;
    private final Set<zzbat<?>> zzaEk;
    private final Set<zzbat<?>> zzaEl;
    
    static {
        zzaEc = new Status(4, "Sign-out occurred while this API call was in progress.");
        zzaEd = new Status(4, "The user must be signed in to make this API call.");
        zzuF = new Object();
    }
    
    private zzbdb(final Context mContext, final Looper looper, final GoogleApiAvailability zzaBd) {
        this.zzaDC = 5000L;
        this.zzaDB = 120000L;
        this.zzaEe = 10000L;
        this.zzaEg = -1;
        this.zzaEh = new AtomicInteger(1);
        this.zzaEi = new AtomicInteger(0);
        this.zzaCB = new ConcurrentHashMap<zzbat<?>, zzbdd<?>>(5, 0.75f, 1);
        this.zzaEj = null;
        this.zzaEk = new zza<zzbat<?>>();
        this.zzaEl = new zza<zzbat<?>>();
        this.mContext = mContext;
        this.mHandler = new Handler(looper, (Handler$Callback)this);
        this.zzaBd = zzaBd;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
    }
    
    public static zzbdb zzay(final Context context) {
        synchronized (zzbdb.zzuF) {
            if (zzbdb.zzaEf == null) {
                final HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zzbdb.zzaEf = new zzbdb(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            return zzbdb.zzaEf;
        }
    }
    
    @WorkerThread
    private final void zzc(final GoogleApi<?> googleApi) {
        final zzbat<O> zzph = googleApi.zzph();
        zzbdd<?> zzbdd;
        if ((zzbdd = this.zzaCB.get(zzph)) == null) {
            zzbdd = new zzbdd<Object>(googleApi);
            this.zzaCB.put(zzph, zzbdd);
        }
        if (zzbdd.zzmv()) {
            this.zzaEl.add(zzph);
        }
        zzbdd.connect();
    }
    
    public static zzbdb zzqk() {
        synchronized (zzbdb.zzuF) {
            zzbo.zzb(zzbdb.zzaEf, "Must guarantee manager is non-null before using getInstance");
            return zzbdb.zzaEf;
        }
    }
    
    public static void zzql() {
        synchronized (zzbdb.zzuF) {
            if (zzbdb.zzaEf != null) {
                final zzbdb zzaEf = zzbdb.zzaEf;
                zzaEf.zzaEi.incrementAndGet();
                zzaEf.mHandler.sendMessageAtFrontOfQueue(zzaEf.mHandler.obtainMessage(10));
            }
        }
    }
    
    @WorkerThread
    private final void zzqn() {
        final Iterator<zzbat<?>> iterator = this.zzaEl.iterator();
        while (iterator.hasNext()) {
            this.zzaCB.remove(iterator.next()).signOut();
        }
        this.zzaEl.clear();
    }
    
    @WorkerThread
    public final boolean handleMessage(final Message message) {
        Label_0284: {
            switch (message.what) {
                default: {
                    Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    return false;
                }
                case 1: {
                    long zzaEe;
                    if (message.obj) {
                        zzaEe = 10000L;
                    }
                    else {
                        zzaEe = 300000L;
                    }
                    this.zzaEe = zzaEe;
                    this.mHandler.removeMessages(12);
                    final Iterator<zzbat<?>> iterator = this.zzaCB.keySet().iterator();
                    while (iterator.hasNext()) {
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, (Object)iterator.next()), this.zzaEe);
                    }
                    break;
                }
                case 2: {
                    final zzbav zzbav = (zzbav)message.obj;
                    for (final zzbat<?> zzbat : zzbav.zzpt()) {
                        final zzbdd<?> zzbdd = this.zzaCB.get(zzbat);
                        if (zzbdd == null) {
                            zzbav.zza(zzbat, new ConnectionResult(13));
                            break;
                        }
                        if (zzbdd.isConnected()) {
                            zzbav.zza(zzbat, ConnectionResult.zzazX);
                        }
                        else if (zzbdd.zzqu() != null) {
                            zzbav.zza(zzbat, zzbdd.zzqu());
                        }
                        else {
                            zzbdd.zza(zzbav);
                        }
                    }
                    break;
                }
                case 3: {
                    for (final zzbdd<?> zzbdd2 : this.zzaCB.values()) {
                        zzbdd2.zzqt();
                        zzbdd2.connect();
                    }
                    break;
                }
                case 4:
                case 8:
                case 13: {
                    final zzbed zzbed = (zzbed)message.obj;
                    zzbdd<?> zzbdd3;
                    if ((zzbdd3 = this.zzaCB.get(zzbed.zzaET.zzph())) == null) {
                        this.zzc(zzbed.zzaET);
                        zzbdd3 = this.zzaCB.get(zzbed.zzaET.zzph());
                    }
                    if (zzbdd3.zzmv() && this.zzaEi.get() != zzbed.zzaES) {
                        zzbed.zzaER.zzp(zzbdb.zzaEc);
                        zzbdd3.signOut();
                        break;
                    }
                    zzbdd3.zza(zzbed.zzaER);
                    break;
                }
                case 5: {
                    final int arg1 = message.arg1;
                    final ConnectionResult connectionResult = (ConnectionResult)message.obj;
                    while (true) {
                        for (final zzbdd<?> zzbdd4 : this.zzaCB.values()) {
                            if (zzbdd4.getInstanceId() == arg1) {
                                if (zzbdd4 != null) {
                                    final String value = String.valueOf(this.zzaBd.getErrorString(connectionResult.getErrorCode()));
                                    final String value2 = String.valueOf(connectionResult.getErrorMessage());
                                    zzbdd4.zzt(new Status(17, new StringBuilder(String.valueOf(value).length() + 69 + String.valueOf(value2).length()).append("Error resolution was canceled by the user, original error message: ").append(value).append(": ").append(value2).toString()));
                                    break Label_0284;
                                }
                                Log.wtf("GoogleApiManager", new StringBuilder(76).append("Could not find API instance ").append(arg1).append(" while trying to fail enqueued calls.").toString(), (Throwable)new Exception());
                                break Label_0284;
                            }
                        }
                        zzbdd<?> zzbdd4 = null;
                        continue;
                    }
                }
                case 6: {
                    if (!(this.mContext.getApplicationContext() instanceof Application)) {
                        break;
                    }
                    zzbaw.zza((Application)this.mContext.getApplicationContext());
                    zzbaw.zzpv().zza(new zzbdc(this));
                    if (!zzbaw.zzpv().zzab(true)) {
                        this.zzaEe = 300000L;
                        break;
                    }
                    break;
                }
                case 7: {
                    this.zzc((GoogleApi<?>)message.obj);
                    break;
                }
                case 9: {
                    if (this.zzaCB.containsKey(message.obj)) {
                        this.zzaCB.get(message.obj).resume();
                        break;
                    }
                    break;
                }
                case 10: {
                    this.zzqn();
                    break;
                }
                case 11: {
                    if (this.zzaCB.containsKey(message.obj)) {
                        this.zzaCB.get(message.obj).zzqd();
                        break;
                    }
                    break;
                }
                case 12: {
                    if (this.zzaCB.containsKey(message.obj)) {
                        this.zzaCB.get(message.obj).zzqx();
                        break;
                    }
                    break;
                }
            }
        }
        return true;
    }
    
    final PendingIntent zza(final zzbat<?> zzbat, final int n) {
        final zzbdd<?> zzbdd = this.zzaCB.get(zzbat);
        if (zzbdd == null) {
            return null;
        }
        final zzctk zzqy = zzbdd.zzqy();
        if (zzqy == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, n, ((Api.zze)zzqy).zzmH(), 134217728);
    }
    
    public final <O extends Api.ApiOptions> Task<Void> zza(@NonNull final GoogleApi<O> googleApi, @NonNull final zzbdy<?> zzbdy) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<Void>();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13, (Object)new zzbed(new zzbar(zzbdy, taskCompletionSource), this.zzaEi.get(), googleApi)));
        return taskCompletionSource.getTask();
    }
    
    public final <O extends Api.ApiOptions> Task<Void> zza(@NonNull final GoogleApi<O> googleApi, @NonNull final zzbee<Api.zzb, ?> zzbee, @NonNull final zzbey<Api.zzb, ?> zzbey) {
        final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<Void>();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(8, (Object)new zzbed(new zzbap(new zzbef(zzbee, zzbey), taskCompletionSource), this.zzaEi.get(), googleApi)));
        return taskCompletionSource.getTask();
    }
    
    public final Task<Void> zza(final Iterable<? extends GoogleApi<?>> iterable) {
        final zzbav zzbav = new zzbav(iterable);
        final Iterator<? extends GoogleApi<?>> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            final zzbdd<?> zzbdd = this.zzaCB.get(((GoogleApi)iterator.next()).zzph());
            if (zzbdd == null || !zzbdd.isConnected()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, (Object)zzbav));
                return zzbav.getTask();
            }
        }
        zzbav.zzpu();
        return zzbav.getTask();
    }
    
    public final void zza(final ConnectionResult connectionResult, final int n) {
        if (!this.zzc(connectionResult, n)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, n, 0, (Object)connectionResult));
        }
    }
    
    public final <O extends Api.ApiOptions> void zza(final GoogleApi<O> googleApi, final int n, final zzbay<? extends Result, Api.zzb> zzbay) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, (Object)new zzbed(new zzbao<Object>(n, zzbay), this.zzaEi.get(), googleApi)));
    }
    
    public final <O extends Api.ApiOptions, TResult> void zza(final GoogleApi<O> googleApi, final int n, final zzbeq<Api.zzb, TResult> zzbeq, final TaskCompletionSource<TResult> taskCompletionSource, final zzbem zzbem) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, (Object)new zzbed(new zzbaq<Object>(n, zzbeq, taskCompletionSource, zzbem), this.zzaEi.get(), googleApi)));
    }
    
    public final void zza(@NonNull final zzbbw zzaEj) {
        synchronized (zzbdb.zzuF) {
            if (this.zzaEj != zzaEj) {
                this.zzaEj = zzaEj;
                this.zzaEk.clear();
                this.zzaEk.addAll(zzaEj.zzpR());
            }
        }
    }
    
    public final void zzb(final GoogleApi<?> googleApi) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, (Object)googleApi));
    }
    
    final void zzb(@NonNull final zzbbw zzbbw) {
        synchronized (zzbdb.zzuF) {
            if (this.zzaEj == zzbbw) {
                this.zzaEj = null;
                this.zzaEk.clear();
            }
        }
    }
    
    final boolean zzc(final ConnectionResult connectionResult, final int n) {
        return this.zzaBd.zza(this.mContext, connectionResult, n);
    }
    
    final void zzpl() {
        this.zzaEi.incrementAndGet();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
    }
    
    public final void zzps() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }
    
    public final int zzqm() {
        return this.zzaEh.getAndIncrement();
    }
}
