// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask
{
    DATA_MASK_000 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return (n + n2 & 0x1) == 0x0;
        }
    }, 
    DATA_MASK_001 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return (n & 0x1) == 0x0;
        }
    }, 
    DATA_MASK_010 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return n2 % 3 == 0;
        }
    }, 
    DATA_MASK_011 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return (n + n2) % 3 == 0;
        }
    }, 
    DATA_MASK_100 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return (n / 2 + n2 / 3 & 0x1) == 0x0;
        }
    }, 
    DATA_MASK_101 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return n * n2 % 6 == 0;
        }
    }, 
    DATA_MASK_110 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return n * n2 % 6 < 3;
        }
    }, 
    DATA_MASK_111 {
        @Override
        boolean isMasked(final int n, final int n2) {
            return (n + n2 + n * n2 % 3 & 0x1) == 0x0;
        }
    };
    
    abstract boolean isMasked(final int p0, final int p1);
    
    final void unmaskBitMatrix(final BitMatrix bitMatrix, final int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (this.isMasked(i, j)) {
                    bitMatrix.flip(j, i);
                }
            }
        }
    }
}
