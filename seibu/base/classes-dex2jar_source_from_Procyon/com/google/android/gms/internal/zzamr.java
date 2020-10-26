// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzamr implements Runnable
{
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzamp zzago;
    
    zzamr(final zzamp zzago, final ComponentName val$name) {
        this.zzago = zzago;
        this.val$name = val$name;
    }
    
    @Override
    public final void run() {
        this.zzago.zzagk.onServiceDisconnected(this.val$name);
    }
}
