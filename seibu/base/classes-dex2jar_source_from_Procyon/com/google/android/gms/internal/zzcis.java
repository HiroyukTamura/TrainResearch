// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzcis implements Runnable
{
    private /* synthetic */ ComponentName val$name;
    private /* synthetic */ zzciq zzbuk;
    
    zzcis(final zzciq zzbuk, final ComponentName val$name) {
        this.zzbuk = zzbuk;
        this.val$name = val$name;
    }
    
    @Override
    public final void run() {
        this.zzbuk.zzbua.onServiceDisconnected(this.val$name);
    }
}
