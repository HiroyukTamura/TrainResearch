// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.HashMap;
import com.google.android.gms.common.internal.zzr;
import java.util.Collection;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import android.app.PendingIntent;
import com.google.android.gms.common.internal.zzbr;
import android.util.Log;
import java.util.HashSet;
import java.util.concurrent.Future;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zzal;
import java.util.Set;
import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.zze;
import java.util.Map;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.api.Api;
import android.content.Context;

public final class zzbcd implements zzbcw
{
    private final Context mContext;
    private final Api.zza<? extends zzctk, zzctl> zzaBe;
    private final zzq zzaCA;
    private final Map<Api<?>, Boolean> zzaCD;
    private final zze zzaCF;
    private ConnectionResult zzaCO;
    private final zzbcx zzaCZ;
    private final Lock zzaCv;
    private int zzaDc;
    private int zzaDd;
    private int zzaDe;
    private final Bundle zzaDf;
    private final Set<Api.zzc> zzaDg;
    private zzctk zzaDh;
    private boolean zzaDi;
    private boolean zzaDj;
    private boolean zzaDk;
    private zzal zzaDl;
    private boolean zzaDm;
    private boolean zzaDn;
    private ArrayList<Future<?>> zzaDo;
    
    public zzbcd(final zzbcx zzaCZ, final zzq zzaCA, final Map<Api<?>, Boolean> zzaCD, final zze zzaCF, final Api.zza<? extends zzctk, zzctl> zzaBe, final Lock zzaCv, final Context mContext) {
        this.zzaDd = 0;
        this.zzaDf = new Bundle();
        this.zzaDg = new HashSet<Api.zzc>();
        this.zzaDo = new ArrayList<Future<?>>();
        this.zzaCZ = zzaCZ;
        this.zzaCA = zzaCA;
        this.zzaCD = zzaCD;
        this.zzaCF = zzaCF;
        this.zzaBe = zzaBe;
        this.zzaCv = zzaCv;
        this.mContext = mContext;
    }
    
    private final void zza(final zzctx zzctx) {
        if (!this.zzan(0)) {
            return;
        }
        final ConnectionResult zzpz = zzctx.zzpz();
        if (zzpz.isSuccess()) {
            final zzbr zzAx = zzctx.zzAx();
            final ConnectionResult zzpz2 = zzAx.zzpz();
            if (!zzpz2.isSuccess()) {
                final String value = String.valueOf(zzpz2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(value).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(value).toString(), (Throwable)new Exception());
                this.zze(zzpz2);
                return;
            }
            this.zzaDk = true;
            this.zzaDl = zzAx.zzrH();
            this.zzaDm = zzAx.zzrI();
            this.zzaDn = zzAx.zzrJ();
            this.zzpX();
        }
        else {
            if (this.zzd(zzpz)) {
                this.zzpZ();
                this.zzpX();
                return;
            }
            this.zze(zzpz);
        }
    }
    
    private final void zzad(final boolean b) {
        if (this.zzaDh != null) {
            if (((Api.zze)this.zzaDh).isConnected() && b) {
                this.zzaDh.zzAq();
            }
            ((Api.zze)this.zzaDh).disconnect();
            this.zzaDl = null;
        }
    }
    
