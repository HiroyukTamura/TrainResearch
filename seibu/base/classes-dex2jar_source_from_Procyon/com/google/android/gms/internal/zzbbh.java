// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;

final class zzbbh
{
    private /* synthetic */ zzbbe zzaCi;
    
    private zzbbh(final zzbbe zzaCi) {
        this.zzaCi = zzaCi;
    }
    
    @Override
    protected final void finalize() throws Throwable {
        zzbbe.zzc(this.zzaCi.zzaBj);
        super.finalize();
    }
}
