// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzbch extends zzbcy
{
    private /* synthetic */ ConnectionResult zzaDs;
    private /* synthetic */ zzbcg zzaDt;
    
    zzbch(final zzbcg zzaDt, final zzbcw zzbcw, final ConnectionResult zzaDs) {
        this.zzaDt = zzaDt;
        this.zzaDs = zzaDs;
        super(zzbcw);
    }
    
    public final void zzpV() {
        this.zzaDt.zzaDp.zze(this.zzaDs);
    }
}
