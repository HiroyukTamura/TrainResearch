// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzcb implements Runnable
{
    private /* synthetic */ zzbz zzbEU;
    private /* synthetic */ long zzbEV;
    private /* synthetic */ zzca zzbEW;
    private /* synthetic */ String zzsD;
    
    zzcb(final zzca zzbEW, final zzbz zzbEU, final long zzbEV, final String zzsD) {
        this.zzbEW = zzbEW;
        this.zzbEU = zzbEU;
        this.zzbEV = zzbEV;
        this.zzsD = zzsD;
    }
    
    @Override
    public final void run() {
        if (this.zzbEW.zzbET == null) {
            final zzfo zzBV = zzfo.zzBV();
            zzBV.zza(this.zzbEW.mContext, this.zzbEU);
            this.zzbEW.zzbET = zzBV.zzBW();
        }
        this.zzbEW.zzbET.zzb(this.zzbEV, this.zzsD);
    }
}
