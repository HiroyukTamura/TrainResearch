// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.ConnectionResult;

final class zzbbb
{
    private final int zzaBP;
    private final ConnectionResult zzaBQ;
    
    zzbbb(final ConnectionResult zzaBQ, final int zzaBP) {
        zzbo.zzu(zzaBQ);
        this.zzaBQ = zzaBQ;
        this.zzaBP = zzaBP;
    }
    
    final int zzpy() {
        return this.zzaBP;
    }
    
    final ConnectionResult zzpz() {
        return this.zzaBQ;
    }
}
