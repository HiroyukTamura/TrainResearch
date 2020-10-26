// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzbdy<L>
{
    private final L mListener;
    private final String zzaEP;
    
    zzbdy(final L mListener, final String zzaEP) {
        this.mListener = mListener;
        this.zzaEP = zzaEP;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof zzbdy)) {
                return false;
            }
            final zzbdy zzbdy = (zzbdy)o;
            if (this.mListener != zzbdy.mListener || !this.zzaEP.equals(zzbdy.zzaEP)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return System.identityHashCode(this.mListener) * 31 + this.zzaEP.hashCode();
    }
}
