// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzm extends Handler
{
    private /* synthetic */ zzl zzckJ;
    
    zzm(final zzl zzckJ, final Looper looper) {
        this.zzckJ = zzckJ;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        this.zzckJ.zzc(message);
    }
}
