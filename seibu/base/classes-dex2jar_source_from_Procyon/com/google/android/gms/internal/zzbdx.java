// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzbdx extends Handler
{
    private /* synthetic */ zzbdw zzaEO;
    
    public zzbdx(final zzbdw zzaEO, final Looper looper) {
        this.zzaEO = zzaEO;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        boolean b = true;
        if (message.what != 1) {
            b = false;
        }
        zzbo.zzaf(b);
        this.zzaEO.zzb((zzbdz)message.obj);
    }
}
