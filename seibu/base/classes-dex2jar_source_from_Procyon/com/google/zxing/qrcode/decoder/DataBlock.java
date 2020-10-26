// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

final class DataBlock
{
    private final byte[] codewords;
    private final int numDataCodewords;
    
    private DataBlock(final int numDataCodewords, final byte[] codewords) {
        this.numDataCodewords = numDataCodewords;
        this.codewords = codewords;
    }
    
    static DataBlock[] getDataBlocks(final byte[] array, final Version version, final ErrorCorrectionLevel errorCorrectionLevel) {
        if (array.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        final Version.ECBlocks ecBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        int n = 0;
        final Version.ECB[] ecBlocks = ecBlocksForLevel.getECBlocks();
        for (int length = ecBlocks.length, i = 0; i < length; ++i) {
            n += ecBlocks[i].getCount();
        }
        final DataBlock[] array2 = new DataBlock[n];
        int n2 = 0;
        for (int length2 = ecBlocks.length, j = 0; j < length2; ++j) {
            final Version.ECB ecb = ecBlocks[j];
            for (int k = 0; k < ecb.getCount(); ++k, ++n2) {
                final int dataCodewords = ecb.getDataCodewords();
                array2[n2] = new DataBlock(dataCodewords, new byte[ecBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
            }
        }
        int length3;
        int n3;
        for (length3 = array2[0].codewords.length, n3 = array2.length - 1; n3 >= 0 && array2[n3].codewords.length != length3; --n3) {}
        final int n4 = n3 + 1;
        final int n5 = length3 - ecBlocksForLevel.getECCodewordsPerBlock();
        int n6 = 0;
        for (int l = 0; l < n5; ++l) {
            for (int n7 = 0; n7 < n2; ++n7, ++n6) {
                array2[n7].codewords[l] = array[n6];
            }
        }
        for (int n8 = n4; n8 < n2; ++n8, ++n6) {
            array2[n8].codewords[n5] = array[n6];
        }
        final int length4 = array2[0].codewords.length;
        final int n9 = n5;
        int n10 = n6;
        for (int n11 = n9; n11 < length4; ++n11) {
            for (int n12 = 0; n12 < n2; ++n12, ++n10) {
                int n13;
                if (n12 < n4) {
                    n13 = n11;
                }
                else {
                    n13 = n11 + 1;
                }
                array2[n12].codewords[n13] = array[n10];
            }
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
