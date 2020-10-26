// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;

final class zzbbu implements zza
{
    private /* synthetic */ zzbbe zzaCT;
    private /* synthetic */ zzbbt zzaCU;
    
    zzbbu(final zzbbt zzaCU, final zzbbe zzaCT) {
        this.zzaCU = zzaCU;
        this.zzaCT = zzaCT;
    }
    
    @Override
    public final void zzo(final Status status) {
        this.zzaCU.zzaCR.remove(this.zzaCT);
    }
}
