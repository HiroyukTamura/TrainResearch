// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.common.api.Status;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import android.support.annotation.Nullable;
import android.app.PendingIntent;
import com.google.android.gms.common.api.Result;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import java.util.Iterator;
import android.support.v4.util.ArrayMap;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zze;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;
import java.util.Set;
import com.google.android.gms.common.api.Api;
import java.util.Map;
import android.content.Context;

final class zzbbk implements zzbdp
{
    private final Context mContext;
    private final zzbcp zzaCl;
    private final zzbcx zzaCm;
    private final zzbcx zzaCn;
    private final Map<Api.zzc<?>, zzbcx> zzaCo;
    private final Set<zzbei> zzaCp;
    private final Api.zze zzaCq;
    private Bundle zzaCr;
    private ConnectionResult zzaCs;
    private ConnectionResult zzaCt;
    private boolean zzaCu;
    private final Lock zzaCv;
    private int zzaCw;
    private final Looper zzrM;
    
    private zzbbk(final Context mContext, final zzbcp zzaCl, final Lock zzaCv, final Looper zzrM, final zze zze, final Map<Api.zzc<?>, Api.zze> map, final Map<Api.zzc<?>, Api.zze> map2, final zzq zzq, final Api.zza<? extends zzctk, zzctl> zza, final Api.zze zzaCq, final ArrayList<zzbbi> list, final ArrayList<zzbbi> list2, final Map<Api<?>, Boolean> map3, final Map<Api<?>, Boolean> map4) {
        this.zzaCp = Collections.newSetFromMap(new WeakHashMap<zzbei, Boolean>());
        this.zzaCs = null;
        this.zzaCt = null;
        this.zzaCu = false;
        this.zzaCw = 0;
        this.mContext = mContext;
        this.zzaCl = zzaCl;
        this.zzaCv = zzaCv;
        this.zzrM = zzrM;
        this.zzaCq = zzaCq;
        this.zzaCm = new zzbcx(mContext, this.zzaCl, zzaCv, zzrM, zze, map2, null, map4, null, list2, new zzbbm(this, null));
        this.zzaCn = new zzbcx(mContext, this.zzaCl, zzaCv, zzrM, zze, map, zzq, map3, zza, list, new zzbbn(this, null));
        final ArrayMap<Api.zzc<?>, zzbcx> m = new ArrayMap<Api.zzc<?>, zzbcx>();
        final Iterator<Api.zzc<?>> iterator = map2.keySet().iterator();
        while (iterator.hasNext()) {
            m.put((Api.zzc<?>)iterator.next(), this.zzaCm);
        }
        final Iterator<Api.zzc<?>> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            m.put((Api.zzc<?>)iterator2.next(), this.zzaCn);
        }
        this.zzaCo = (Map<Api.zzc<?>, zzbcx>)Collections.unmodifiableMap((Map<?, ?>)m);
    }
    
    public static zzbbk zza(final Context context, final zzbcp zzbcp, final Lock lock, final Looper looper, final zze zze, final Map<Api.zzc<?>, Api.zze> map, final zzq zzq, final Map<Api<?>, Boolean> map2, final Api.zza<? extends zzctk, zzctl> zza, final ArrayList<zzbbi> list) {
        final Api.zze zze2 = null;
        final ArrayMap<Api.zzc, Api.zze> arrayMap = new ArrayMap<Api.zzc, Api.zze>();
        final ArrayMap arrayMap2 = new ArrayMap<Api.zzc<?>, Api.zze>();
        final Iterator<Map.Entry<Api.zzc<?>, Api.zze>> iterator = map.entrySet().iterator();
        Api.zze zze3 = zze2;
        while (iterator.hasNext()) {
            final Map.Entry<Api.zzc<?>, Api.zze> entry = iterator.next();
            final Api.zze zze4 = entry.getValue();
            if (zze4.zzmG()) {
                zze3 = zze4;
            }
            if (zze4.zzmv()) {
                arrayMap.put((Api.zzc)entry.getKey(), zze4);
            }
            else {
                arrayMap2.put(entry.getKey(), zze4);
            }
        }
        zzbo.zza(!arrayMap.isEmpty(), (Object)"CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        final ArrayMap<Api<?>, Boolean> arrayMap3 = new ArrayMap<Api<?>, Boolean>();
        final ArrayMap<Api<?>, Boolean> arrayMap4 = new ArrayMap<Api<?>, Boolean>();
        for (final Api<?> api : map2.keySet()) {
            final Api.zzc<?> zzpd = api.zzpd();
            if (arrayMap.containsKey(zzpd)) {
                arrayMap3.put(api, map2.get(api));
            }
            else {
                if (!arrayMap2.containsKey(zzpd)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, map2.get(api));
            }
        }
        final ArrayList<zzbbi> list2 = new ArrayList<zzbbi>();
        final ArrayList<zzbbi> list3 = new ArrayList<zzbbi>();
        final ArrayList<zzbbi> list4 = list;
        final int size = list4.size();
        int i = 0;
        while (i < size) {
            final zzbbi value = list4.get(i);
            ++i;
            final zzbbi zzbbi = value;
            if (arrayMap3.containsKey(zzbbi.zzayW)) {
                list2.add(zzbbi);
            }
            else {
                if (!arrayMap4.containsKey(zzbbi.zzayW)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                list3.add(zzbbi);
            }
        }
        return new zzbbk(context, zzbcp, lock, looper, zze, (Map<Api.zzc<?>, Api.zze>)arrayMap, arrayMap2, zzq, zza, zze3, list2, list3, arrayMap3, arrayMap4);
    }
    
    private final void zza(final ConnectionResult connectionResult) {
        switch (this.zzaCw) {
            default: {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new Exception());
                break;
            }
            case 2: {
                this.zzaCl.zzc(connectionResult);
            }
            case 1: {
                this.zzpG();
                break;
            }
        }
        this.zzaCw = 0;
    }
    
    private static boolean zzb(final ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }
    
    private final void zzd(final int n, final boolean b) {
        this.zzaCl.zze(n, b);
        this.zzaCt = null;
        this.zzaCs = null;
    }
    
    private final boolean zzf(final zzbay<? extends Result, ? extends Api.zzb> zzbay) {
        final Api.zzc<? extends Api.zzb> zzpd = zzbay.zzpd();
        zzbo.zzb(this.zzaCo.containsKey(zzpd), (Object)"GoogleApiClient is not configured to use the API required for this call.");
        return this.zzaCo.get(zzpd).equals(this.zzaCn);
    }
    
    private final void zzl(final Bundle zzaCr) {
        if (this.zzaCr == null) {
            this.zzaCr = zzaCr;
        }
        else if (zzaCr != null) {
            this.zzaCr.putAll(zzaCr);
        }
    }
    
    private final void zzpF() {
        if (zzb(this.zzaCs)) {
            if (zzb(this.zzaCt) || this.zzpH()) {
                switch (this.zzaCw) {
                    default: {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", (Throwable)new AssertionError());
                        break;
                    }
                    case 2: {
                        this.zzaCl.zzm(this.zzaCr);
                    }
                    case 1: {
                        this.zzpG();
                        break;
                    }
                }
                this.zzaCw = 0;
            }
            else if (this.zzaCt != null) {
                if (this.zzaCw == 1) {
                    this.zzpG();
                    return;
                }
                this.zza(this.zzaCt);
                this.zzaCm.disconnect();
            }
        }
        else {
            if (this.zzaCs != null && zzb(this.zzaCt)) {
                this.zzaCn.disconnect();
                this.zza(this.zzaCs);
                return;
            }
            if (this.zzaCs != null && this.zzaCt != null) {
                ConnectionResult connectionResult = this.zzaCs;
                if (this.zzaCn.zzaDX < this.zzaCm.zzaDX) {
                    connectionResult = this.zzaCt;
                }
                this.zza(connectionResult);
            }
        }
    }
    
    private final void zzpG() {
        final Iterator<zzbei> iterator = this.zzaCp.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzmF();
        }
        this.zzaCp.clear();
    }
    
    private final boolean zzpH() {
        return this.zzaCt != null && this.zzaCt.getErrorCode() == 4;
    }
    
    @Nullable
    private final PendingIntent zzpI() {
        if (this.zzaCq == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzaCl), this.zzaCq.zzmH(), 134217728);
    }
    
    @Override
    public final ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final ConnectionResult blockingConnect(final long n, @NonNull final TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final void connect() {
        this.zzaCw = 2;
        this.zzaCu = false;
        this.zzaCt = null;
        this.zzaCs = null;
        this.zzaCm.connect();
        this.zzaCn.connect();
    }
    
    @Override
    public final void disconnect() {
        this.zzaCt = null;
        this.zzaCs = null;
        this.zzaCw = 0;
        this.zzaCm.disconnect();
        this.zzaCn.disconnect();
        this.zzpG();
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.append(s).append("authClient").println(":");
        this.zzaCn.dump(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
        printWriter.append(s).append("anonClient").println(":");
        this.zzaCm.dump(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
    }
    
    @Nullable
    @Override
    public final ConnectionResult getConnectionResult(@NonNull final Api<?> api) {
        if (!this.zzaCo.get(api.zzpd()).equals(this.zzaCn)) {
            return this.zzaCm.getConnectionResult(api);
        }
        if (this.zzpH()) {
            return new ConnectionResult(4, this.zzpI());
        }
        return this.zzaCn.getConnectionResult(api);
    }
    
    @Override
    public final boolean isConnected() {
        final boolean b = true;
        this.zzaCv.lock();
        try {
            if (!this.zzaCm.isConnected()) {
                return false;
            }
            boolean b2 = b;
            if (!this.zzaCn.isConnected()) {
                b2 = b;
                if (!this.zzpH()) {
                    if (this.zzaCw != 1) {
                        return false;
                    }
                    b2 = b;
                }
            }
            return b2;
            b2 = false;
            return b2;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final boolean isConnecting() {
        this.zzaCv.lock();
        try {
            return this.zzaCw == 2;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final boolean zza(final zzbei zzbei) {
        this.zzaCv.lock();
        try {
            if ((this.isConnecting() || this.isConnected()) && !this.zzaCn.isConnected()) {
                this.zzaCp.add(zzbei);
                if (this.zzaCw == 0) {
                    this.zzaCw = 1;
                }
                this.zzaCt = null;
                this.zzaCn.connect();
                return true;
            }
            return false;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T t) {
        if (!this.zzf(t)) {
            return this.zzaCm.zzd(t);
        }
        if (this.zzpH()) {
            t.zzr(new Status(4, null, this.zzpI()));
            return t;
        }
        return this.zzaCn.zzd(t);
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        if (!this.zzf(t)) {
            return this.zzaCm.zze(t);
        }
        if (this.zzpH()) {
            t.zzr(new Status(4, null, this.zzpI()));
            return t;
        }
        return this.zzaCn.zze(t);
    }
    
    @Override
    public final void zzpE() {
        this.zzaCm.zzpE();
        this.zzaCn.zzpE();
    }
    
    @Override
    public final void zzpl() {
        this.zzaCv.lock();
        try {
            final boolean connecting = this.isConnecting();
            this.zzaCn.disconnect();
            this.zzaCt = new ConnectionResult(4);
            if (connecting) {
                new Handler(this.zzrM).post((Runnable)new zzbbl(this));
            }
            else {
                this.zzpG();
            }
        }
        finally {
            this.zzaCv.unlock();
        }
    }
}