    private final boolean zzan(final int n) {
        if (this.zzaDd != n) {
            Log.w("GoogleApiClientConnecting", this.zzaCZ.zzaCl.zzqg());
            final String value = String.valueOf(this);
            Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(value).length() + 23).append("Unexpected callback in ").append(value).toString());
            Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.zzaDe).toString());
            final String value2 = String.valueOf(zzao(this.zzaDd));
            final String value3 = String.valueOf(zzao(n));
            Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(value2).length() + 70 + String.valueOf(value3).length()).append("GoogleApiClient connecting is in step ").append(value2).append(" but received callback for step ").append(value3).toString(), (Throwable)new Exception());
            this.zze(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }
    
    private static String zzao(final int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 0: {
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            }
            case 1: {
                return "STEP_GETTING_REMOTE_SERVICE";
            }
        }
    }
    
    private final void zzb(final ConnectionResult zzaCO, final Api<?> api, final boolean b) {
        final boolean b2 = true;
        final int priority = api.zzpb().getPriority();
        while (true) {
            Label_0116: {
                if (b) {
                    int n;
                    if (zzaCO.hasResolution()) {
                        n = 1;
                    }
                    else if (this.zzaCF.zzak(zzaCO.getErrorCode()) != null) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (n == 0) {
                        break Label_0116;
                    }
                }
                int n2 = b2 ? 1 : 0;
                if (this.zzaCO != null) {
                    if (priority >= this.zzaDc) {
                        break Label_0116;
                    }
                    n2 = (b2 ? 1 : 0);
                }
                if (n2 != 0) {
                    this.zzaCO = zzaCO;
                    this.zzaDc = priority;
                }
                this.zzaCZ.zzaDU.put(api.zzpd(), zzaCO);
                return;
            }
            int n2 = 0;
            continue;
        }
    }
    
    private final boolean zzd(final ConnectionResult connectionResult) {
        return this.zzaDi && !connectionResult.hasResolution();
    }
    
    private final void zze(final ConnectionResult connectionResult) {
        this.zzqa();
        this.zzad(!connectionResult.hasResolution());
        this.zzaCZ.zzg(connectionResult);
        this.zzaCZ.zzaDY.zzc(connectionResult);
    }
    
    private final boolean zzpW() {
        --this.zzaDe;
        if (this.zzaDe > 0) {
            return false;
        }
        if (this.zzaDe < 0) {
            Log.w("GoogleApiClientConnecting", this.zzaCZ.zzaCl.zzqg());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", (Throwable)new Exception());
            this.zze(new ConnectionResult(8, null));
            return false;
        }
        if (this.zzaCO != null) {
            this.zzaCZ.zzaDX = this.zzaDc;
            this.zze(this.zzaCO);
            return false;
        }
        return true;
    }
    
    private final void zzpX() {
        if (this.zzaDe == 0 && (!this.zzaDj || this.zzaDk)) {
            final ArrayList<Api.zze> list = new ArrayList<Api.zze>();
            this.zzaDd = 1;
            this.zzaDe = this.zzaCZ.zzaDF.size();
            for (final Api.zzc zzc : this.zzaCZ.zzaDF.keySet()) {
                if (this.zzaCZ.zzaDU.containsKey(zzc)) {
                    if (!this.zzpW()) {
                        continue;
                    }
                    this.zzpY();
                }
                else {
                    list.add(this.zzaCZ.zzaDF.get(zzc));
                }
            }
            if (!list.isEmpty()) {
                this.zzaDo.add(zzbda.zzqj().submit(new zzbcj(list)));
            }
        }
    }
    
    private final void zzpY() {
        this.zzaCZ.zzqi();
        zzbda.zzqj().execute(new zzbce(this));
        if (this.zzaDh != null) {
            if (this.zzaDm) {
                this.zzaDh.zza(this.zzaDl, this.zzaDn);
            }
            this.zzad(false);
        }
        final Iterator<Api.zzc<?>> iterator = this.zzaCZ.zzaDU.keySet().iterator();
        while (iterator.hasNext()) {
            this.zzaCZ.zzaDF.get((Api.zzc)iterator.next()).disconnect();
        }
        Bundle zzaDf;
        if (this.zzaDf.isEmpty()) {
            zzaDf = null;
        }
        else {
            zzaDf = this.zzaDf;
        }
        this.zzaCZ.zzaDY.zzm(zzaDf);
    }
    
    private final void zzpZ() {
        this.zzaDj = false;
        this.zzaCZ.zzaCl.zzaDG = Collections.emptySet();
        for (final Api.zzc zzc : this.zzaDg) {
            if (!this.zzaCZ.zzaDU.containsKey(zzc)) {
                this.zzaCZ.zzaDU.put(zzc, new ConnectionResult(17, null));
            }
        }
    }
    
    private final void zzqa() {
        final ArrayList<Future<?>> list = this.zzaDo;
        final int size = list.size();
        int i = 0;
        while (i < size) {
            final Future<?> value = list.get(i);
            ++i;
            value.cancel(true);
        }
        this.zzaDo.clear();
    }
    
    private final Set<Scope> zzqb() {
        if (this.zzaCA == null) {
            return Collections.emptySet();
        }
        final HashSet<Object> set = (HashSet<Object>)new HashSet<Scope>(this.zzaCA.zzrn());
        final Map<Api<?>, zzr> zzrp = this.zzaCA.zzrp();
        for (final Api<?> api : zzrp.keySet()) {
            if (!this.zzaCZ.zzaDU.containsKey(api.zzpd())) {
                set.addAll(zzrp.get(api).zzame);
            }
        }
        return (Set<Scope>)set;
    }
    
    @Override
    public final void begin() {
        this.zzaCZ.zzaDU.clear();
        this.zzaDj = false;
        this.zzaCO = null;
        this.zzaDd = 0;
        this.zzaDi = true;
        this.zzaDk = false;
        this.zzaDm = false;
        final HashMap<Api.zze, zzbcf> hashMap = new HashMap<Api.zze, zzbcf>();
        final Iterator<Api<?>> iterator = this.zzaCD.keySet().iterator();
        int n = false ? 1 : 0;
        while (iterator.hasNext()) {
            final Api<?> api = iterator.next();
            final Api.zze zze = this.zzaCZ.zzaDF.get(api.zzpd());
            boolean b;
            if (api.zzpb().getPriority() == 1) {
                b = true;
            }
            else {
                b = false;
            }
            final boolean booleanValue = this.zzaCD.get(api);
            if (zze.zzmv()) {
                this.zzaDj = true;
                if (booleanValue) {
                    this.zzaDg.add((Api.zzc)api.zzpd());
                }
                else {
                    this.zzaDi = false;
                }
            }
            hashMap.put(zze, new zzbcf(this, api, booleanValue));
            n |= (b ? 1 : 0);
        }
        if (n != 0) {
            this.zzaDj = false;
        }
        if (this.zzaDj) {
            this.zzaCA.zzc(System.identityHashCode(this.zzaCZ.zzaCl));
            final zzbcm zzbcm = new zzbcm(this, null);
            this.zzaDh = (zzctk)this.zzaBe.zza(this.mContext, this.zzaCZ.zzaCl.getLooper(), this.zzaCA, this.zzaCA.zzrt(), zzbcm, zzbcm);
        }
        this.zzaDe = this.zzaCZ.zzaDF.size();
        this.zzaDo.add(zzbda.zzqj().submit(new zzbcg(hashMap)));
    }
    
    @Override
    public final void connect() {
    }
    
    @Override
    public final boolean disconnect() {
        this.zzqa();
        this.zzad(true);
        this.zzaCZ.zzg(null);
        return true;
    }
    
    @Override
    public final void onConnected(final Bundle bundle) {
        if (this.zzan(1)) {
            if (bundle != null) {
                this.zzaDf.putAll(bundle);
            }
            if (this.zzpW()) {
                this.zzpY();
            }
        }
    }
    
    @Override
    public final void onConnectionSuspended(final int n) {
        this.zze(new ConnectionResult(8, null));
    }
    
    @Override
    public final void zza(final ConnectionResult connectionResult, final Api<?> api, final boolean b) {
        if (this.zzan(1)) {
            this.zzb(connectionResult, api, b);
            if (this.zzpW()) {
                this.zzpY();
            }
        }
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(final T t) {
        this.zzaCZ.zzaCl.zzaCJ.add(t);
        return t;
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(final T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
