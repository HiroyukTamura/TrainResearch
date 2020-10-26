// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbm extends adj<zzbm>
{
    private static volatile zzbm[] zzkM;
    public int key;
    public int value;
    
    public zzbm() {
        this.key = 0;
        this.value = 0;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbm[] zzr() {
        Label_0027: {
            if (zzbm.zzkM != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbm.zzkM == null) {
                    zzbm.zzkM = new zzbm[0];
                }
                return zzbm.zzkM;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbm)) {
                return false;
            }
            final zzbm zzbm = (zzbm)o;
            if (this.key != zzbm.key) {
                return false;
            }
            if (this.value != zzbm.value) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbm.zzcso);
            }
            if (zzbm.zzcso != null && !zzbm.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int key = this.key;
        final int value = this.value;
        int hashCode2;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzcso.hashCode();
        }
        return hashCode2 + (((hashCode + 527) * 31 + key) * 31 + value) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        adh.zzr(1, this.key);
        adh.zzr(2, this.value);
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        return super.zzn() + adh.zzs(1, this.key) + adh.zzs(2, this.value);
    }
}
