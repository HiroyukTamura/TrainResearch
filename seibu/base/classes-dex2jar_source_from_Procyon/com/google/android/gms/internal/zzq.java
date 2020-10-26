// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzq implements Runnable
{
    private /* synthetic */ String zzO;
    private /* synthetic */ long zzP;
    private /* synthetic */ zzp zzQ;
    
    zzq(final zzp zzQ, final String zzO, final long zzP) {
        this.zzQ = zzQ;
        this.zzO = zzO;
        this.zzP = zzP;
    }
    
    @Override
    public final void run() {
        this.zzQ.zzB.zza(this.zzO, this.zzP);
        this.zzQ.zzB.zzc(this.toString());
    }
}
