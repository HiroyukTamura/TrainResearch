// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public class zzaa extends Exception
{
    private long zzA;
    private zzn zzah;
    
    public zzaa() {
        this.zzah = null;
    }
    
    public zzaa(final zzn zzah) {
        this.zzah = zzah;
    }
    
    public zzaa(final Throwable cause) {
        super(cause);
        this.zzah = null;
    }
    
    final void zza(final long zzA) {
        this.zzA = zzA;
    }
}
