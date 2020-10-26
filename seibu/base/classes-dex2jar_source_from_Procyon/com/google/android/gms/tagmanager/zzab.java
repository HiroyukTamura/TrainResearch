// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzab implements zzac
{
    private /* synthetic */ zzy zzbDX;
    private Long zzbDY;
    private /* synthetic */ boolean zzbDZ;
    
    zzab(final zzy zzbDX, final boolean zzbDZ) {
        this.zzbDX = zzbDX;
        this.zzbDZ = zzbDZ;
    }
    
    @Override
    public final boolean zzb(final Container container) {
        if (this.zzbDZ) {
            final long lastRefreshTime = container.getLastRefreshTime();
            if (this.zzbDY == null) {
                this.zzbDY = this.zzbDX.zzbDO.zzAS();
            }
            if (lastRefreshTime + this.zzbDY < this.zzbDX.zzvw.currentTimeMillis()) {
                return false;
            }
        }
        else if (container.isDefault()) {
            return false;
        }
        return true;
    }
}
