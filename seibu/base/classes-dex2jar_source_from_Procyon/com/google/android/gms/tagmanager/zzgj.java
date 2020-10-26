// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

final class zzgj extends Number implements Comparable<zzgj>
{
    private double zzbHb;
    private long zzbHc;
    private boolean zzbHd;
    
    private zzgj(final double zzbHb) {
        this.zzbHb = zzbHb;
        this.zzbHd = false;
    }
    
    private zzgj(final long zzbHc) {
        this.zzbHc = zzbHc;
        this.zzbHd = true;
    }
    
    public static zzgj zza(final Double n) {
        return new zzgj(n);
    }
    
    public static zzgj zzai(final long n) {
        return new zzgj(n);
    }
    
    public static zzgj zzfx(final String obj) throws NumberFormatException {
        try {
            return new zzgj(Long.parseLong(obj));
        }
        catch (NumberFormatException ex) {
            try {
                return new zzgj(Double.parseDouble(obj));
            }
            catch (NumberFormatException ex2) {
                throw new NumberFormatException(String.valueOf(obj).concat(" is not a valid TypedNumber"));
            }
        }
    }
    
    @Override
    public final byte byteValue() {
        return (byte)this.longValue();
    }
    
    @Override
    public final double doubleValue() {
        if (this.zzbHd) {
            return (double)this.zzbHc;
        }
        return this.zzbHb;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof zzgj && this.zza((zzgj)o) == 0;
    }
    
    @Override
    public final float floatValue() {
        return (float)this.doubleValue();
    }
    
    @Override
    public final int hashCode() {
        return new Long(this.longValue()).hashCode();
    }
    
    @Override
    public final int intValue() {
        return (int)this.longValue();
    }
    
    @Override
    public final long longValue() {
        if (this.zzbHd) {
            return this.zzbHc;
        }
        return (long)this.zzbHb;
    }
    
    @Override
    public final short shortValue() {
        return (short)this.longValue();
    }
    
    @Override
    public final String toString() {
        if (this.zzbHd) {
            return Long.toString(this.zzbHc);
        }
        return Double.toString(this.zzbHb);
    }
    
    public final boolean zzBZ() {
        return !this.zzbHd;
    }
    
    public final boolean zzCa() {
        return this.zzbHd;
    }
    
    public final int zza(final zzgj zzgj) {
        if (this.zzbHd && zzgj.zzbHd) {
            return new Long(this.zzbHc).compareTo(zzgj.zzbHc);
        }
        return Double.compare(this.doubleValue(), zzgj.doubleValue());
    }
}
