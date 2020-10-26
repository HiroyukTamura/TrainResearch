// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzbcz extends Handler
{
    private /* synthetic */ zzbcx zzaEa;
    
    zzbcz(final zzbcx zzaEa, final Looper looper) {
        this.zzaEa = zzaEa;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
            }
            case 1: {
                ((zzbcy)message.obj).zzc(this.zzaEa);
            }
            case 2: {
                throw (RuntimeException)message.obj;
            }
        }
    }
}
