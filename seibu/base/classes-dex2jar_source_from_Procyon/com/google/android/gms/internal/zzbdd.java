// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import android.support.annotation.NonNull;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzj;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.zzbo;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import android.os.DeadObjectException;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.ConnectionResult;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Api;

public final class zzbdd<O extends Api.ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzbbj
{
    private final zzbat<O> zzaAK;
    private final Api.zze zzaCy;
    private boolean zzaDA;
    private /* synthetic */ zzbdb zzaEm;
    private final Queue<zzbam> zzaEn;
    private final Api.zzb zzaEo;
    private final zzbbt zzaEp;
    private final Set<zzbav> zzaEq;
    private final Map<zzbdy<?>, zzbef> zzaEr;
    private final int zzaEs;
    private final zzbej zzaEt;
    private ConnectionResult zzaEu;
    
    @WorkerThread
    public zzbdd(final zzbdb zzaEm, final GoogleApi<O> googleApi) {
        this.zzaEm = zzaEm;
        this.zzaEn = new LinkedList<zzbam>();
        this.zzaEq = new HashSet<zzbav>();
        this.zzaEr = new HashMap<zzbdy<?>, zzbef>();
        this.zzaEu = null;
        this.zzaCy = googleApi.zza(zzaEm.mHandler.getLooper(), this);
        if (this.zzaCy instanceof zzbx) {
            final zzbx zzbx = (zzbx)this.zzaCy;
            this.zzaEo = null;
        }
        else {
            this.zzaEo = this.zzaCy;
        }
        this.zzaAK = googleApi.zzph();
        this.zzaEp = new zzbbt();
        this.zzaEs = googleApi.getInstanceId();
        if (this.zzaCy.zzmv()) {
            this.zzaEt = googleApi.zza(zzaEm.mContext, zzaEm.mHandler);
            return;
        }
        this.zzaEt = null;
    }
    
    @WorkerThread
    private final void zzb(final zzbam zzbam) {
        zzbam.zza(this.zzaEp, this.zzmv());
        try {
            zzbam.zza(this);
        }
        catch (DeadObjectException ex) {
            this.onConnectionSuspended(1);
            this.zzaCy.disconnect();
        }
    }
    
    @WorkerThread
    private final void zzi(final ConnectionResult connectionResult) {
        final Iterator<zzbav> iterator = this.zzaEq.iterator();
        while (iterator.hasNext()) {
            iterator.next().zza(this.zzaAK, connectionResult);
        }
        this.zzaEq.clear();
    }
    
    @WorkerThread
    private final void zzqq() {
        this.zzqt();
        this.zzi(ConnectionResult.zzazX);
        this.zzqv();
        for (final zzbef zzbef : this.zzaEr.values()) {
            try {
                zzbef.zzaBu.zzb(this.zzaEo, new TaskCompletionSource<Void>());
            }
            catch (DeadObjectException ex) {
                this.onConnectionSuspended(1);
                this.zzaCy.disconnect();
            }
            catch (RemoteException ex2) {}
        }
        goto Label_0085;
    }
    
    @WorkerThread
    private final void zzqr() {
        this.zzqt();
        this.zzaDA = true;
        this.zzaEp.zzpQ();
        this.zzaEm.mHandler.sendMessageDelayed(Message.obtain(this.zzaEm.mHandler, 9, (Object)this.zzaAK), this.zzaEm.zzaDC);
        this.zzaEm.mHandler.sendMessageDelayed(Message.obtain(this.zzaEm.mHandler, 11, (Object)this.zzaAK), this.zzaEm.zzaDB);
        this.zzaEm.zzaEg = -1;
    }
    
    @WorkerThread
    private final void zzqv() {
        if (this.zzaDA) {
            this.zzaEm.mHandler.removeMessages(11, (Object)this.zzaAK);
            this.zzaEm.mHandler.removeMessages(9, (Object)this.zzaAK);
            this.zzaDA = false;
        }
    }
    
    private final void zzqw() {
        this.zzaEm.mHandler.removeMessages(12, (Object)this.zzaAK);
        this.zzaEm.mHandler.sendMessageDelayed(this.zzaEm.mHandler.obtainMessage(12, (Object)this.zzaAK), this.zzaEm.zzaEe);
    }
    
