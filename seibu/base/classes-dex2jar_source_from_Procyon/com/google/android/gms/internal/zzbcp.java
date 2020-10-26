// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.Writer;
import java.io.StringWriter;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.app.PendingIntent;
import android.util.Log;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.api.PendingResult;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ResultCallback;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzad;
import java.util.ArrayList;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.Queue;
import java.util.Map;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.GoogleApiAvailability;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzbcp extends GoogleApiClient implements zzbdq
{
    private final Context mContext;
    private final int zzaBb;
    private final GoogleApiAvailability zzaBd;
    private Api.zza<? extends zzctk, zzctl> zzaBe;
    private boolean zzaBh;
    private zzq zzaCA;
    private Map<Api<?>, Boolean> zzaCD;
    final Queue<zzbay<?, ?>> zzaCJ;
    private final Lock zzaCv;
    private volatile boolean zzaDA;
    private long zzaDB;
    private long zzaDC;
    private final zzbcu zzaDD;
    private zzbdk zzaDE;
    final Map<Api.zzc<?>, Api.zze> zzaDF;
    Set<Scope> zzaDG;
    private final zzbea zzaDH;
    private final ArrayList<zzbbi> zzaDI;
    private Integer zzaDJ;
    Set<zzbes> zzaDK;
    final zzbev zzaDL;
    private final zzad zzaDM;
    private final zzac zzaDy;
    private zzbdp zzaDz;
    private final Looper zzrM;
    
    public zzbcp(final Context mContext, final Lock zzaCv, final Looper zzrM, final zzq zzaCA, final GoogleApiAvailability zzaBd, final Api.zza<? extends zzctk, zzctl> zzaBe, final Map<Api<?>, Boolean> zzaCD, final List<ConnectionCallbacks> list, final List<OnConnectionFailedListener> list2, final Map<Api.zzc<?>, Api.zze> zzaDF, final int zzaBb, final int i, final ArrayList<zzbbi> zzaDI, final boolean b) {
        this.zzaDz = null;
        this.zzaCJ = new LinkedList<zzbay<?, ?>>();
        this.zzaDB = 120000L;
        this.zzaDC = 5000L;
        this.zzaDG = new HashSet<Scope>();
        this.zzaDH = new zzbea();
        this.zzaDJ = null;
        this.zzaDK = null;
        this.zzaDM = new zzbcq(this);
        this.mContext = mContext;
        this.zzaCv = zzaCv;
        this.zzaBh = false;
        this.zzaDy = new zzac(zzrM, this.zzaDM);
        this.zzrM = zzrM;
        this.zzaDD = new zzbcu(this, zzrM);
        this.zzaBd = zzaBd;
        this.zzaBb = zzaBb;
        if (this.zzaBb >= 0) {
            this.zzaDJ = i;
        }
        this.zzaCD = zzaCD;
        this.zzaDF = zzaDF;
        this.zzaDI = zzaDI;
        this.zzaDL = new zzbev(this.zzaDF);
        final Iterator<ConnectionCallbacks> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.zzaDy.registerConnectionCallbacks(iterator.next());
        }
        final Iterator<OnConnectionFailedListener> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            this.zzaDy.registerConnectionFailedListener(iterator2.next());
        }
        this.zzaCA = zzaCA;
        this.zzaBe = zzaBe;
    }
    
    private final void resume() {
        this.zzaCv.lock();
        try {
            if (this.zzaDA) {
                this.zzqc();
            }
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    public static int zza(final Iterable<Api.zze> iterable, final boolean b) {
        final boolean b2 = true;
        final Iterator<Api.zze> iterator = iterable.iterator();
        boolean b3 = false;
        boolean b4 = false;
        while (iterator.hasNext()) {
            final Api.zze zze = iterator.next();
            if (zze.zzmv()) {
                b4 = true;
            }
            if (zze.zzmG()) {
                b3 = true;
            }
        }
        if (b4) {
            int n = b2 ? 1 : 0;
            if (b3) {
                n = (b2 ? 1 : 0);
                if (b) {
                    n = 2;
                }
            }
            return n;
        }
        return 3;
    }
    
    private final void zza(final GoogleApiClient googleApiClient, final zzben zzben, final boolean b) {
        zzbfo.zzaIy.zzd(googleApiClient).setResultCallback(new zzbct(this, zzben, b, googleApiClient));
    }
    
    private final void zzap(int i) {
        if (this.zzaDJ == null) {
            this.zzaDJ = i;
        }
        else if (this.zzaDJ != i) {
            final String value = String.valueOf(zzaq(i));
            final String value2 = String.valueOf(zzaq(this.zzaDJ));
            throw new IllegalStateException(new StringBuilder(String.valueOf(value).length() + 51 + String.valueOf(value2).length()).append("Cannot use sign-in mode: ").append(value).append(". Mode was already set to ").append(value2).toString());
        }
        if (this.zzaDz != null) {
            return;
        }
        final Iterator<Api.zze> iterator = this.zzaDF.values().iterator();
        i = 0;
        boolean b = false;
        while (iterator.hasNext()) {
            final Api.zze zze = iterator.next();
            if (zze.zzmv()) {
                b = true;
            }
            if (zze.zzmG()) {
                i = 1;
            }
        }
        switch (this.zzaDJ) {
            case 1: {
                if (!b) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (i != 0) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            }
            case 2: {
                if (!b) {
                    break;
                }
                if (this.zzaBh) {
                    this.zzaDz = new zzbbp(this.mContext, this.zzaCv, this.zzrM, this.zzaBd, this.zzaDF, this.zzaCA, this.zzaCD, this.zzaBe, this.zzaDI, this, true);
                    return;
                }
                this.zzaDz = zzbbk.zza(this.mContext, this, this.zzaCv, this.zzrM, this.zzaBd, this.zzaDF, this.zzaCA, this.zzaCD, this.zzaBe, this.zzaDI);
                return;
            }
        }
        if (this.zzaBh && i == 0) {
            this.zzaDz = new zzbbp(this.mContext, this.zzaCv, this.zzrM, this.zzaBd, this.zzaDF, this.zzaCA, this.zzaCD, this.zzaBe, this.zzaDI, this, false);
            return;
        }
        this.zzaDz = new zzbcx(this.mContext, this, this.zzaCv, this.zzrM, this.zzaBd, this.zzaDF, this.zzaCA, this.zzaCD, this.zzaBe, this.zzaDI, this);
    }
    
    private static String zzaq(final int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 3: {
                return "SIGN_IN_MODE_NONE";
            }
            case 1: {
                return "SIGN_IN_MODE_REQUIRED";
            }
            case 2: {
                return "SIGN_IN_MODE_OPTIONAL";
            }
        }
    }
    
    private final void zzqc() {
        this.zzaDy.zzrA();
        this.zzaDz.connect();
    }
    
    private final void zzqd() {
        this.zzaCv.lock();
        try {
            if (this.zzqe()) {
                this.zzqc();
            }
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final ConnectionResult blockingConnect() {
        final boolean b = true;
        Label_0091: {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                break Label_0091;
            }
            boolean b2 = true;
        Label_0052_Outer:
            while (true) {
                zzbo.zza(b2, (Object)"blockingConnect must not be called on the UI thread");
                this.zzaCv.lock();
                while (true) {
                    Label_0143: {
                        try {
                            if (this.zzaBb >= 0) {
                                b2 = (this.zzaDJ != null && b);
                                zzbo.zza(b2, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
                            }
                            else {
                                if (this.zzaDJ != null) {
                                    break Label_0143;
                                }
                                this.zzaDJ = zza(this.zzaDF.values(), false);
                            }
                            this.zzap(this.zzaDJ);
                            this.zzaDy.zzrA();
                            return this.zzaDz.blockingConnect();
                            b2 = false;
                            continue Label_0052_Outer;
                        }
                        finally {
                            this.zzaCv.unlock();
                        }
                    }
                    if (this.zzaDJ == 2) {
                        break;
                    }
                    continue;
                }
            }
        }
        throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    
    @Override
    public final ConnectionResult blockingConnect(final long n, @NonNull final TimeUnit timeUnit) {
        boolean b = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            b = true;
        }
        zzbo.zza(b, (Object)"blockingConnect must not be called on the UI thread");
        zzbo.zzb(timeUnit, "TimeUnit must not be null");
        this.zzaCv.lock();
        try {
            if (this.zzaDJ == null) {
                this.zzaDJ = zza(this.zzaDF.values(), false);
            }
            else if (this.zzaDJ == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.zzap(this.zzaDJ);
            this.zzaDy.zzrA();
            return this.zzaDz.blockingConnect(n, timeUnit);
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzbo.zza(this.isConnected(), (Object)"GoogleApiClient is not connected yet.");
        zzbo.zza(this.zzaDJ != 2, (Object)"Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzben zzben = new zzben(this);
        if (this.zzaDF.containsKey(zzbfo.zzajR)) {
            this.zza(this, zzben, false);
            return zzben;
        }
        final AtomicReference<GoogleApiClient> atomicReference = new AtomicReference<GoogleApiClient>();
        final GoogleApiClient build = new Builder(this.mContext).addApi(zzbfo.API).addConnectionCallbacks(new zzbcr(this, atomicReference, zzben)).addOnConnectionFailedListener(new zzbcs(this, zzben)).setHandler(this.zzaDD).build();
        atomicReference.set(build);
        build.connect();
        return zzben;
    }
    
    @Override
    public final void connect() {
        while (true) {
            boolean b = false;
            this.zzaCv.lock();
            while (true) {
                Label_0097: {
                    try {
                        if (this.zzaBb >= 0) {
                            if (this.zzaDJ != null) {
                                b = true;
                            }
                            zzbo.zza(b, (Object)"Sign-in mode should have been set explicitly by auto-manage.");
                        }
                        else {
                            if (this.zzaDJ != null) {
                                break Label_0097;
                            }
                            this.zzaDJ = zza(this.zzaDF.values(), false);
                        }
                        this.connect(this.zzaDJ);
                        return;
                    }
                    finally {
                        this.zzaCv.unlock();
                    }
                }
                if (this.zzaDJ == 2) {
                    break;
                }
                continue;
            }
        }
        throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    
    @Override
    public final void connect(final int i) {
        final boolean b = true;
        this.zzaCv.lock();
        boolean b2 = b;
        Label_0077: {
            if (i != 3) {
                b2 = b;
                if (i != 1) {
                    if (i != 2) {
                        break Label_0077;
                    }
                    b2 = b;
                }
            }
            try {
                while (true) {
                    zzbo.zzb(b2, (Object)new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
                    this.zzap(i);
                    this.zzqc();
                    return;
                    b2 = false;
                    continue;
                }
            }
            finally {
                this.zzaCv.unlock();
            }
        }
    }
    
    @Override
    public final void disconnect() {
        this.zzaCv.lock();
        try {
            this.zzaDL.release();
            if (this.zzaDz != null) {
                this.zzaDz.disconnect();
            }
            this.zzaDH.release();
            for (final zzbay zzbay : this.zzaCJ) {
                zzbay.zza((zzbex)null);
                zzbay.cancel();
            }
        }
        finally {
            this.zzaCv.unlock();
        }
        this.zzaCJ.clear();
        if (this.zzaDz == null) {
            this.zzaCv.unlock();
            return;
        }
        this.zzqe();
        this.zzaDy.zzrz();
        this.zzaCv.unlock();
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.append(s).append("mContext=").println(this.mContext);
        printWriter.append(s).append("mResuming=").print(this.zzaDA);
        printWriter.append(" mWorkQueue.size()=").print(this.zzaCJ.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzaDL.zzaFl.size());
        if (this.zzaDz != null) {
            this.zzaDz.dump(s, fileDescriptor, printWriter, array);
        }
    }
    
    @NonNull
    @Override
    public final ConnectionResult getConnectionResult(@NonNull final Api<?> api) {
        this.zzaCv.lock();
        try {
            if (!this.isConnected() && !this.zzaDA) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
        }
        finally {
            this.zzaCv.unlock();
        }
        final Api<?> api2;
        if (!this.zzaDF.containsKey(api2.zzpd())) {
            throw new IllegalArgumentException(String.valueOf(api2.getName()).concat(" was never registered with GoogleApiClient"));
        }
        final ConnectionResult connectionResult = this.zzaDz.getConnectionResult(api2);
        if (connectionResult != null) {
            this.zzaCv.unlock();
            return connectionResult;
        }
        if (this.zzaDA) {
            final ConnectionResult zzazX = ConnectionResult.zzazX;
            this.zzaCv.unlock();
            return zzazX;
        }
        Log.w("GoogleApiClientImpl", this.zzqg());
        Log.wtf("GoogleApiClientImpl", String.valueOf(api2.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), (Throwable)new Exception());
        final ConnectionResult connectionResult2 = new ConnectionResult(8, null);
        this.zzaCv.unlock();
        return connectionResult2;
    }
    
    @Override
    public final Context getContext() {
        return this.mContext;
    }
    
    @Override
    public final Looper getLooper() {
        return this.zzrM;
    }
    
    @Override
    public final boolean hasConnectedApi(@NonNull final Api<?> api) {
        if (!this.isConnected()) {
            return false;
        }
        final Api.zze zze = this.zzaDF.get(api.zzpd());
        return zze != null && zze.isConnected();
    }
    
    @Override
    public final boolean isConnected() {
        return this.zzaDz != null && this.zzaDz.isConnected();
    }
    
    @Override
    public final boolean isConnecting() {
        return this.zzaDz != null && this.zzaDz.isConnecting();
    }
    
    @Override
    public final boolean isConnectionCallbacksRegistered(@NonNull final ConnectionCallbacks connectionCallbacks) {
        return this.zzaDy.isConnectionCallbacksRegistered(connectionCallbacks);
    }
    
    @Override
    public final boolean isConnectionFailedListenerRegistered(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzaDy.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }
    
    @Override
    public final void reconnect() {
        this.disconnect();
        this.connect();
    }
    
    @Override
    public final void registerConnectionCallbacks(@NonNull final ConnectionCallbacks connectionCallbacks) {
        this.zzaDy.registerConnectionCallbacks(connectionCallbacks);
    }
    
    @Override
    public final void registerConnectionFailedListener(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        this.zzaDy.registerConnectionFailedListener(onConnectionFailedListener);
    }
    
    @Override
    public final void stopAutoManage(@NonNull final FragmentActivity fragmentActivity) {
        final zzbdr zzbdr = new zzbdr(fragmentActivity);
        if (this.zzaBb >= 0) {
            zzbau.zza(zzbdr).zzal(this.zzaBb);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }
    
    @Override
    public final void unregisterConnectionCallbacks(@NonNull final ConnectionCallbacks connectionCallbacks) {
        this.zzaDy.unregisterConnectionCallbacks(connectionCallbacks);
    }
    
    @Override
    public final void unregisterConnectionFailedListener(@NonNull final OnConnectionFailedListener onConnectionFailedListener) {
        this.zzaDy.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
    
    @NonNull
    @Override
    public final <C extends Api.zze> C zza(@NonNull final Api.zzc<C> zzc) {
        final Api.zze zze = this.zzaDF.get(zzc);
        zzbo.zzb(zze, "Appropriate Api was not requested.");
        return (C)zze;
    }
    
    @Override
    public final void zza(final zzbes zzbes) {
        this.zzaCv.lock();
        try {
            if (this.zzaDK == null) {
                this.zzaDK = new HashSet<zzbes>();
            }
            this.zzaDK.add(zzbes);
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final boolean zza(@NonNull final Api<?> api) {
        return this.zzaDF.containsKey(api.zzpd());
    }
    
    @Override
    public final boolean zza(final zzbei zzbei) {
        return this.zzaDz != null && this.zzaDz.zza(zzbei);
    }
    
    @Override
    public final void zzb(final zzbes zzbes) {
        while (true) {
            this.zzaCv.lock();
            Label_0088: {
                try {
                    if (this.zzaDK == null) {
                        Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", (Throwable)new Exception());
                    }
                    else {
                        if (this.zzaDK.remove(zzbes)) {
                            break Label_0088;
                        }
                        Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", (Throwable)new Exception());
                    }
                    return;
                }
                finally {
                    this.zzaCv.unlock();
                }
            }
            if (!this.zzqf()) {
                this.zzaDz.zzpE();
            }
        }
    }
    
    @Override
    public final void zzc(final ConnectionResult connectionResult) {
        if (!zze.zze(this.mContext, connectionResult.getErrorCode())) {
            this.zzqe();
        }
        if (!this.zzaDA) {
            this.zzaDy.zzk(connectionResult);
            this.zzaDy.zzrz();
        }
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T t) {
        while (true) {
            while (true) {
                boolean containsKey = false;
                Label_0009: {
                    if (t.zzpd() != null) {
                        containsKey = true;
                        break Label_0009;
                    }
                    Label_0123: {
                        break Label_0123;
                        while (true) {
                            String name = null;
                            zzbo.zzb(containsKey, (Object)new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
                            this.zzaCv.lock();
                            try {
                                if (this.zzaDz == null) {
                                    this.zzaCJ.add(t);
                                    return t;
                                }
                                return this.zzaDz.zzd(t);
                                containsKey = false;
                                break;
                                name = "the API";
                            }
                            finally {
                                this.zzaCv.unlock();
                            }
                        }
                    }
                }
                zzbo.zzb(containsKey, (Object)"This task can not be enqueued (it's probably a Batch or malformed)");
                containsKey = this.zzaDF.containsKey(t.zzpd());
                if (t.zzpg() != null) {
                    final String name = t.zzpg().getName();
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        while (true) {
            Label_0124: {
                if (t.zzpd() == null) {
                    break Label_0124;
                }
                final boolean b = true;
                zzbo.zzb(b, (Object)"This task can not be executed (it's probably a Batch or malformed)");
                final boolean containsKey = this.zzaDF.containsKey(t.zzpd());
                String name;
                if (t.zzpg() != null) {
                    name = t.zzpg().getName();
                }
                else {
                    name = "the API";
                }
                zzbo.zzb(containsKey, (Object)new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
                this.zzaCv.lock();
                Label_0136: {
                    try {
                        if (this.zzaDz == null) {
                            throw new IllegalStateException("GoogleApiClient is not connected yet.");
                        }
                        break Label_0136;
                    }
                    finally {
                        this.zzaCv.unlock();
                    }
                    break Label_0124;
                }
                final T t2;
                if (this.zzaDA) {
                    this.zzaCJ.add(t2);
                    while (!this.zzaCJ.isEmpty()) {
                        final zzbay<?, ?> zzbay = this.zzaCJ.remove();
                        this.zzaDL.zzb(zzbay);
                        zzbay.zzr(Status.zzaBo);
                    }
                    this.zzaCv.unlock();
                    return t2;
                }
                final zzbay<? extends Result, A> zze = this.zzaDz.zze(t2);
                this.zzaCv.unlock();
                return (T)zze;
            }
            final boolean b = false;
            continue;
        }
    }
    
    @Override
    public final void zze(final int n, final boolean b) {
        if (n == 1 && !b && !this.zzaDA) {
            this.zzaDA = true;
            if (this.zzaDE == null) {
                this.zzaDE = GoogleApiAvailability.zza(this.mContext.getApplicationContext(), new zzbcv(this));
            }
            this.zzaDD.sendMessageDelayed(this.zzaDD.obtainMessage(1), this.zzaDB);
            this.zzaDD.sendMessageDelayed(this.zzaDD.obtainMessage(2), this.zzaDC);
        }
        this.zzaDL.zzqM();
        this.zzaDy.zzaA(n);
        this.zzaDy.zzrz();
        if (n == 2) {
            this.zzqc();
        }
    }
    
    @Override
    public final void zzm(final Bundle bundle) {
        while (!this.zzaCJ.isEmpty()) {
            this.zze(this.zzaCJ.remove());
        }
        this.zzaDy.zzn(bundle);
    }
    
    @Override
    public final <L> zzbdw<L> zzp(@NonNull final L l) {
        this.zzaCv.lock();
        try {
            return this.zzaDH.zza(l, this.zzrM, "NO_TYPE");
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zzpl() {
        if (this.zzaDz != null) {
            this.zzaDz.zzpl();
        }
    }
    
    final boolean zzqe() {
        if (!this.zzaDA) {
            return false;
        }
        this.zzaDA = false;
        this.zzaDD.removeMessages(2);
        this.zzaDD.removeMessages(1);
        if (this.zzaDE != null) {
            this.zzaDE.unregister();
            this.zzaDE = null;
        }
        return true;
    }
    
    final boolean zzqf() {
        boolean b = false;
        this.zzaCv.lock();
        try {
            if (this.zzaDK == null) {
                return false;
            }
            if (!this.zzaDK.isEmpty()) {
                b = true;
            }
            return b;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    final String zzqg() {
        final StringWriter out = new StringWriter();
        this.dump("", null, new PrintWriter(out), null);
        return out.toString();
    }
}
