// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcgm implements Runnable
{
    private /* synthetic */ zzcgl zzbsY;
    
    zzcgm(final zzcgl zzbsY) {
        this.zzbsY = zzbsY;
    }
    
    @Override
    public final void run() {
        this.zzbsY.start();
    }
}