    @WorkerThread
    public final void connect() {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaCy.isConnected() || this.zzaCy.isConnecting()) {
            return;
        }
        if (this.zzaCy.zzpe() && this.zzaEm.zzaEg != 0) {
            this.zzaEm.zzaEg = this.zzaEm.zzaBd.isGooglePlayServicesAvailable(this.zzaEm.mContext);
            if (this.zzaEm.zzaEg != 0) {
                this.onConnectionFailed(new ConnectionResult(this.zzaEm.zzaEg, null));
                return;
            }
        }
        final zzbdh zzbdh = new zzbdh(this.zzaCy, this.zzaAK);
        if (this.zzaCy.zzmv()) {
            this.zzaEt.zza(zzbdh);
        }
        this.zzaCy.zza(zzbdh);
    }
    
    public final int getInstanceId() {
        return this.zzaEs;
    }
    
    final boolean isConnected() {
        return this.zzaCy.isConnected();
    }
    
    @Override
    public final void onConnected(@Nullable final Bundle bundle) {
        if (Looper.myLooper() == this.zzaEm.mHandler.getLooper()) {
            this.zzqq();
            return;
        }
        this.zzaEm.mHandler.post((Runnable)new zzbde(this));
    }
    
    @WorkerThread
    @Override
    public final void onConnectionFailed(@NonNull final ConnectionResult zzaEu) {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaEt != null) {
            this.zzaEt.zzqI();
        }
        this.zzqt();
        this.zzaEm.zzaEg = -1;
        this.zzi(zzaEu);
        if (zzaEu.getErrorCode() == 4) {
            this.zzt(zzbdb.zzaEd);
        }
        else {
            if (this.zzaEn.isEmpty()) {
                this.zzaEu = zzaEu;
                return;
            }
            synchronized (zzbdb.zzuF) {
                if (this.zzaEm.zzaEj != null && this.zzaEm.zzaEk.contains(this.zzaAK)) {
                    this.zzaEm.zzaEj.zzb(zzaEu, this.zzaEs);
                    return;
                }
            }
            // monitorexit(o)
            final ConnectionResult connectionResult;
            if (!this.zzaEm.zzc(connectionResult, this.zzaEs)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zzaDA = true;
                }
                if (this.zzaDA) {
                    this.zzaEm.mHandler.sendMessageDelayed(Message.obtain(this.zzaEm.mHandler, 9, (Object)this.zzaAK), this.zzaEm.zzaDC);
                    return;
                }
                final String value = String.valueOf(this.zzaAK.zzpr());
                this.zzt(new Status(17, new StringBuilder(String.valueOf(value).length() + 38).append("API: ").append(value).append(" is not available on this device.").toString()));
            }
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        if (Looper.myLooper() == this.zzaEm.mHandler.getLooper()) {
            this.zzqr();
            return;
        }
        this.zzaEm.mHandler.post((Runnable)new zzbdf(this));
    }
    
    @WorkerThread
    public final void resume() {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaDA) {
            this.connect();
        }
    }
    
    @WorkerThread
    public final void signOut() {
        zzbo.zza(this.zzaEm.mHandler);
        this.zzt(zzbdb.zzaEc);
        this.zzaEp.zzpP();
        final Iterator<zzbdy<?>> iterator = this.zzaEr.keySet().iterator();
        while (iterator.hasNext()) {
            this.zza(new zzbar(iterator.next(), new TaskCompletionSource<Void>()));
        }
        this.zzi(new ConnectionResult(4));
        this.zzaCy.disconnect();
    }
    
    @Override
    public final void zza(final ConnectionResult connectionResult, final Api<?> api, final boolean b) {
        if (Looper.myLooper() == this.zzaEm.mHandler.getLooper()) {
            this.onConnectionFailed(connectionResult);
            return;
        }
        this.zzaEm.mHandler.post((Runnable)new zzbdg(this, connectionResult));
    }
    
    @WorkerThread
    public final void zza(final zzbam zzbam) {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaCy.isConnected()) {
            this.zzb(zzbam);
            this.zzqw();
            return;
        }
        this.zzaEn.add(zzbam);
        if (this.zzaEu != null && this.zzaEu.hasResolution()) {
            this.onConnectionFailed(this.zzaEu);
            return;
        }
        this.connect();
    }
    
    @WorkerThread
    public final void zza(final zzbav zzbav) {
        zzbo.zza(this.zzaEm.mHandler);
        this.zzaEq.add(zzbav);
    }
    
    @WorkerThread
    public final void zzh(@NonNull final ConnectionResult connectionResult) {
        zzbo.zza(this.zzaEm.mHandler);
        this.zzaCy.disconnect();
        this.onConnectionFailed(connectionResult);
    }
    
    public final boolean zzmv() {
        return this.zzaCy.zzmv();
    }
    
    public final Api.zze zzpJ() {
        return this.zzaCy;
    }
    
    @WorkerThread
    public final void zzqd() {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaDA) {
            this.zzqv();
            Status status;
            if (this.zzaEm.zzaBd.isGooglePlayServicesAvailable(this.zzaEm.mContext) == 18) {
                status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
            }
            else {
                status = new Status(8, "API failed to connect while resuming due to an unknown error.");
            }
            this.zzt(status);
            this.zzaCy.disconnect();
        }
    }
    
    public final Map<zzbdy<?>, zzbef> zzqs() {
        return this.zzaEr;
    }
    
    @WorkerThread
    public final void zzqt() {
        zzbo.zza(this.zzaEm.mHandler);
        this.zzaEu = null;
    }
    
    @WorkerThread
    public final ConnectionResult zzqu() {
        zzbo.zza(this.zzaEm.mHandler);
        return this.zzaEu;
    }
    
    @WorkerThread
    public final void zzqx() {
        zzbo.zza(this.zzaEm.mHandler);
        if (this.zzaCy.isConnected() && this.zzaEr.size() == 0) {
            if (!this.zzaEp.zzpO()) {
                this.zzaCy.disconnect();
                return;
            }
            this.zzqw();
        }
    }
    
    final zzctk zzqy() {
        if (this.zzaEt == null) {
            return null;
        }
        return this.zzaEt.zzqy();
    }
    
    @WorkerThread
    public final void zzt(final Status status) {
        zzbo.zza(this.zzaEm.mHandler);
        final Iterator<zzbam> iterator = this.zzaEn.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzp(status);
        }
        this.zzaEn.clear();
    }
}
