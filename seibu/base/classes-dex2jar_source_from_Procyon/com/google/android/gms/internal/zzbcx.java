// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import java.util.concurrent.TimeUnit;
import android.app.PendingIntent;
import java.util.HashMap;
import java.util.ArrayList;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.zze;
import java.util.Map;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.api.Api;
import android.content.Context;

public final class zzbcx implements zzbbj, zzbdp
{
    private final Context mContext;
    private Api.zza<? extends zzctk, zzctl> zzaBe;
    private zzq zzaCA;
    private Map<Api<?>, Boolean> zzaCD;
    private final zze zzaCF;
    final zzbcp zzaCl;
    private final Lock zzaCv;
    final Map<Api.zzc<?>, Api.zze> zzaDF;
    private final Condition zzaDS;
    private final zzbcz zzaDT;
    final Map<Api.zzc<?>, ConnectionResult> zzaDU;
    private volatile zzbcw zzaDV;
    private ConnectionResult zzaDW;
    int zzaDX;
    final zzbdq zzaDY;
    
    public zzbcx(final Context mContext, final zzbcp zzaCl, final Lock zzaCv, final Looper looper, final zze zzaCF, final Map<Api.zzc<?>, Api.zze> zzaDF, final zzq zzaCA, final Map<Api<?>, Boolean> zzaCD, final Api.zza<? extends zzctk, zzctl> zzaBe, final ArrayList<zzbbi> list, final zzbdq zzaDY) {
        this.zzaDU = new HashMap<Api.zzc<?>, ConnectionResult>();
        this.zzaDW = null;
        this.mContext = mContext;
        this.zzaCv = zzaCv;
        this.zzaCF = zzaCF;
        this.zzaDF = zzaDF;
        this.zzaCA = zzaCA;
        this.zzaCD = zzaCD;
        this.zzaBe = zzaBe;
        this.zzaCl = zzaCl;
        this.zzaDY = zzaDY;
        final ArrayList<zzbbi> list2 = list;
        final int size = list2.size();
        int i = 0;
        while (i < size) {
            final zzbbi value = list2.get(i);
            ++i;
            value.zza(this);
        }
        this.zzaDT = new zzbcz(this, looper);
        this.zzaDS = zzaCv.newCondition();
        this.zzaDV = new zzbco(this);
    }
    
    @Override
    public final ConnectionResult blockingConnect() {
        this.connect();
        while (this.isConnecting()) {
            try {
                this.zzaDS.await();
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
        if (this.zzaDW != null) {
            return this.zzaDW;
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
                        duration = this.zzaDS.awaitNanos(duration);
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
        if (this.zzaDW != null) {
            return this.zzaDW;
        }
        return new ConnectionResult(13, null);
    }
    
    @Override
    public final void connect() {
        this.zzaDV.connect();
    }
    
    @Override
    public final void disconnect() {
        if (this.zzaDV.disconnect()) {
            this.zzaDU.clear();
        }
    }
    
    @Override
    public final void dump(final String csq, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final String concat = String.valueOf(csq).concat("  ");
        printWriter.append(csq).append("mState=").println(this.zzaDV);
        for (final Api<?> api : this.zzaCD.keySet()) {
            printWriter.append(csq).append(api.getName()).println(":");
            this.zzaDF.get(api.zzpd()).dump(concat, fileDescriptor, printWriter, array);
        }
    }
    
    @Nullable
    @Override
    public final ConnectionResult getConnectionResult(@NonNull final Api<?> api) {
        final Api.zzc<?> zzpd = (Api.zzc<?>)api.zzpd();
        if (this.zzaDF.containsKey(zzpd)) {
            if (this.zzaDF.get(zzpd).isConnected()) {
                return ConnectionResult.zzazX;
            }
            if (this.zzaDU.containsKey(zzpd)) {
                return this.zzaDU.get(zzpd);
            }
        }
        return null;
    }
    
    @Override
    public final boolean isConnected() {
        return this.zzaDV instanceof zzbca;
    }
    
    @Override
    public final boolean isConnecting() {
        return this.zzaDV instanceof zzbcd;
    }
    
    @Override
    public final void onConnected(@Nullable final Bundle bundle) {
        this.zzaCv.lock();
        try {
            this.zzaDV.onConnected(bundle);
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.zzaCv.lock();
        try {
            this.zzaDV.onConnectionSuspended(n);
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zza(@NonNull final ConnectionResult connectionResult, @NonNull final Api<?> api, final boolean b) {
        this.zzaCv.lock();
        try {
            this.zzaDV.zza(connectionResult, api, b);
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    final void zza(final zzbcy zzbcy) {
        this.zzaDT.sendMessage(this.zzaDT.obtainMessage(1, (Object)zzbcy));
    }
    
    final void zza(final RuntimeException ex) {
        this.zzaDT.sendMessage(this.zzaDT.obtainMessage(2, (Object)ex));
    }
    
    @Override
    public final boolean zza(final zzbei zzbei) {
        return false;
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T t) {
        t.zzpC();
        return this.zzaDV.zzd(t);
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        t.zzpC();
        return this.zzaDV.zze(t);
    }
    
    final void zzg(final ConnectionResult zzaDW) {
        this.zzaCv.lock();
        try {
            this.zzaDW = zzaDW;
            (this.zzaDV = new zzbco(this)).begin();
            this.zzaDS.signalAll();
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    @Override
    public final void zzpE() {
        if (this.isConnected()) {
            ((zzbca)this.zzaDV).zzpU();
        }
    }
    
    @Override
    public final void zzpl() {
    }
    
    final void zzqh() {
        this.zzaCv.lock();
        try {
            (this.zzaDV = new zzbcd(this, this.zzaCA, this.zzaCD, this.zzaCF, this.zzaBe, this.zzaCv, this.mContext)).begin();
            this.zzaDS.signalAll();
        }
        finally {
            this.zzaCv.unlock();
        }
    }
    
    final void zzqi() {
        this.zzaCv.lock();
        try {
            this.zzaCl.zzqe();
            (this.zzaDV = new zzbca(this)).begin();
            this.zzaDS.signalAll();
        }
        finally {
            this.zzaCv.unlock();
        }
    }
}
