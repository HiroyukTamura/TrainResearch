// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Arrays;

final class adr
{
    final int tag;
    final byte[] zzbws;
    
    adr(final int tag, final byte[] zzbws) {
        this.tag = tag;
        this.zzbws = zzbws;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof adr)) {
                return false;
            }
            final adr adr = (adr)o;
            if (this.tag != adr.tag || !Arrays.equals(this.zzbws, adr.zzbws)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return (this.tag + 527) * 31 + Arrays.hashCode(this.zzbws);
    }
}
