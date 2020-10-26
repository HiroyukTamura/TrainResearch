// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collection;
import android.util.Log;
import android.os.Message;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import android.os.Handler;
import android.os.Handler$Callback;

public final class zzac implements Handler$Callback
{
    private final Handler mHandler;
    private final Object mLock;
    private final zzad zzaHE;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaHF;
    private ArrayList<GoogleApiClient.ConnectionCallbacks> zzaHG;
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaHH;
    private volatile boolean zzaHI;
    private final AtomicInteger zzaHJ;
    private boolean zzaHK;
    
    public zzac(final Looper looper, final zzad zzaHE) {
        this.zzaHF = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
        this.zzaHG = new ArrayList<GoogleApiClient.ConnectionCallbacks>();
        this.zzaHH = new ArrayList<GoogleApiClient.OnConnectionFailedListener>();
        this.zzaHI = false;
        this.zzaHJ = new AtomicInteger(0);
        this.zzaHK = false;
        this.mLock = new Object();
        this.zzaHE = zzaHE;
        this.mHandler = new Handler(looper, (Handler$Callback)this);
    }
    
    public final boolean handleMessage(final Message message) {
        if (message.what == 1) {
            final GoogleApiClient.ConnectionCallbacks o = (GoogleApiClient.ConnectionCallbacks)message.obj;
            synchronized (this.mLock) {
                if (this.zzaHI && this.zzaHE.isConnected() && this.zzaHF.contains(o)) {
                    o.onConnected(this.zzaHE.zzoC());
                }
                return true;
            }
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), (Throwable)new Exception());
        return false;
    }
    
    public final boolean isConnectionCallbacksRegistered(final GoogleApiClient.ConnectionCallbacks o) {
        zzbo.zzu(o);
        synchronized (this.mLock) {
            return this.zzaHF.contains(o);
        }
    }
    
    public final boolean isConnectionFailedListenerRegistered(final GoogleApiClient.OnConnectionFailedListener o) {
        zzbo.zzu(o);
        synchronized (this.mLock) {
            return this.zzaHH.contains(o);
        }
    }
    
    public final void registerConnectionCallbacks(final GoogleApiClient.ConnectionCallbacks e) {
        zzbo.zzu(e);
        synchronized (this.mLock) {
            if (this.zzaHF.contains(e)) {
                final String value = String.valueOf(e);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(value).length() + 62).append("registerConnectionCallbacks(): listener ").append(value).append(" is already registered").toString());
            }
            else {
                this.zzaHF.add(e);
            }
            // monitorexit(this.mLock)
            if (this.zzaHE.isConnected()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)e));
            }
        }
    }
    
    public final void registerConnectionFailedListener(final GoogleApiClient.OnConnectionFailedListener e) {
        zzbo.zzu(e);
        synchronized (this.mLock) {
            if (this.zzaHH.contains(e)) {
                final String value = String.valueOf(e);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(value).length() + 67).append("registerConnectionFailedListener(): listener ").append(value).append(" is already registered").toString());
            }
            else {
                this.zzaHH.add(e);
            }
        }
    }
    
    public final void unregisterConnectionCallbacks(final GoogleApiClient.ConnectionCallbacks e) {
        zzbo.zzu(e);
        synchronized (this.mLock) {
            if (!this.zzaHF.remove(e)) {
                final String value = String.valueOf(e);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(value).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(value).append(" not found").toString());
            }
            else if (this.zzaHK) {
                this.zzaHG.add(e);
            }
        }
    }
    
    public final void unregisterConnectionFailedListener(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzbo.zzu(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (!this.zzaHH.remove(onConnectionFailedListener)) {
                final String value = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(value).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(value).append(" not found").toString());
            }
        }
    }
    
    public final void zzaA(final int n) {
        int i = 0;
        // monitorexit(o2)
        while (true) {
            Label_0162: {
                if (Looper.myLooper() != this.mHandler.getLooper()) {
                    break Label_0162;
                }
                final boolean b = true;
                zzbo.zza(b, (Object)"onUnintentionalDisconnection must only be called on the Handler thread");
                this.mHandler.removeMessages(1);
                Label_0168: {
                    synchronized (this.mLock) {
                        this.zzaHK = true;
                        final ArrayList<Object> list = new ArrayList<Object>(this.zzaHF);
                        final int value = this.zzaHJ.get();
                        final ArrayList<Object> list2 = list;
                        while (i < list2.size()) {
                            final Object value2 = list2.get(i);
                            final int n2 = i + 1;
                            final GoogleApiClient.ConnectionCallbacks o = (GoogleApiClient.ConnectionCallbacks)value2;
                            if (!this.zzaHI || this.zzaHJ.get() != value) {
                                break;
                            }
                            i = n2;
                            if (!this.zzaHF.contains(o)) {
                                continue;
                            }
                            o.onConnectionSuspended(n);
                            i = n2;
                        }
                        break Label_0168;
                    }
                    break Label_0162;
                }
                this.zzaHG.clear();
                this.zzaHK = false;
                return;
            }
            final boolean b = false;
            continue;
        }
    }
    
    public final void zzk(final ConnectionResult connectionResult) {
        int i = 0;
        zzbo.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object)"onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            final ArrayList<Object> list = new ArrayList<Object>(this.zzaHH);
            final int value = this.zzaHJ.get();
            final ArrayList<Object> list2 = list;
            while (i < list2.size()) {
                final Object value2 = list2.get(i);
                final int n = i + 1;
                final GoogleApiClient.OnConnectionFailedListener o = (GoogleApiClient.OnConnectionFailedListener)value2;
                if (!this.zzaHI || this.zzaHJ.get() != value) {
                    return;
                }
                i = n;
                if (!this.zzaHH.contains(o)) {
                    continue;
                }
                o.onConnectionFailed(connectionResult);
                i = n;
            }
        }
    }
    // monitorexit(o2)
    
    public final void zzn(final Bundle bundle) {
        final boolean b = true;
        int i = 0;
        // monitorexit(o2)
        while (true) {
            Label_0209: {
                if (Looper.myLooper() != this.mHandler.getLooper()) {
                    break Label_0209;
                }
                final boolean b2 = true;
                boolean b3;
                boolean b4;
                ArrayList<Object> list;
                int value;
                ArrayList<Object> list2;
                Object value2;
                int n;
                GoogleApiClient.ConnectionCallbacks o;
                Label_0047_Outer:Label_0079_Outer:
                while (true) {
                    zzbo.zza(b2, (Object)"onConnectionSuccess must only be called on the Handler thread");
                    while (true) {
                    Label_0221:
                        while (true) {
                            Label_0215: {
                                synchronized (this.mLock) {
                                    if (this.zzaHK) {
                                        break Label_0215;
                                    }
                                    b3 = true;
                                    zzbo.zzae(b3);
                                    this.mHandler.removeMessages(1);
                                    this.zzaHK = true;
                                    if (this.zzaHG.size() == 0) {
                                        b4 = b;
                                        zzbo.zzae(b4);
                                        list = new ArrayList<Object>(this.zzaHF);
                                        value = this.zzaHJ.get();
                                        list2 = list;
                                        while (i < list2.size()) {
                                            value2 = list2.get(i);
                                            n = i + 1;
                                            o = (GoogleApiClient.ConnectionCallbacks)value2;
                                            if (!this.zzaHI || !this.zzaHE.isConnected() || this.zzaHJ.get() != value) {
                                                break;
                                            }
                                            i = n;
                                            if (this.zzaHG.contains(o)) {
                                                continue Label_0047_Outer;
                                            }
                                            o.onConnected(bundle);
                                            i = n;
                                        }
                                        break;
                                    }
                                    break Label_0221;
                                }
                                break Label_0209;
                            }
                            b3 = false;
                            continue Label_0079_Outer;
                        }
                        b4 = false;
                        continue;
                    }
                }
                this.zzaHG.clear();
                this.zzaHK = false;
                return;
            }
            final boolean b2 = false;
            continue;
        }
    }
    
    public final void zzrA() {
        this.zzaHI = true;
    }
    
    public final void zzrz() {
        this.zzaHI = false;
        this.zzaHJ.incrementAndGet();
    }
}
