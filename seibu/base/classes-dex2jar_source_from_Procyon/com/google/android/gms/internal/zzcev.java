// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

final class zzcev
{
    final String mAppId;
    final String mName;
    final long zzbpG;
    final long zzbpH;
    final long zzbpI;
    
    zzcev(final String mAppId, final String mName, final long zzbpG, final long zzbpH, final long zzbpI) {
        final boolean b = true;
        zzbo.zzcF(mAppId);
        zzbo.zzcF(mName);
        zzbo.zzaf(zzbpG >= 0L);
        zzbo.zzaf(zzbpH >= 0L && b);
        this.mAppId = mAppId;
        this.mName = mName;
        this.zzbpG = zzbpG;
        this.zzbpH = zzbpH;
        this.zzbpI = zzbpI;
    }
    
    final zzcev zzab(final long n) {
        return new zzcev(this.mAppId, this.mName, this.zzbpG, this.zzbpH, n);
    }
    
    final zzcev zzys() {
        return new zzcev(this.mAppId, this.mName, this.zzbpG + 1L, this.zzbpH + 1L, this.zzbpI);
    }
}
