// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class ael extends adj<ael> implements Cloneable
{
    private int zzcuk;
    private int zzcul;
    
    public ael() {
        this.zzcuk = -1;
        this.zzcul = 0;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    private ael zzMg() {
        try {
            return super.zzLN();
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof ael)) {
                return false;
            }
            final ael ael = (ael)o;
            if (this.zzcuk != ael.zzcuk) {
                return false;
            }
            if (this.zzcul != ael.zzcul) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(ael.zzcso);
            }
            if (ael.zzcso != null && !ael.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int zzcuk = this.zzcuk;
        final int zzcul = this.zzcul;
        int hashCode2;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzcso.hashCode();
        }
        return hashCode2 + (((hashCode + 527) * 31 + zzcuk) * 31 + zzcul) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzcuk != -1) {
            adh.zzr(1, this.zzcuk);
        }
        if (this.zzcul != 0) {
            adh.zzr(2, this.zzcul);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzcuk != -1) {
            zzn = n + adh.zzs(1, this.zzcuk);
        }
        int n2 = zzn;
        if (this.zzcul != 0) {
            n2 = zzn + adh.zzs(2, this.zzcul);
        }
        return n2;
    }
}
