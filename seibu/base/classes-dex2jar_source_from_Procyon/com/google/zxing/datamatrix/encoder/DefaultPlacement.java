// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement
{
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;
    
    public DefaultPlacement(final CharSequence codewords, final int numcols, final int numrows) {
        this.codewords = codewords;
        this.numcols = numcols;
        this.numrows = numrows;
        Arrays.fill(this.bits = new byte[numcols * numrows], (byte)(-1));
    }
    
    private void corner1(final int n) {
        this.module(this.numrows - 1, 0, n, 1);
        this.module(this.numrows - 1, 1, n, 2);
        this.module(this.numrows - 1, 2, n, 3);
        this.module(0, this.numcols - 2, n, 4);
        this.module(0, this.numcols - 1, n, 5);
        this.module(1, this.numcols - 1, n, 6);
        this.module(2, this.numcols - 1, n, 7);
        this.module(3, this.numcols - 1, n, 8);
    }
    
    private void corner2(final int n) {
        this.module(this.numrows - 3, 0, n, 1);
        this.module(this.numrows - 2, 0, n, 2);
        this.module(this.numrows - 1, 0, n, 3);
        this.module(0, this.numcols - 4, n, 4);
        this.module(0, this.numcols - 3, n, 5);
        this.module(0, this.numcols - 2, n, 6);
        this.module(0, this.numcols - 1, n, 7);
        this.module(1, this.numcols - 1, n, 8);
    }
    
    private void corner3(final int n) {
        this.module(this.numrows - 3, 0, n, 1);
        this.module(this.numrows - 2, 0, n, 2);
        this.module(this.numrows - 1, 0, n, 3);
        this.module(0, this.numcols - 2, n, 4);
        this.module(0, this.numcols - 1, n, 5);
        this.module(1, this.numcols - 1, n, 6);
        this.module(2, this.numcols - 1, n, 7);
        this.module(3, this.numcols - 1, n, 8);
    }
    
    private void corner4(final int n) {
        this.module(this.numrows - 1, 0, n, 1);
        this.module(this.numrows - 1, this.numcols - 1, n, 2);
        this.module(0, this.numcols - 3, n, 3);
        this.module(0, this.numcols - 2, n, 4);
        this.module(0, this.numcols - 1, n, 5);
        this.module(1, this.numcols - 3, n, 6);
        this.module(1, this.numcols - 2, n, 7);
        this.module(1, this.numcols - 1, n, 8);
    }
    
    private boolean hasBit(final int n, final int n2) {
        return this.bits[this.numcols * n2 + n] >= 0;
    }
    
    private void module(int n, int n2, final int n3, final int n4) {
        boolean b = true;
        int n5 = n;
        int n6 = n2;
        if (n < 0) {
            n5 = n + this.numrows;
            n6 = n2 + (4 - (this.numrows + 4) % 8);
        }
        n2 = n5;
        if ((n = n6) < 0) {
            n = n6 + this.numcols;
            n2 = n5 + (4 - (this.numcols + 4) % 8);
        }
        if ((this.codewords.charAt(n3) & 1 << 8 - n4) == 0x0) {
            b = false;
        }
        this.setBit(n, n2, b);
    }
    
    private void setBit(final int n, final int n2, final boolean b) {
        final byte[] bits = this.bits;
        final int numcols = this.numcols;
        int n3;
        if (b) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        bits[numcols * n2 + n] = (byte)n3;
    }
    
    private void utah(final int n, final int n2, final int n3) {
        this.module(n - 2, n2 - 2, n3, 1);
        this.module(n - 2, n2 - 1, n3, 2);
        this.module(n - 1, n2 - 2, n3, 3);
        this.module(n - 1, n2 - 1, n3, 4);
        this.module(n - 1, n2, n3, 5);
        this.module(n, n2 - 2, n3, 6);
        this.module(n, n2 - 1, n3, 7);
        this.module(n, n2, n3, 8);
    }
    
    public final boolean getBit(final int n, final int n2) {
        return this.bits[this.numcols * n2 + n] == 1;
    }
    
    final byte[] getBits() {
        return this.bits;
    }
    
    final int getNumcols() {
        return this.numcols;
    }
    
    final int getNumrows() {
        return this.numrows;
    }
    
    public final void place() {
        int n = 0;
        int n2 = 4;
        int n3 = 0;
        while (true) {
            int n4 = n;
            if (n2 == this.numrows) {
                n4 = n;
                if (n3 == 0) {
                    this.corner1(n);
                    n4 = n + 1;
                }
            }
            int n5 = n4;
            if (n2 == this.numrows - 2) {
                n5 = n4;
                if (n3 == 0) {
                    n5 = n4;
                    if (this.numcols % 4 != 0) {
                        this.corner2(n4);
                        n5 = n4 + 1;
                    }
                }
            }
            int n6 = n5;
            if (n2 == this.numrows - 2) {
                n6 = n5;
                if (n3 == 0) {
                    n6 = n5;
                    if (this.numcols % 8 == 4) {
                        this.corner3(n5);
                        n6 = n5 + 1;
                    }
                }
            }
            int n7 = n3;
            int n8 = n6;
            int n9;
            if ((n9 = n2) == this.numrows + 4) {
                n7 = n3;
                n8 = n6;
                n9 = n2;
                if (n3 == 2) {
                    n7 = n3;
                    n8 = n6;
                    n9 = n2;
                    if (this.numcols % 8 == 0) {
                        this.corner4(n6);
                        n8 = n6 + 1;
                        n9 = n2;
                        n7 = n3;
                    }
                }
            }
            int i;
            int n10;
            int n11;
            do {
                n10 = n8;
                if (n9 < this.numrows) {
                    n10 = n8;
                    if (n7 >= 0) {
                        n10 = n8;
                        if (!this.hasBit(n7, n9)) {
                            this.utah(n9, n7, n8);
                            n10 = n8 + 1;
                        }
                    }
                }
                n11 = n9 - 2;
                i = n7 + 2;
                if (n11 < 0) {
                    break;
                }
                n7 = i;
                n8 = n10;
                n9 = n11;
            } while (i < this.numcols);
            final int n12 = n11 + 1;
            final int n13 = i + 3;
            int n14 = n10;
            int n15 = n12;
            int n16 = n13;
            do {
                if (n15 >= 0 && n16 < this.numcols && !this.hasBit(n16, n15)) {
                    final int n17 = n14 + 1;
                    this.utah(n15, n16, n14);
                    n14 = n17;
                }
                n15 += 2;
                n16 -= 2;
            } while (n15 < this.numrows && n16 >= 0);
            final int n18 = n15 + 3;
            final int n19 = n3 = n16 + 1;
            n = n14;
            if ((n2 = n18) >= this.numrows) {
                n3 = n19;
                n = n14;
                n2 = n18;
                if (n19 >= this.numcols) {
                    break;
                }
                continue;
            }
        }
        if (!this.hasBit(this.numcols - 1, this.numrows - 1)) {
            this.setBit(this.numcols - 1, this.numrows - 1, true);
            this.setBit(this.numcols - 2, this.numrows - 2, true);
        }
    }
}
