// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class zzay
{
    final String zzBN;
    final byte[] zzbEw;
    
    zzay(final String zzBN, final byte[] zzbEw) {
        this.zzBN = zzBN;
        this.zzbEw = zzbEw;
    }
    
    @Override
    public final String toString() {
        final String zzBN = this.zzBN;
        return new StringBuilder(String.valueOf(zzBN).length() + 54).append("KeyAndSerialized: key = ").append(zzBN).append(" serialized hash = ").append(Arrays.hashCode(this.zzbEw)).toString();
    }
}
