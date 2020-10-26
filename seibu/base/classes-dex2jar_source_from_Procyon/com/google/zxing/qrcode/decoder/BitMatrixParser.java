// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;
    
    BitMatrixParser(final BitMatrix bitMatrix) throws FormatException {
        final int height = bitMatrix.getHeight();
        if (height < 21 || (height & 0x3) != 0x1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }
    
    private int copyBit(final int n, final int n2, final int n3) {
        boolean b;
        if (this.mirror) {
            b = this.bitMatrix.get(n2, n);
        }
        else {
            b = this.bitMatrix.get(n, n2);
        }
        if (b) {
            return n3 << 1 | 0x1;
        }
        return n3 << 1;
    }
    
    void mirror() {
        for (int i = 0; i < this.bitMatrix.getWidth(); ++i) {
            for (int j = i + 1; j < this.bitMatrix.getHeight(); ++j) {
                if (this.bitMatrix.get(i, j) != this.bitMatrix.get(j, i)) {
                    this.bitMatrix.flip(j, i);
                    this.bitMatrix.flip(i, j);
                }
            }
        }
    }
    
    byte[] readCodewords() throws FormatException {
        final FormatInformation formatInformation = this.readFormatInformation();
        final Version version = this.readVersion();
        final DataMask dataMask = DataMask.values()[formatInformation.getDataMask()];
        final int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        final BitMatrix buildFunctionPattern = version.buildFunctionPattern();
        int n = 1;
        final byte[] array = new byte[version.getTotalCodewords()];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5;
        for (int i = height - 1; i > 0; i = n5 - 2) {
            if ((n5 = i) == 6) {
                n5 = i - 1;
            }
            for (int j = 0; j < height; ++j) {
                int n6;
                if (n != 0) {
                    n6 = height - 1 - j;
                }
                else {
                    n6 = j;
                }
                int k = 0;
            Label_0217_Outer:
                while (k < 2) {
                    int n7 = n4;
                    int n8 = n3;
                    while (true) {
                        Label_0269: {
                            if (buildFunctionPattern.get(n5 - k, n6)) {
                                break Label_0269;
                            }
                            final int n9 = n4 + 1;
                            int n11;
                            final int n10 = n11 = n3 << 1;
                            if (this.bitMatrix.get(n5 - k, n6)) {
                                n11 = (n10 | 0x1);
                            }
                            n7 = n9;
                            n8 = n11;
                            if (n9 != 8) {
                                break Label_0269;
                            }
                            final int n12 = n2 + 1;
                            array[n2] = (byte)n11;
                            final int n13 = 0;
                            n3 = 0;
                            n2 = n12;
                            n4 = n13;
                            ++k;
                            continue Label_0217_Outer;
                        }
                        n4 = n7;
                        n3 = n8;
                        continue;
                    }
                }
            }
            n ^= 0x1;
        }
        if (n2 != version.getTotalCodewords()) {
            throw FormatException.getFormatInstance();
        }
        return array;
    }
    
    FormatInformation readFormatInformation() throws FormatException {
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        int copyBit = 0;
        for (int i = 0; i < 6; ++i) {
            copyBit = this.copyBit(i, 8, copyBit);
        }
        int n = this.copyBit(8, 7, this.copyBit(8, 8, this.copyBit(7, 8, copyBit)));
        for (int j = 5; j >= 0; --j) {
            n = this.copyBit(8, j, n);
        }
        final int height = this.bitMatrix.getHeight();
        int n2 = 0;
        for (int k = height - 1; k >= height - 7; --k) {
            n2 = this.copyBit(8, k, n2);
        }
        for (int l = height - 8; l < height; ++l) {
            n2 = this.copyBit(l, 8, n2);
        }
        this.parsedFormatInfo = FormatInformation.decodeFormatInformation(n, n2);
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        throw FormatException.getFormatInstance();
    }
    
    Version readVersion() throws FormatException {
        if (this.parsedVersion != null) {
            return this.parsedVersion;
        }
        final int height = this.bitMatrix.getHeight();
        final int n = (height - 17) / 4;
        if (n <= 6) {
            return Version.getVersionForNumber(n);
        }
        int copyBit = 0;
        final int n2 = height - 11;
        for (int i = 5; i >= 0; --i) {
            for (int j = height - 9; j >= n2; --j) {
                copyBit = this.copyBit(j, i, copyBit);
            }
        }
        final Version decodeVersionInformation = Version.decodeVersionInformation(copyBit);
        if (decodeVersionInformation != null && decodeVersionInformation.getDimensionForVersion() == height) {
            return this.parsedVersion = decodeVersionInformation;
        }
        int copyBit2 = 0;
        for (int k = 5; k >= 0; --k) {
            for (int l = height - 9; l >= n2; --l) {
                copyBit2 = this.copyBit(k, l, copyBit2);
            }
        }
        final Version decodeVersionInformation2 = Version.decodeVersionInformation(copyBit2);
        if (decodeVersionInformation2 != null && decodeVersionInformation2.getDimensionForVersion() == height) {
            return this.parsedVersion = decodeVersionInformation2;
        }
        throw FormatException.getFormatInstance();
    }
    
    void remask() {
        if (this.parsedFormatInfo == null) {
            return;
        }
        DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }
    
    void setMirror(final boolean mirror) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = mirror;
    }
}
