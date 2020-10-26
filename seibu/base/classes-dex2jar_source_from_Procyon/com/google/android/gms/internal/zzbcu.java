// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzbcu extends Handler
{
    private /* synthetic */ zzbcp zzaDN;
    
    zzbcu(final zzbcp zzaDN, final Looper looper) {
        this.zzaDN = zzaDN;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
            }
            case 1: {
                this.zzaDN.zzqd();
            }
            case 2: {
                this.zzaDN.resume();
            }
        }
    }
}
