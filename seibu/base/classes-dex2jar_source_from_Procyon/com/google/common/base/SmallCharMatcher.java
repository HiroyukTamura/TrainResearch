// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import java.util.BitSet;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible("no precomputation is done in GWT")
final class SmallCharMatcher extends FastMatcher
{
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;
    
    private SmallCharMatcher(final char[] table, final long filter, final boolean containsZero, final String s) {
        super(s);
        this.table = table;
        this.filter = filter;
        this.containsZero = containsZero;
    }
    
    private boolean checkFilter(final int n) {
        return 0x1L == (this.filter >> n & 0x1L);
    }
    
    @VisibleForTesting
    static int chooseTableSize(final int n) {
        int n2;
        if (n == 1) {
            n2 = 2;
        }
        else {
            int n3 = Integer.highestOneBit(n - 1) << 1;
            while (true) {
                n2 = n3;
                if (n3 * 0.5 >= n) {
                    break;
                }
                n3 <<= 1;
            }
        }
        return n2;
    }
    
    static CharMatcher from(final BitSet set, final String s) {
        long n = 0L;
        final int cardinality = set.cardinality();
        final boolean value = set.get(0);
        final char[] array = new char[chooseTableSize(cardinality)];
        final int n2 = array.length - 1;
        for (int i = set.nextSetBit(0); i != -1; i = set.nextSetBit(i + 1)) {
            n |= 1L << i;
            int n3;
            for (n3 = (smear(i) & n2); array[n3] != '\0'; n3 = (n3 + 1 & n2)) {}
            array[n3] = (char)i;
        }
        return new SmallCharMatcher(array, n, value, s);
    }
    
    static int smear(final int n) {
        return 461845907 * Integer.rotateLeft(-862048943 * n, 15);
    }
    
    @Override
    public boolean matches(final char c) {
        final boolean b = false;
        boolean containsZero;
        if (c == '\0') {
            containsZero = this.containsZero;
        }
        else {
            containsZero = b;
            if (this.checkFilter(c)) {
                final int n = this.table.length - 1;
                int n2 = 0;
                do {
                    containsZero = b;
                    if (this.table[n2] == '\0') {
                        return containsZero;
                    }
                    if (this.table[n2] == c) {
                        return true;
                    }
                } while ((n2 = (n2 + 1 & n)) != (n2 = (smear(c) & n)));
                return false;
            }
        }
        return containsZero;
    }
    
    @Override
    void setBits(final BitSet set) {
        if (this.containsZero) {
            set.set(0);
        }
        final char[] table = this.table;
        for (int length = table.length, i = 0; i < length; ++i) {
            final char bitIndex = table[i];
            if (bitIndex != '\0') {
                set.set(bitIndex);
            }
        }
    }
}
