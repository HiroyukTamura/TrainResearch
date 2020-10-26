// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import java.util.Arrays;

final class zzh extends zzg
{
    private final byte[] zzaAh;
    
    zzh(final byte[] array) {
        super(Arrays.copyOfRange(array, 0, 25));
        this.zzaAh = array;
    }
    
    @Override
    final byte[] getBytes() {
        return this.zzaAh;
    }
}
