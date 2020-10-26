// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.concurrent.Executor;
import com.google.android.gms.common.api.GoogleApi;
import java.util.concurrent.TimeUnit;
import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzr;
import java.util.Collection;
import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.Collections;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.ConnectionResult;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.api.Api;
import java.util.Map;
import com.google.android.gms.common.internal.zzq;

public final class zzbbp implements zzbdp
{
    private final zzbdb zzaAN;
    private final zzq zzaCA;
    private final Map<Api.zzc<?>, zzbbo<?>> zzaCB;
    private final Map<Api.zzc<?>, zzbbo<?>> zzaCC;
    private final Map<Api<?>, Boolean> zzaCD;
    private final zzbcp zzaCE;
    private final zze zzaCF;
    private final Condition zzaCG;
    private final boolean zzaCH;
    private final boolean zzaCI;
    private final Queue<zzbay<?, ?>> zzaCJ;
    private boolean zzaCK;
    private Map<zzbat<?>, ConnectionResult> zzaCL;
    private Map<zzbat<?>, ConnectionResult> zzaCM;
    private zzbbs zzaCN;
    private ConnectionResult zzaCO;
    private final Lock zzaCv;
    private final Looper zzrM;
    
    public zzbbp(final Context context, final Lock zzaCv, final Looper zzrM, final zze zzaCF, final Map<Api.zzc<?>, Api.zze> map, final zzq zzaCA, final Map<Api<?>, Boolean> zzaCD, final Api.zza<? extends zzctk, zzctl> zza, final ArrayList<zzbbi> list, final zzbcp zzaCE, final boolean zzaCH) {
        this.zzaCB = new HashMap<Api.zzc<?>, zzbbo<?>>();
        this.zzaCC = new HashMap<Api.zzc<?>, zzbbo<?>>();
        this.zzaCJ = new LinkedList<zzbay<?, ?>>();
        this.zzaCv = zzaCv;
        this.zzrM = zzrM;
        this.zzaCG = zzaCv.newCondition();
        this.zzaCF = zzaCF;
        this.zzaCE = zzaCE;
        this.zzaCD = zzaCD;
        this.zzaCA = zzaCA;
        this.zzaCH = zzaCH;
        final HashMap<Object, Api<?>> hashMap = new HashMap<Object, Api<?>>();
        for (final Api<?> api : zzaCD.keySet()) {
            hashMap.put(api.zzpd(), api);
        }
        final HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        final ArrayList<zzbbi> list2 = list;
        final int size = list2.size();
        int i = 0;
        while (i < size) {
            final zzbbi value = list2.get(i);
            ++i;
            final zzbbi zzbbi = value;
            hashMap2.put(zzbbi.zzayW, zzbbi);
        }
        final Iterator<Map.Entry<Api.zzc<?>, Api.zze>> iterator2 = map.entrySet().iterator();
        int n = 1;
        int n2 = 0;
        boolean b = false;
        while (iterator2.hasNext()) {
            final Map.Entry<Api.zzc<?>, Api.zze> entry = iterator2.next();
            final Api<?> api2 = hashMap.get(entry.getKey());
            final Api.zze zze = entry.getValue();
            int n3;
            int n4;
            if (zze.zzpe()) {
                b = true;
                if (!this.zzaCD.get(api2)) {
                    n3 = n;
                    n4 = 1;
                }
                else {
                    final int n5 = n2;
                    n3 = n;
                    n4 = n5;
                }
            }
            else {
                final int n6 = 0;
                n4 = n2;
                n3 = n6;
            }
            final zzbbo zzbbo = new zzbbo<Object>(context, (Api<Api.ApiOptions>)api2, zzrM, zze, hashMap2.get(api2), zzaCA, zza);
            this.zzaCB.put((Api.zzc)entry.getKey(), zzbbo);
            if (zze.zzmv()) {
                this.zzaCC.put((Api.zzc)entry.getKey(), zzbbo);
            }
            final int n7 = n4;
            n = n3;
            n2 = n7;
        }
        this.zzaCI = (b && n == 0 && n2 == 0);
        this.zzaAN = zzbdb.zzqk();
    }
    
