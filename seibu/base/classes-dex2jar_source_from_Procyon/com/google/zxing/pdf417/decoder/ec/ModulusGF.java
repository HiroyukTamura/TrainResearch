// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF
{
    public static final ModulusGF PDF417_GF;
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;
    
    static {
        PDF417_GF = new ModulusGF(929, 3);
    }
    
    private ModulusGF(final int modulus, int i) {
        this.modulus = modulus;
        this.expTable = new int[modulus];
        this.logTable = new int[modulus];
        int n = 1;
        for (int j = 0; j < modulus; ++j) {
            this.expTable[j] = n;
            n = n * i % modulus;
        }
        for (i = 0; i < modulus - 1; ++i) {
            this.logTable[this.expTable[i]] = i;
        }
        this.zero = new ModulusPoly(this, new int[] { 0 });
        this.one = new ModulusPoly(this, new int[] { 1 });
    }
    
    int add(final int n, final int n2) {
        return (n + n2) % this.modulus;
    }
    
    ModulusPoly buildMonomial(final int n, final int n2) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n2 == 0) {
            return this.zero;
        }
        final int[] array = new int[n + 1];
        array[0] = n2;
        return new ModulusPoly(this, array);
    }
    
    int exp(final int n) {
        return this.expTable[n];
    }
    
    ModulusPoly getOne() {
        return this.one;
    }
    
    int getSize() {
        return this.modulus;
    }
    
    ModulusPoly getZero() {
        return this.zero;
    }
    
    int inverse(final int n) {
        if (n == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[this.modulus - this.logTable[n] - 1];
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
        return this.expTable[(this.logTable[n] + this.logTable[n2]) % (this.modulus - 1)];
    }
    
    int subtract(final int n, final int n2) {
        return (this.modulus + n - n2) % this.modulus;
    }
}
