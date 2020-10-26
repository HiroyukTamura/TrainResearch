// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Message;
import android.os.Handler$Callback;
import android.os.Handler;

final class zzfs implements zzfr
{
    private Handler handler;
    final /* synthetic */ zzfo zzbGP;
    
    private zzfs(final zzfo zzbGP) {
        this.zzbGP = zzbGP;
        this.handler = new Handler(this.zzbGP.zzbGD.getMainLooper(), (Handler$Callback)new zzft(this));
    }
    
    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfo.zzbGC);
    }
    
    @Override
    public final void cancel() {
        this.handler.removeMessages(1, zzfo.zzbGC);
    }
    
    @Override
    public final void zzBY() {
        this.handler.removeMessages(1, zzfo.zzbGC);
        this.handler.sendMessage(this.obtainMessage());
    }
    
    @Override
    public final void zzs(final long n) {
        this.handler.removeMessages(1, zzfo.zzbGC);
        this.handler.sendMessageDelayed(this.obtainMessage(), n);
    }
}