    private final boolean zza(final zzbbo<?> zzbbo, final ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.zzaCD.get(zzbbo.zzpg()) && zzbbo.zzpJ().zzpe() && this.zzaCF.isUserResolvableError(connectionResult.getErrorCode());
    }
    
    @Nullable
    private final ConnectionResult zzb(@NonNull final Api.zzc<?> zzc) {
        this.zzaCv.lock();
        try {
            final zzbbo<?> zzbbo = this.zzaCB.get(zzc);
            if (this.zzaCL != null && zzbbo != null) {
                return this.zzaCL.get(zzbbo.zzph());
            }
            return null;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    private final <T extends zzbay<? extends Result, ? extends Api.zzb>> boolean zzg(@NonNull final T t) {
        final Api.zzc<?> zzpd = ((zzbay<R, ?>)t).zzpd();
        final ConnectionResult zzb = this.zzb(zzpd);
        if (zzb != null && zzb.getErrorCode() == 4) {
            t.zzr(new Status(4, null, this.zzaAN.zza(this.zzaCB.get(zzpd).zzph(), System.identityHashCode(this.zzaCE))));
            return true;
        }
        return false;
    }
    
    private final boolean zzpK() {
        this.zzaCv.lock();
        try {
            if (!this.zzaCK || !this.zzaCH) {
                return false;
            }
            final Iterator<Api.zzc<?>> iterator = this.zzaCC.keySet().iterator();
            while (iterator.hasNext()) {
                final ConnectionResult zzb = this.zzb((Api.zzc)iterator.next());
                if (zzb == null || !zzb.isSuccess()) {
                    return false;
                }
            }
            return true;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    private final void zzpL() {
        if (this.zzaCA == null) {
            this.zzaCE.zzaDG = Collections.emptySet();
            return;
        }
        final HashSet<Scope> zzaDG = new HashSet<Scope>(this.zzaCA.zzrn());
        final Map<Api<?>, zzr> zzrp = this.zzaCA.zzrp();
        for (final Api<?> api : zzrp.keySet()) {
            final ConnectionResult connectionResult = this.getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                zzaDG.addAll((Collection<?>)zzrp.get(api).zzame);
            }
        }
        this.zzaCE.zzaDG = zzaDG;
    }
    
    private final void zzpM() {
        while (!this.zzaCJ.isEmpty()) {
            this.zze(this.zzaCJ.remove());
        }
        this.zzaCE.zzm(null);
    }
    
    @Nullable
    private final ConnectionResult zzpN() {
        final Iterator<zzbbo<?>> iterator = this.zzaCB.values().iterator();
        int n = 0;
        ConnectionResult connectionResult = null;
        int n2 = 0;
        ConnectionResult connectionResult2 = null;
        while (iterator.hasNext()) {
            final zzbbo<?> zzbbo = iterator.next();
            final Api<Api.ApiOptions> zzpg = zzbbo.zzpg();
            final ConnectionResult connectionResult3 = this.zzaCL.get(zzbbo.zzph());
            if (!connectionResult3.isSuccess() && (!this.zzaCD.get(zzpg) || connectionResult3.hasResolution() || this.zzaCF.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() == 4 && this.zzaCH) {
                    final int priority = zzpg.zzpb().getPriority();
                    if (connectionResult != null && n <= priority) {
                        continue;
                    }
                    n = priority;
                    connectionResult = connectionResult3;
                }
                else {
                    final int priority2 = zzpg.zzpb().getPriority();
                    if (connectionResult2 != null && n2 <= priority2) {
                        continue;
                    }
                    connectionResult2 = connectionResult3;
                    n2 = priority2;
                }
            }
        }
        if (connectionResult2 != null && connectionResult != null && n2 > n) {
            return connectionResult;
        }
        return connectionResult2;
    }
    
    @Override
    public final ConnectionResult blockingConnect() {
        this.connect();
        while (this.isConnecting()) {
            try {
                this.zzaCG.await();
                continue;
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            break;
        }
        if (this.isConnected()) {
            return ConnectionResult.zzazX;
        }
        if (this.zzaCO != null) {
            return this.zzaCO;
        }
        return new ConnectionResult(13, null);
    }
    
    @Override
    public final ConnectionResult blockingConnect(long duration, final TimeUnit timeUnit) {
        this.connect();
        duration = timeUnit.toNanos(duration);
    Label_0038_Outer:
        while (this.isConnecting()) {
            while (true) {
                if (duration <= 0L) {
                    try {
                        this.disconnect();
                        return new ConnectionResult(14, null);
                        duration = this.zzaCG.awaitNanos(duration);
                        continue Label_0038_Outer;
                    }
                    catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        return new ConnectionResult(15, null);
                    }
                    break;
                }
                continue;
            }
        }
        if (this.isConnected()) {
            return ConnectionResult.zzazX;
        }
        if (this.zzaCO != null) {
            return this.zzaCO;
        }
        return new ConnectionResult(13, null);
    }
    
    @Override
    public final void connect() {
        this.zzaCv.lock();
        try {
            if (this.zzaCK) {
                return;
            }
            this.zzaCK = true;
            this.zzaCL = null;
            this.zzaCM = null;
            this.zzaCN = null;
            this.zzaCO = null;
            this.zzaAN.zzps();
            this.zzaAN.zza(this.zzaCB.values()).addOnCompleteListener(new zzbgv(this.zzrM), new zzbbr(this, null));
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final void disconnect() {
        this.zzaCv.lock();
        try {
            this.zzaCK = false;
            this.zzaCL = null;
            this.zzaCM = null;
            if (this.zzaCN != null) {
                this.zzaCN.cancel();
                this.zzaCN = null;
            }
            this.zzaCO = null;
            while (!this.zzaCJ.isEmpty()) {
                final zzbay<?, ?> zzbay = this.zzaCJ.remove();
                zzbay.zza((zzbex)null);
                zzbay.cancel();
            }
        }
        finally {
            this.zzaCv.unlock();
        }
        this.zzaCG.signalAll();
        this.zzaCv.unlock();
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    @Nullable
    @Override
    public final ConnectionResult getConnectionResult(@NonNull final Api<?> api) {
        return this.zzb(api.zzpd());
    }
    
    @Override
    public final boolean isConnected() {
        this.zzaCv.lock();
        try {
            return this.zzaCL != null && this.zzaCO == null;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final boolean isConnecting() {
        this.zzaCv.lock();
        try {
            return this.zzaCL == null && this.zzaCK;
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final boolean zza(final zzbei zzbei) {
        this.zzaCv.lock();
        try {
            if (this.zzaCK && !this.zzpK()) {
                this.zzaAN.zzps();
                this.zzaCN = new zzbbs(this, zzbei);
                this.zzaAN.zza(this.zzaCC.values()).addOnCompleteListener(new zzbgv(this.zzrM), this.zzaCN);
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
        if (this.zzaCH && this.zzg(t)) {
            return t;
        }
        if (!this.isConnected()) {
            this.zzaCJ.add(t);
            return t;
        }
        this.zzaCE.zzaDL.zzb(t);
        return this.zzaCB.get(t.zzpd()).zza(t);
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        final Api.zzc<A> zzpd = ((zzbay<R, A>)t).zzpd();
        if (this.zzaCH && this.zzg(t)) {
            return t;
        }
        this.zzaCE.zzaDL.zzb(t);
        return this.zzaCB.get(zzpd).zzb(t);
    }
    
    @Override
    public final void zzpE() {
    }
    
    @Override
    public final void zzpl() {
        this.zzaCv.lock();
        try {
            this.zzaAN.zzpl();
            if (this.zzaCN != null) {
                this.zzaCN.cancel();
                this.zzaCN = null;
            }
            if (this.zzaCM == null) {
                this.zzaCM = new ArrayMap<zzbat<?>, ConnectionResult>(this.zzaCC.size());
            }
            final ConnectionResult connectionResult = new ConnectionResult(4);
            final Iterator<zzbbo<?>> iterator = this.zzaCC.values().iterator();
            while (iterator.hasNext()) {
                this.zzaCM.put(iterator.next().zzph(), connectionResult);
            }
        }
        finally {
            this.zzaCv.unlock();
        }
        if (this.zzaCL != null) {
            this.zzaCL.putAll(this.zzaCM);
        }
        this.zzaCv.unlock();
    }
}
