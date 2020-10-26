// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
    public static final GenericGF AZTEC_DATA_10;
    public static final GenericGF AZTEC_DATA_12;
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM;
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final GenericGFPoly zero;
    
    static {
        AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
        AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
        AZTEC_DATA_6 = new GenericGF(67, 64, 1);
        AZTEC_PARAM = new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
        AZTEC_DATA_8 = (DATA_MATRIX_FIELD_256 = new GenericGF(301, 256, 1));
        MAXICODE_FIELD_64 = GenericGF.AZTEC_DATA_6;
    }
    
    public GenericGF(int i, final int size, int generatorBase) {
        this.primitive = i;
        this.size = size;
        this.generatorBase = generatorBase;
        this.expTable = new int[size];
        this.logTable = new int[size];
        generatorBase = 1;
        for (int j = 0; j < size; ++j) {
            this.expTable[j] = generatorBase;
            final int n = generatorBase << 1;
            if ((generatorBase = n) >= size) {
                generatorBase = ((n ^ i) & size - 1);
            }
        }
        for (i = 0; i < size - 1; ++i) {
            this.logTable[this.expTable[i]] = i;
        }
        this.zero = new GenericGFPoly(this, new int[] { 0 });
        this.one = new GenericGFPoly(this, new int[] { 1 });
    }
    
    static int addOrSubtract(final int n, final int n2) {
        return n ^ n2;
    }
    
    GenericGFPoly buildMonomial(final int n, final int n2) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n2 == 0) {
            return this.zero;
        }
        final int[] array = new int[n + 1];
        array[0] = n2;
        return new GenericGFPoly(this, array);
    }
    
    int exp(final int n) {
        return this.expTable[n];
    }
    
    public int getGeneratorBase() {
        return this.generatorBase;
    }
    
    GenericGFPoly getOne() {
        return this.one;
    }
    
    public int getSize() {
        return this.size;
    }
    
    GenericGFPoly getZero() {
        return this.zero;
    }
    
    int inverse(final int n) {
        if (n == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[this.size - this.logTable[n] - 1];
    }
    
    int log(final int n) {
        if (n == 0) {
            throw new IllegalArgumentException();
        }
        return this.logTable[n];
    }
    
    int multiply(final int n, final int n2) {
        if (n == 0 || n2 == 0) {
            return 0;
        }
        return this.expTable[(this.logTable[n] + this.logTable[n2]) % (this.size - 1)];
    }
    
    @Override
    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
