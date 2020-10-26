// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbbe;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbq;

final class zzae implements zzdi<zzbq>
{
    private /* synthetic */ zzy zzbDX;
    
    private zzae(final zzy zzbDX) {
        this.zzbDX = zzbDX;
    }
    
    @Override
    public final void zzbw(final int n) {
        if (n == zzda.zzbFk) {
            this.zzbDX.zzbDO.zzAU();
        }
        synchronized (this.zzbDX) {
            if (!this.zzbDX.isReady()) {
                if (this.zzbDX.zzbDR != null) {
                    ((zzbbe<zzv>)this.zzbDX).setResult(this.zzbDX.zzbDR);
                }
                else {
                    this.zzbDX.setResult(this.zzbDX.zzI(Status.zzaBp));
                }
            }
            // monitorexit(this.zzbDX)
            this.zzbDX.zzag(this.zzbDX.zzbDO.zzAT());
        }
    }
}
