// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.ServiceConnection;
import android.content.ComponentName;
import android.util.Log;
import android.os.Message;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import android.os.Handler;
import android.content.Context;
import android.os.Handler$Callback;

final class zzag extends zzae implements Handler$Callback
{
    private final Context mApplicationContext;
    private final Handler mHandler;
    private final HashMap<zzaf, zzah> zzaHP;
    private final zza zzaHQ;
    private final long zzaHR;
    private final long zzaHS;
    
    zzag(final Context context) {
        this.zzaHP = new HashMap<zzaf, zzah>();
        this.mApplicationContext = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), (Handler$Callback)this);
        this.zzaHQ = zza.zzrU();
        this.zzaHR = 5000L;
        this.zzaHS = 300000L;
    }
    
    public final boolean handleMessage(final Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: {
                synchronized (this.zzaHP) {
                    final zzaf zzaf = (zzaf)message.obj;
                    final zzah zzah = this.zzaHP.get(zzaf);
                    if (zzah != null && zzah.zzrC()) {
                        if (zzah.isBound()) {
                            zzah.zzcC("GmsClientSupervisor");
                        }
                        this.zzaHP.remove(zzaf);
                    }
                    return true;
                }
            }
            case 1: {
                while (true) {
                    while (true) {
                        Label_0243: {
                            synchronized (this.zzaHP) {
                                final zzaf zzaf2 = (zzaf)message.obj;
                                final zzah zzah2 = this.zzaHP.get(zzaf2);
                                if (zzah2 != null && zzah2.getState() == 3) {
                                    final String value = String.valueOf(zzaf2);
                                    Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(value).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(value).toString(), (Throwable)new Exception());
                                    ComponentName componentName;
                                    if ((componentName = zzah2.getComponentName()) == null) {
                                        componentName = zzaf2.getComponentName();
                                    }
                                    if (componentName != null) {
                                        break Label_0243;
                                    }
                                    final ComponentName componentName2 = new ComponentName(zzaf2.getPackage(), "unknown");
                                    zzah2.onServiceDisconnected(componentName2);
                                }
                                return true;
                            }
                        }
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    protected final boolean zza(final zzaf obj, final ServiceConnection serviceConnection, final String s) {
        while (true) {
            zzbo.zzb(serviceConnection, "ServiceConnection must not be null");
            while (true) {
                zzah value;
                synchronized (this.zzaHP) {
                    value = this.zzaHP.get(obj);
                    if (value == null) {
                        value = new zzah(this, obj);
                        value.zza(serviceConnection, s);
                        value.zzcB(s);
                        this.zzaHP.put(obj, value);
                        final zzah zzah = value;
                        return zzah.isBound();
                    }
                    this.mHandler.removeMessages(0, (Object)obj);
                    if (value.zza(serviceConnection)) {
                        final String value2 = String.valueOf(obj);
                        throw new IllegalStateException(new StringBuilder(String.valueOf(value2).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(value2).toString());
                    }
                }
                value.zza(serviceConnection, s);
                switch (value.getState()) {
                    case 1: {
                        serviceConnection.onServiceConnected(value.getComponentName(), value.getBinder());
                        final zzah zzah = value;
                        continue;
                    }
                    case 2: {
                        value.zzcB(s);
                        final zzah zzah = value;
                        continue;
                    }
                    default: {
                        final zzah zzah = value;
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    protected final void zzb(final zzaf zzaf, final ServiceConnection serviceConnection, final String s) {
        zzbo.zzb(serviceConnection, "ServiceConnection must not be null");
        final zzah zzah;
        synchronized (this.zzaHP) {
            zzah = this.zzaHP.get(zzaf);
            if (zzah == null) {
                final String value = String.valueOf(zzaf);
                throw new IllegalStateException(new StringBuilder(String.valueOf(value).length() + 50).append("Nonexistent connection status for service config: ").append(value).toString());
            }
        }
        final Throwable obj;
        if (!zzah.zza(serviceConnection)) {
            final String value2 = String.valueOf(obj);
            throw new IllegalStateException(new StringBuilder(String.valueOf(value2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(value2).toString());
        }
        zzah.zzb(serviceConnection, s);
        if (zzah.zzrC()) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, (Object)obj), this.zzaHR);
        }
    }
    // monitorexit(hashMap)
}
