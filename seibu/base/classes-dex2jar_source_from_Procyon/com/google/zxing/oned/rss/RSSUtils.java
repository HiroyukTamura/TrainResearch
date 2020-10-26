// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss;

public final class RSSUtils
{
    private RSSUtils() {
    }
    
    private static int combins(int n, int n2) {
        int n3;
        int n4;
        if (n - n2 > n2) {
            n3 = n2;
            n4 = n - n2;
        }
        else {
            n3 = n - n2;
            n4 = n2;
        }
        n2 = 1;
        final int n5 = 1;
        int n6 = n;
        n = n5;
        int i;
        int n7;
        while (true) {
            i = n;
            n7 = n2;
            if (n6 <= n4) {
                break;
            }
            final int n8 = n2 * n6;
            int n9 = n;
            n2 = n8;
            if (n <= n3) {
                n2 = n8 / n;
                n9 = n + 1;
            }
            --n6;
            n = n9;
        }
        while (i <= n3) {
            n7 /= i;
            ++i;
        }
        return n7;
    }
    
    public static int getRSSvalue(final int[] array, final int n, final boolean b) {
        int n2 = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n2 += array[i];
        }
        int n3 = 0;
        int n4 = 0;
        final int length2 = array.length;
        int j = 0;
        int n5 = n2;
        while (j < length2 - 1) {
            int k;
            int n6;
            for (k = 1, n6 = (n4 | 1 << j); k < array[j]; ++k, n6 &= ~(1 << j)) {
                int combins;
                final int n7 = combins = combins(n5 - k - 1, length2 - j - 2);
                if (b) {
                    combins = n7;
                    if (n6 == 0) {
                        combins = n7;
                        if (n5 - k - (length2 - j - 1) >= length2 - j - 1) {
                            combins = n7 - combins(n5 - k - (length2 - j), length2 - j - 2);
                        }
                    }
                }
                int n9;
                if (length2 - j - 1 > 1) {
                    int n8 = 0;
                    for (int l = n5 - k - (length2 - j - 2); l > n; --l) {
                        n8 += combins(n5 - k - l - 1, length2 - j - 3);
                    }
                    n9 = combins - (length2 - 1 - j) * n8;
                }
                else {
                    n9 = combins;
                    if (n5 - k > n) {
                        n9 = combins - 1;
                    }
                }
                n3 += n9;
            }
            n5 -= k;
            ++j;
            n4 = n6;
        }
        return n3;
    }
}
