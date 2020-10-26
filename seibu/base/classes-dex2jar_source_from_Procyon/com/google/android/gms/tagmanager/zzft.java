// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Message;
import android.os.Handler$Callback;

final class zzft implements Handler$Callback
{
    private /* synthetic */ zzfs zzbGQ;
    
    zzft(final zzfs zzbGQ) {
        this.zzbGQ = zzbGQ;
    }
    
    public final boolean handleMessage(final Message message) {
        if (1 == message.what && zzfo.zzbGC.equals(message.obj)) {
            this.zzbGQ.zzbGP.dispatch();
            if (!this.zzbGQ.zzbGP.isPowerSaveMode()) {
                this.zzbGQ.zzs(this.zzbGQ.zzbGP.zzbGG);
            }
        }
        return true;
    }
}
