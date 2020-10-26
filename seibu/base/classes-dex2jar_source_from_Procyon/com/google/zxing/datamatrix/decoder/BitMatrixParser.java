// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;
    
    BitMatrixParser(final BitMatrix bitMatrix) throws FormatException {
        final int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 0x1) != 0x0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = this.extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }
    
    private BitMatrix extractDataRegion(final BitMatrix bitMatrix) {
        final int symbolSizeRows = this.version.getSymbolSizeRows();
        final int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        final int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        final int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        final int n = symbolSizeRows / dataRegionSizeRows;
        final int n2 = symbolSizeColumns / dataRegionSizeColumns;
        final BitMatrix bitMatrix2 = new BitMatrix(n2 * dataRegionSizeColumns, n * dataRegionSizeRows);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                for (int k = 0; k < dataRegionSizeRows; ++k) {
                    for (int l = 0; l < dataRegionSizeColumns; ++l) {
                        if (bitMatrix.get((dataRegionSizeColumns + 2) * j + 1 + l, (dataRegionSizeRows + 2) * i + 1 + k)) {
                            bitMatrix2.set(j * dataRegionSizeColumns + l, i * dataRegionSizeRows + k);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }
    
    private int readCorner1(final int n, final int n2) {
        int n3 = 0;
        if (this.readModule(n - 1, 0, n, n2)) {
            n3 = 1;
        }
        int n4 = n3 << 1;
        if (this.readModule(n - 1, 1, n, n2)) {
            n4 |= 0x1;
        }
        int n5 = n4 << 1;
        if (this.readModule(n - 1, 2, n, n2)) {
            n5 |= 0x1;
        }
        int n6 = n5 << 1;
        if (this.readModule(0, n2 - 2, n, n2)) {
            n6 |= 0x1;
        }
        int n7 = n6 << 1;
        if (this.readModule(0, n2 - 1, n, n2)) {
            n7 |= 0x1;
        }
        int n8 = n7 << 1;
        if (this.readModule(1, n2 - 1, n, n2)) {
            n8 |= 0x1;
        }
        int n9 = n8 << 1;
        if (this.readModule(2, n2 - 1, n, n2)) {
            n9 |= 0x1;
        }
        int n10 = n9 << 1;
        if (this.readModule(3, n2 - 1, n, n2)) {
            n10 |= 0x1;
        }
        return n10;
    }
    
    private int readCorner2(final int n, final int n2) {
        int n3 = 0;
        if (this.readModule(n - 3, 0, n, n2)) {
            n3 = 1;
        }
        int n4 = n3 << 1;
        if (this.readModule(n - 2, 0, n, n2)) {
            n4 |= 0x1;
        }
        int n5 = n4 << 1;
        if (this.readModule(n - 1, 0, n, n2)) {
            n5 |= 0x1;
        }
        int n6 = n5 << 1;
        if (this.readModule(0, n2 - 4, n, n2)) {
            n6 |= 0x1;
        }
        int n7 = n6 << 1;
        if (this.readModule(0, n2 - 3, n, n2)) {
            n7 |= 0x1;
        }
        int n8 = n7 << 1;
        if (this.readModule(0, n2 - 2, n, n2)) {
            n8 |= 0x1;
        }
        int n9 = n8 << 1;
        if (this.readModule(0, n2 - 1, n, n2)) {
            n9 |= 0x1;
        }
        int n10 = n9 << 1;
        if (this.readModule(1, n2 - 1, n, n2)) {
            n10 |= 0x1;
        }
        return n10;
    }
    
    private int readCorner3(final int n, final int n2) {
        int n3 = 0;
        if (this.readModule(n - 1, 0, n, n2)) {
            n3 = 1;
        }
        int n4 = n3 << 1;
        if (this.readModule(n - 1, n2 - 1, n, n2)) {
            n4 |= 0x1;
        }
        int n5 = n4 << 1;
        if (this.readModule(0, n2 - 3, n, n2)) {
            n5 |= 0x1;
        }
        int n6 = n5 << 1;
        if (this.readModule(0, n2 - 2, n, n2)) {
            n6 |= 0x1;
        }
        int n7 = n6 << 1;
        if (this.readModule(0, n2 - 1, n, n2)) {
            n7 |= 0x1;
        }
        int n8 = n7 << 1;
        if (this.readModule(1, n2 - 3, n, n2)) {
            n8 |= 0x1;
        }
        int n9 = n8 << 1;
        if (this.readModule(1, n2 - 2, n, n2)) {
            n9 |= 0x1;
        }
        int n10 = n9 << 1;
        if (this.readModule(1, n2 - 1, n, n2)) {
            n10 |= 0x1;
        }
        return n10;
    }
    
    private int readCorner4(final int n, final int n2) {
        int n3 = 0;
        if (this.readModule(n - 3, 0, n, n2)) {
            n3 = 1;
        }
        int n4 = n3 << 1;
        if (this.readModule(n - 2, 0, n, n2)) {
            n4 |= 0x1;
        }
        int n5 = n4 << 1;
        if (this.readModule(n - 1, 0, n, n2)) {
            n5 |= 0x1;
        }
        int n6 = n5 << 1;
        if (this.readModule(0, n2 - 2, n, n2)) {
            n6 |= 0x1;
        }
        int n7 = n6 << 1;
        if (this.readModule(0, n2 - 1, n, n2)) {
            n7 |= 0x1;
        }
        int n8 = n7 << 1;
        if (this.readModule(1, n2 - 1, n, n2)) {
            n8 |= 0x1;
        }
        int n9 = n8 << 1;
        if (this.readModule(2, n2 - 1, n, n2)) {
            n9 |= 0x1;
        }
        int n10 = n9 << 1;
        if (this.readModule(3, n2 - 1, n, n2)) {
            n10 |= 0x1;
        }
        return n10;
    }
    
    private boolean readModule(int n, int n2, final int n3, final int n4) {
        int n5 = n;
        int n6 = n2;
        if (n < 0) {
            n5 = n + n3;
            n6 = n2 + (4 - (n3 + 4 & 0x7));
        }
        n2 = n5;
        if ((n = n6) < 0) {
            n = n6 + n4;
            n2 = n5 + (4 - (n4 + 4 & 0x7));
        }
        this.readMappingMatrix.set(n, n2);
        return this.mappingBitMatrix.get(n, n2);
    }
    
    private int readUtah(final int n, final int n2, final int n3, final int n4) {
        int n5 = 0;
        if (this.readModule(n - 2, n2 - 2, n3, n4)) {
            n5 = 1;
        }
        int n6 = n5 << 1;
        if (this.readModule(n - 2, n2 - 1, n3, n4)) {
            n6 |= 0x1;
        }
        int n7 = n6 << 1;
        if (this.readModule(n - 1, n2 - 2, n3, n4)) {
            n7 |= 0x1;
        }
        int n8 = n7 << 1;
        if (this.readModule(n - 1, n2 - 1, n3, n4)) {
            n8 |= 0x1;
        }
        int n9 = n8 << 1;
        if (this.readModule(n - 1, n2, n3, n4)) {
            n9 |= 0x1;
        }
        int n10 = n9 << 1;
        if (this.readModule(n, n2 - 2, n3, n4)) {
            n10 |= 0x1;
        }
        int n11 = n10 << 1;
        if (this.readModule(n, n2 - 1, n3, n4)) {
            n11 |= 0x1;
        }
        int n12 = n11 << 1;
        if (this.readModule(n, n2, n3, n4)) {
            n12 |= 0x1;
        }
        return n12;
    }
    
    private static Version readVersion(final BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }
    
    Version getVersion() {
        return this.version;
    }
    
    byte[] readCodewords() throws FormatException {
        final byte[] array = new byte[this.version.getTotalCodewords()];
        int n = 4;
        int n2 = 0;
        final int height = this.mappingBitMatrix.getHeight();
        final int width = this.mappingBitMatrix.getWidth();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        do {
            if (n == height && n2 == 0 && n3 == 0) {
                final int n8 = n7 + 1;
                array[n7] = (byte)this.readCorner1(height, width);
                n -= 2;
                n2 += 2;
                n3 = 1;
                n7 = n8;
            }
            else if (n == height - 2 && n2 == 0 && (width & 0x3) != 0x0 && n4 == 0) {
                final int n9 = n7 + 1;
                array[n7] = (byte)this.readCorner2(height, width);
                n -= 2;
                n2 += 2;
                n4 = 1;
                n7 = n9;
            }
            else if (n == height + 4 && n2 == 2 && (width & 0x7) == 0x0 && n5 == 0) {
                final int n10 = n7 + 1;
                array[n7] = (byte)this.readCorner3(height, width);
                n -= 2;
                n2 += 2;
                n5 = 1;
                n7 = n10;
            }
            else {
                int n11 = n2;
                int n12 = n7;
                int n13;
                if ((n13 = n) == height - 2) {
                    n11 = n2;
                    n12 = n7;
                    n13 = n;
                    if (n2 == 0) {
                        n11 = n2;
                        n12 = n7;
                        n13 = n;
                        if ((width & 0x7) == 0x4) {
                            n11 = n2;
                            n12 = n7;
                            n13 = n;
                            if (n6 == 0) {
                                final int n14 = n7 + 1;
                                array[n7] = (byte)this.readCorner4(height, width);
                                n -= 2;
                                n2 += 2;
                                n6 = 1;
                                n7 = n14;
                                continue;
                            }
                        }
                    }
                }
                int n15;
                while (true) {
                    if (n13 < height && n11 >= 0 && !this.readMappingMatrix.get(n11, n13)) {
                        n15 = n12 + 1;
                        array[n12] = (byte)this.readUtah(n13, n11, height, width);
                    }
                    else {
                        n15 = n12;
                    }
                    n13 -= 2;
                    n11 += 2;
                    if (n13 < 0 || n11 >= width) {
                        break;
                    }
                    n12 = n15;
                }
                int n16 = n13 + 1;
                int n17 = n11 + 3;
                int n18;
                while (true) {
                    if (n16 >= 0 && n17 < width && !this.readMappingMatrix.get(n17, n16)) {
                        n7 = n15 + 1;
                        array[n15] = (byte)this.readUtah(n16, n17, height, width);
                    }
                    else {
                        n7 = n15;
                    }
                    n16 += 2;
                    n18 = n17 - 2;
                    if (n16 >= height || n18 < 0) {
                        break;
                    }
                    n15 = n7;
                    n17 = n18;
                }
                n = n16 + 3;
                n2 = n18 + 1;
            }
        } while (n < height || n2 < width);
        if (n7 != this.version.getTotalCodewords()) {
            throw FormatException.getFormatInstance();
        }
        return array;
    }
}
