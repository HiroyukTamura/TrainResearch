// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing
{
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static int MAX_TABLE_SIZE;
    
    static {
        Hashing.MAX_TABLE_SIZE = 1073741824;
    }
    
    private Hashing() {
    }
    
    static int closedTableSize(int max, final double n) {
        max = Math.max(max, 2);
        final int highestOneBit = Integer.highestOneBit(max);
        if (max <= (int)(highestOneBit * n)) {
            return highestOneBit;
        }
        max = highestOneBit << 1;
        if (max > 0) {
            return max;
        }
        return Hashing.MAX_TABLE_SIZE;
    }
    
    static boolean needsResizing(final int n, final int n2, final double n3) {
        return n > n2 * n3 && n2 < Hashing.MAX_TABLE_SIZE;
    }
    
    static int smear(final int n) {
        return 461845907 * Integer.rotateLeft(-862048943 * n, 15);
    }
    
    static int smearedHash(@Nullable final Object o) {
        int hashCode;
        if (o == null) {
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
        }
        return smear(hashCode);
    }
}
