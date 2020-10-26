// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.zze;

final class zzbce implements Runnable
{
    private /* synthetic */ zzbcd zzaDp;
    
    zzbce(final zzbcd zzaDp) {
        this.zzaDp = zzaDp;
    }
    
    @Override
    public final void run() {
        zze.zzat(this.zzaDp.mContext);
    }
}
