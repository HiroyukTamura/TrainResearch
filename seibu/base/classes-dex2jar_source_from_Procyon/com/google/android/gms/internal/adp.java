// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public abstract class adp
{
    protected volatile int zzcsx;
    
    public adp() {
        this.zzcsx = -1;
    }
    
    public static final <T extends adp> T zza(final T t, final byte[] array) throws ado {
        return zza(t, array, 0, array.length);
    }
    
    private static <T extends adp> T zza(final T t, final byte[] array, final int n, final int n2) throws ado {
        try {
            final adg zzb = adg.zzb(array, 0, n2);
            t.zza(zzb);
            zzb.zzcl(0);
            return t;
        }
        catch (ado ado) {
            throw ado;
        }
        catch (IOException ex) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
    
    public static final byte[] zzc(final adp adp) {
        final byte[] array = new byte[adp.zzLV()];
        final int length = array.length;
        try {
            final adh zzc = adh.zzc(array, 0, length);
            adp.zza(zzc);
            zzc.zzLM();
            return array;
        }
        catch (IOException cause) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", cause);
        }
    }
    
    @Override
    public String toString() {
        return adq.zzd(this);
    }
    
    public adp zzLO() throws CloneNotSupportedException {
        return (adp)super.clone();
    }
    
    public final int zzLU() {
        if (this.zzcsx < 0) {
            this.zzLV();
        }
        return this.zzcsx;
    }
    
    public final int zzLV() {
        return this.zzcsx = this.zzn();
    }
    
    public abstract adp zza(final adg p0) throws IOException;
    
    public void zza(final adh adh) throws IOException {
    }
    
    protected int zzn() {
        return 0;
    }
}
