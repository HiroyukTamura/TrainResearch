// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection
{
    private final ModulusGF field;
    
    public ErrorCorrection() {
        this.field = ModulusGF.PDF417_GF;
    }
    
    private int[] findErrorLocations(final ModulusPoly modulusPoly) throws ChecksumException {
        final int degree = modulusPoly.getDegree();
        final int[] array = new int[degree];
        int n = 0;
        int n3;
        for (int n2 = 1; n2 < this.field.getSize() && n < degree; ++n2, n = n3) {
            n3 = n;
            if (modulusPoly.evaluateAt(n2) == 0) {
                array[n] = this.field.inverse(n2);
                n3 = n + 1;
            }
        }
        if (n != degree) {
            throw ChecksumException.getChecksumInstance();
        }
        return array;
    }
    
    private int[] findErrorMagnitudes(final ModulusPoly modulusPoly, final ModulusPoly modulusPoly2, final int[] array) {
        final int degree = modulusPoly2.getDegree();
        final int[] array2 = new int[degree];
        for (int i = 1; i <= degree; ++i) {
            array2[degree - i] = this.field.multiply(i, modulusPoly2.getCoefficient(i));
        }
        final ModulusPoly modulusPoly3 = new ModulusPoly(this.field, array2);
        final int length = array.length;
        final int[] array3 = new int[length];
        for (int j = 0; j < length; ++j) {
            final int inverse = this.field.inverse(array[j]);
            array3[j] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return array3;
    }
    
    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly subtract, int n) throws ChecksumException {
        ModulusPoly modulusPoly2 = modulusPoly;
        ModulusPoly modulusPoly3 = subtract;
        if (modulusPoly.getDegree() < subtract.getDegree()) {
            modulusPoly3 = modulusPoly;
            modulusPoly2 = subtract;
        }
        subtract = modulusPoly2;
        final ModulusPoly modulusPoly4 = modulusPoly3;
        ModulusPoly zero = this.field.getZero();
        modulusPoly = this.field.getOne();
        ModulusPoly modulusPoly5 = subtract;
        subtract = modulusPoly4;
        while (true) {
            final ModulusPoly modulusPoly6 = zero;
            final ModulusPoly modulusPoly7 = modulusPoly5;
            if (subtract.getDegree() >= n / 2) {
                modulusPoly5 = subtract;
                zero = modulusPoly;
                if (modulusPoly5.isZero()) {
                    throw ChecksumException.getChecksumInstance();
                }
                subtract = modulusPoly7;
                modulusPoly = this.field.getZero();
                final int inverse = this.field.inverse(modulusPoly5.getCoefficient(modulusPoly5.getDegree()));
                while (subtract.getDegree() >= modulusPoly5.getDegree() && !subtract.isZero()) {
                    final int n2 = subtract.getDegree() - modulusPoly5.getDegree();
                    final int multiply = this.field.multiply(subtract.getCoefficient(subtract.getDegree()), inverse);
                    modulusPoly = modulusPoly.add(this.field.buildMonomial(n2, multiply));
                    subtract = subtract.subtract(modulusPoly5.multiplyByMonomial(n2, multiply));
                }
                modulusPoly = modulusPoly.multiply(zero).subtract(modulusPoly6).negative();
            }
            else {
                n = modulusPoly.getCoefficient(0);
                if (n == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                n = this.field.inverse(n);
                return new ModulusPoly[] { modulusPoly.multiply(n), subtract.multiply(n) };
            }
        }
    }
    
    public int decode(final int[] array, int i, int[] errorMagnitudes) throws ChecksumException {
        final ModulusPoly modulusPoly = new ModulusPoly(this.field, array);
        final int[] array2 = new int[i];
        boolean b = false;
        for (int j = i; j > 0; --j) {
            if ((array2[i - j] = modulusPoly.evaluateAt(this.field.exp(j))) != 0) {
                b = true;
            }
        }
        if (!b) {
            return 0;
        }
        ModulusPoly modulusPoly2 = this.field.getOne();
        if (errorMagnitudes != null) {
            for (int length = errorMagnitudes.length, k = 0; k < length; ++k) {
                modulusPoly2 = modulusPoly2.multiply(new ModulusPoly(this.field, new int[] { this.field.subtract(0, this.field.exp(array.length - 1 - errorMagnitudes[k])), 1 }));
            }
        }
        final ModulusPoly[] runEuclideanAlgorithm = this.runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, array2), i);
        final ModulusPoly modulusPoly3 = runEuclideanAlgorithm[0];
        final ModulusPoly modulusPoly4 = runEuclideanAlgorithm[1];
        final int[] errorLocations = this.findErrorLocations(modulusPoly3);
        errorMagnitudes = this.findErrorMagnitudes(modulusPoly4, modulusPoly3, errorLocations);
        int n;
        for (i = 0; i < errorLocations.length; ++i) {
            n = array.length - 1 - this.field.log(errorLocations[i]);
            if (n < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            array[n] = this.field.subtract(array[n], errorMagnitudes[i]);
        }
        return errorLocations.length;
    }
}
