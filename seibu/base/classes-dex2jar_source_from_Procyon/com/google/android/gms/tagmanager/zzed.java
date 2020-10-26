// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzed implements zzfx
{
    private /* synthetic */ zzec zzbFA;
    
    zzed(final zzec zzbFA) {
        this.zzbFA = zzbFA;
    }
    
    @Override
    public final void zza(final zzbx zzbx) {
        this.zzbFA.zzp(zzbx.zzBm());
    }
    
    @Override
    public final void zzb(final zzbx zzbx) {
        this.zzbFA.zzp(zzbx.zzBm());
        zzdj.v(new StringBuilder(57).append("Permanent failure dispatching hitId: ").append(zzbx.zzBm()).toString());
    }
    
    @Override
    public final void zzc(final zzbx zzbx) {
        final long zzBn = zzbx.zzBn();
        if (zzBn == 0L) {
            this.zzbFA.zzh(zzbx.zzBm(), this.zzbFA.zzvw.currentTimeMillis());
        }
        else if (zzBn + 14400000L < this.zzbFA.zzvw.currentTimeMillis()) {
            this.zzbFA.zzp(zzbx.zzBm());
            zzdj.v(new StringBuilder(47).append("Giving up on failed hitId: ").append(zzbx.zzBm()).toString());
        }
    }
}
