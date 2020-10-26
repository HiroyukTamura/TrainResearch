// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcii extends zzcer
{
    private /* synthetic */ zzcid zzbua;
    
    zzcii(final zzcid zzbua, final zzcgl zzcgl) {
        this.zzbua = zzbua;
        super(zzcgl);
    }
    
    @Override
    public final void run() {
        this.zzbua.zzwF().zzyz().log("Tasks have been queued for a long time");
    }
}
