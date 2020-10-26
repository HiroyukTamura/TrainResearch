// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.GoogleApiClient;
import android.util.Log;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.support.annotation.Nullable;
import android.util.SparseArray;

public class zzbau extends zzbba
{
    private final SparseArray<zza> zzaBB;
    
    private zzbau(final zzbdt zzbdt) {
        super(zzbdt);
        this.zzaBB = (SparseArray<zza>)new SparseArray();
        this.zzaEG.zza("AutoManageHelper", this);
    }
    
    public static zzbau zza(final zzbdr zzbdr) {
        final zzbdt zzb = zzbds.zzb(zzbdr);
        final zzbau zzbau = zzb.zza("AutoManageHelper", zzbau.class);
        if (zzbau != null) {
            return zzbau;
        }
        return new zzbau(zzb);
    }
    
    @Nullable
    private final zza zzam(final int n) {
        if (this.zzaBB.size() <= n) {
            return null;
        }
        return (zza)this.zzaBB.get(this.zzaBB.keyAt(n));
    }
    
    @Override
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        for (int i = 0; i < this.zzaBB.size(); ++i) {
            final zza zzam = this.zzam(i);
            if (zzam != null) {
                printWriter.append(s).append("GoogleApiClient #").print(zzam.zzaBC);
                printWriter.println(":");
                zzam.zzaBD.dump(String.valueOf(s).concat("  "), fileDescriptor, printWriter, array);
            }
        }
    }
    
    @Override
    public final void onStart() {
        super.onStart();
        final boolean mStarted = this.mStarted;
        final String value = String.valueOf(this.zzaBB);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(value).length() + 14).append("onStart ").append(mStarted).append(" ").append(value).toString());
        if (this.zzaBN.get() == null) {
            for (int i = 0; i < this.zzaBB.size(); ++i) {
                final zza zzam = this.zzam(i);
                if (zzam != null) {
                    zzam.zzaBD.connect();
                }
            }
        }
    }
    
    @Override
    public final void onStop() {
        super.onStop();
        for (int i = 0; i < this.zzaBB.size(); ++i) {
            final zza zzam = this.zzam(i);
            if (zzam != null) {
                zzam.zzaBD.disconnect();
            }
        }
    }
    
    public final void zza(final int n, final GoogleApiClient obj, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbo.zzb(obj, "GoogleApiClient instance cannot be null");
        zzbo.zza(this.zzaBB.indexOfKey(n) < 0, (Object)new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(n).toString());
        final zzbbb obj2 = this.zzaBN.get();
        final boolean mStarted = this.mStarted;
        final String value = String.valueOf(obj2);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(value).length() + 49).append("starting AutoManage for client ").append(n).append(" ").append(mStarted).append(" ").append(value).toString());
        this.zzaBB.put(n, (Object)new zza(n, obj, onConnectionFailedListener));
        if (this.mStarted && obj2 == null) {
            final String value2 = String.valueOf(obj);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(value2).length() + 11).append("connecting ").append(value2).toString());
            obj.connect();
        }
    }
    
    @Override
    protected final void zza(final ConnectionResult connectionResult, final int n) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (n < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", (Throwable)new Exception());
        }
        else {
            final zza zza = (zza)this.zzaBB.get(n);
            if (zza != null) {
                this.zzal(n);
                final GoogleApiClient.OnConnectionFailedListener zzaBE = zza.zzaBE;
                if (zzaBE != null) {
                    zzaBE.onConnectionFailed(connectionResult);
                }
            }
        }
    }
    
    public final void zzal(final int n) {
        final zza zza = (zza)this.zzaBB.get(n);
        this.zzaBB.remove(n);
        if (zza != null) {
            zza.zzaBD.unregisterConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)zza);
            zza.zzaBD.disconnect();
        }
    }
    
    @Override
    protected final void zzps() {
        for (int i = 0; i < this.zzaBB.size(); ++i) {
            final zza zzam = this.zzam(i);
            if (zzam != null) {
                zzam.zzaBD.connect();
            }
        }
    }
    
    final class zza implements OnConnectionFailedListener
    {
        public final int zzaBC;
        public final GoogleApiClient zzaBD;
        public final OnConnectionFailedListener zzaBE;
        
        public zza(final int zzaBC, final GoogleApiClient zzaBD, final OnConnectionFailedListener zzaBE) {
            this.zzaBC = zzaBC;
            this.zzaBD = zzaBD;
            this.zzaBE = zzaBE;
            zzaBD.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)this);
        }
        
        @Override
        public final void onConnectionFailed(@NonNull final ConnectionResult obj) {
            final String value = String.valueOf(obj);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(value).length() + 27).append("beginFailureResolution for ").append(value).toString());
            zzbau.this.zzb(obj, this.zzaBC);
        }
    }
}
