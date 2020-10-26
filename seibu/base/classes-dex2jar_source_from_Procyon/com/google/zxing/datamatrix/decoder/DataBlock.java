// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.decoder;

final class DataBlock
{
    private final byte[] codewords;
    private final int numDataCodewords;
    
    private DataBlock(final int numDataCodewords, final byte[] codewords) {
        this.numDataCodewords = numDataCodewords;
        this.codewords = codewords;
    }
    
    static DataBlock[] getDataBlocks(final byte[] array, final Version version) {
        final Version.ECBlocks ecBlocks = version.getECBlocks();
        int n = 0;
        final Version.ECB[] ecBlocks2 = ecBlocks.getECBlocks();
        for (int length = ecBlocks2.length, i = 0; i < length; ++i) {
            n += ecBlocks2[i].getCount();
        }
        final DataBlock[] array2 = new DataBlock[n];
        int n2 = 0;
        for (int length2 = ecBlocks2.length, j = 0; j < length2; ++j) {
            final Version.ECB ecb = ecBlocks2[j];
            for (int k = 0; k < ecb.getCount(); ++k, ++n2) {
                final int dataCodewords = ecb.getDataCodewords();
                array2[n2] = new DataBlock(dataCodewords, new byte[ecBlocks.getECCodewords() + dataCodewords]);
            }
        }
        final int n3 = array2[0].codewords.length - ecBlocks.getECCodewords();
        int n4 = 0;
        for (int l = 0; l < n3 - 1; ++l) {
            for (int n5 = 0; n5 < n2; ++n5, ++n4) {
                array2[n5].codewords[l] = array[n4];
            }
        }
        boolean b;
        if (version.getVersionNumber() == 24) {
            b = true;
        }
        else {
            b = false;
        }
        int n6;
        if (b) {
            n6 = 8;
        }
        else {
            n6 = n2;
        }
        for (int n7 = 0; n7 < n6; ++n7, ++n4) {
            array2[n7].codewords[n3 - 1] = array[n4];
        }
        final int length3 = array2[0].codewords.length;
        final int n8 = n3;
        int n9 = n4;
        for (int n10 = n8; n10 < length3; ++n10) {
            for (int n11 = 0; n11 < n2; ++n11, ++n9) {
                int n12;
                if (b) {
                    n12 = (n11 + 8) % n2;
                }
                else {
                    n12 = n11;
                }
                int n13;
                if (b && n12 > 7) {
                    n13 = n10 - 1;
                }
                else {
                    n13 = n10;
                }
                array2[n12].codewords[n13] = array[n9];
            }
        }
        if (n9 != array.length) {
            throw new IllegalArgumentException();
        }
        return array2;
    }
    
    byte[] getCodewords() {
        return this.codewords;
    }
    
    int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
