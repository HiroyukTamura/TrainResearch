// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

public class SymbolInfo
{
    static final SymbolInfo[] PROD_SYMBOLS;
    private static SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;
    
    static {
        SymbolInfo.symbols = (PROD_SYMBOLS = new SymbolInfo[] { new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144() });
    }
    
    public SymbolInfo(final boolean b, final int n, final int n2, final int n3, final int n4, final int n5) {
        this(b, n, n2, n3, n4, n5, n, n2);
    }
    
    SymbolInfo(final boolean rectangular, final int dataCapacity, final int errorCodewords, final int matrixWidth, final int matrixHeight, final int dataRegions, final int rsBlockData, final int rsBlockError) {
        this.rectangular = rectangular;
        this.dataCapacity = dataCapacity;
        this.errorCodewords = errorCodewords;
        this.matrixWidth = matrixWidth;
        this.matrixHeight = matrixHeight;
        this.dataRegions = dataRegions;
        this.rsBlockData = rsBlockData;
        this.rsBlockError = rsBlockError;
    }
    
    private int getHorizontalDataRegions() {
        switch (this.dataRegions) {
            default: {
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            case 1: {
                return 1;
            }
            case 2:
            case 4: {
                return 2;
            }
            case 16: {
                return 4;
            }
            case 36: {
                return 6;
            }
        }
    }
    
    private int getVerticalDataRegions() {
        switch (this.dataRegions) {
            default: {
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            case 1:
            case 2: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 16: {
                return 4;
            }
            case 36: {
                return 6;
            }
        }
    }
    
    public static SymbolInfo lookup(final int n) {
        return lookup(n, SymbolShapeHint.FORCE_NONE, true);
    }
    
    public static SymbolInfo lookup(final int n, final SymbolShapeHint symbolShapeHint) {
        return lookup(n, symbolShapeHint, true);
    }
    
    public static SymbolInfo lookup(final int i, final SymbolShapeHint symbolShapeHint, final Dimension dimension, final Dimension dimension2, final boolean b) {
        final SymbolInfo[] symbols = SymbolInfo.symbols;
        for (int length = symbols.length, j = 0; j < length; ++j) {
            final SymbolInfo symbolInfo = symbols[j];
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !symbolInfo.rectangular) && (symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && (dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && (dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i <= symbolInfo.dataCapacity) {
                return symbolInfo;
            }
        }
        if (b) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i);
        }
        return null;
    }
    
    private static SymbolInfo lookup(final int n, final SymbolShapeHint symbolShapeHint, final boolean b) {
        return lookup(n, symbolShapeHint, null, null, b);
    }
    
    public static SymbolInfo lookup(final int n, final boolean b, final boolean b2) {
        SymbolShapeHint symbolShapeHint;
        if (b) {
            symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        }
        else {
            symbolShapeHint = SymbolShapeHint.FORCE_SQUARE;
        }
        return lookup(n, symbolShapeHint, b2);
    }
    
    public static void overrideSymbolSet(final SymbolInfo[] symbols) {
        SymbolInfo.symbols = symbols;
    }
    
    public int getCodewordCount() {
        return this.dataCapacity + this.errorCodewords;
    }
    
    public final int getDataCapacity() {
        return this.dataCapacity;
    }
    
    public int getDataLengthForInterleavedBlock(final int n) {
        return this.rsBlockData;
    }
    
    public final int getErrorCodewords() {
        return this.errorCodewords;
    }
    
    public final int getErrorLengthForInterleavedBlock(final int n) {
        return this.rsBlockError;
    }
    
    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }
    
    public final int getSymbolDataHeight() {
        return this.getVerticalDataRegions() * this.matrixHeight;
    }
    
    public final int getSymbolDataWidth() {
        return this.getHorizontalDataRegions() * this.matrixWidth;
    }
    
    public final int getSymbolHeight() {
        return this.getSymbolDataHeight() + (this.getVerticalDataRegions() << 1);
    }
    
    public final int getSymbolWidth() {
        return this.getSymbolDataWidth() + (this.getHorizontalDataRegions() << 1);
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        String str;
        if (this.rectangular) {
            str = "Rectangular Symbol:";
        }
        else {
            str = "Square Symbol:";
        }
        return sb.append(str).append(" data region ").append(this.matrixWidth).append('x').append(this.matrixHeight).append(", symbol size ").append(this.getSymbolWidth()).append('x').append(this.getSymbolHeight()).append(", symbol data size ").append(this.getSymbolDataWidth()).append('x').append(this.getSymbolDataHeight()).append(", codewords ").append(this.dataCapacity).append('+').append(this.errorCodewords).toString();
    }
}
