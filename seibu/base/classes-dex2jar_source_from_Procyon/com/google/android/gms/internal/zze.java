// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zze implements Runnable
{
    private /* synthetic */ zzp zzl;
    private /* synthetic */ zzd zzm;
    
    zze(final zzd zzm, final zzp zzl) {
        this.zzm = zzm;
        this.zzl = zzl;
    }
    
    @Override
    public final void run() {
        try {
            this.zzm.zzh.put(this.zzl);
        }
        catch (InterruptedException ex) {}
    }
}
