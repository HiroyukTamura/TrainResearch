// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcjh extends zzcer
{
    private /* synthetic */ zzcjg zzbux;
    
    zzcjh(final zzcjg zzbux, final zzcgl zzcgl) {
        this.zzbux = zzbux;
        super(zzcgl);
    }
    
    @Override
    public final void run() {
        this.zzbux.zzwF().zzyD().log("Sending upload intent from DelayedRunnable");
        this.zzbux.zzzr();
    }
}
