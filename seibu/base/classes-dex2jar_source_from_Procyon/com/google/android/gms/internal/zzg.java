// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzg implements zzx
{
    private int zzn;
    private int zzo;
    private final int zzp;
    private final float zzq;
    
    public zzg() {
        this(2500, 1, 1.0f);
    }
    
    private zzg(final int n, final int n2, final float n3) {
        this.zzn = 2500;
        this.zzp = 1;
        this.zzq = 1.0f;
    }
    
    @Override
    public final int zza() {
        return this.zzn;
    }
    
    @Override
    public final void zza(final zzaa zzaa) throws zzaa {
        ++this.zzo;
        this.zzn += (int)(this.zzn * this.zzq);
        int n;
        if (this.zzo <= this.zzp) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            throw zzaa;
        }
    }
    
    @Override
    public final int zzb() {
        return this.zzo;
    }
}
