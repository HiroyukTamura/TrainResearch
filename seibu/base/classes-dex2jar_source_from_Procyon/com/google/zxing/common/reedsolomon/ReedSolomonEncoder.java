// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
    private final List<GenericGFPoly> cachedGenerators;
    private final GenericGF field;
    
    public ReedSolomonEncoder(final GenericGF field) {
        this.field = field;
        (this.cachedGenerators = new ArrayList<GenericGFPoly>()).add(new GenericGFPoly(field, new int[] { 1 }));
    }
    
    private GenericGFPoly buildGenerator(final int n) {
        if (n >= this.cachedGenerators.size()) {
            GenericGFPoly multiply = this.cachedGenerators.get(this.cachedGenerators.size() - 1);
            for (int i = this.cachedGenerators.size(); i <= n; ++i) {
                multiply = multiply.multiply(new GenericGFPoly(this.field, new int[] { 1, this.field.exp(i - 1 + this.field.getGeneratorBase()) }));
                this.cachedGenerators.add(multiply);
            }
        }
        return this.cachedGenerators.get(n);
    }
    
    public void encode(final int[] array, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        final int n = array.length - i;
        if (n <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        final GenericGFPoly buildGenerator = this.buildGenerator(i);
        final int[] array2 = new int[n];
        System.arraycopy(array, 0, array2, 0, n);
        final int[] coefficients = new GenericGFPoly(this.field, array2).multiplyByMonomial(i, 1).divide(buildGenerator)[1].getCoefficients();
        int n2;
        for (n2 = i - coefficients.length, i = 0; i < n2; ++i) {
            array[n + i] = 0;
        }
        System.arraycopy(coefficients, 0, array, n + n2, coefficients.length);
    }
}
