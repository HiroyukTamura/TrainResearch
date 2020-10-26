// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbi extends adj<zzbi>
{
    private int level;
    private int zzkx;
    private int zzky;
    
    public zzbi() {
        this.level = 1;
        this.zzkx = 0;
        this.zzky = 0;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbi)) {
                return false;
            }
            final zzbi zzbi = (zzbi)o;
            if (this.level != zzbi.level) {
                return false;
            }
            if (this.zzkx != zzbi.zzkx) {
                return false;
            }
            if (this.zzky != zzbi.zzky) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbi.zzcso);
            }
            if (zzbi.zzcso != null && !zzbi.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int level = this.level;
        final int zzkx = this.zzkx;
        final int zzky = this.zzky;
        int hashCode2;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzcso.hashCode();
        }
        return hashCode2 + ((((hashCode + 527) * 31 + level) * 31 + zzkx) * 31 + zzky) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.level != 1) {
            adh.zzr(1, this.level);
        }
        if (this.zzkx != 0) {
            adh.zzr(2, this.zzkx);
        }
        if (this.zzky != 0) {
            adh.zzr(3, this.zzky);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.level != 1) {
            zzn = n + adh.zzs(1, this.level);
        }
        int n2 = zzn;
        if (this.zzkx != 0) {
            n2 = zzn + adh.zzs(2, this.zzkx);
        }
        int n3 = n2;
        if (this.zzky != 0) {
            n3 = n2 + adh.zzs(3, this.zzky);
        }
        return n3;
    }
}
