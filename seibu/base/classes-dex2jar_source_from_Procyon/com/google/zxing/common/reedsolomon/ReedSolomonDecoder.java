// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder
{
    private final GenericGF field;
    
    public ReedSolomonDecoder(final GenericGF field) {
        this.field = field;
    }
    
    private int[] findErrorLocations(final GenericGFPoly genericGFPoly) throws ReedSolomonException {
        final int degree = genericGFPoly.getDegree();
        int[] array;
        if (degree == 1) {
            array = new int[] { genericGFPoly.getCoefficient(1) };
        }
        else {
            final int[] array2 = new int[degree];
            int n = 0;
            int n3;
            for (int n2 = 1; n2 < this.field.getSize() && n < degree; ++n2, n = n3) {
                n3 = n;
                if (genericGFPoly.evaluateAt(n2) == 0) {
                    array2[n] = this.field.inverse(n2);
                    n3 = n + 1;
                }
            }
            array = array2;
            if (n != degree) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
        }
        return array;
    }
    
    private int[] findErrorMagnitudes(final GenericGFPoly genericGFPoly, final int[] array) {
        final int length = array.length;
        final int[] array2 = new int[length];
        for (int i = 0; i < length; ++i) {
            final int inverse = this.field.inverse(array[i]);
            int n = 1;
            int multiply;
            for (int j = 0; j < length; ++j, n = multiply) {
                multiply = n;
                if (i != j) {
                    final int multiply2 = this.field.multiply(array[j], inverse);
                    int n2;
                    if ((multiply2 & 0x1) == 0x0) {
                        n2 = (multiply2 | 0x1);
                    }
                    else {
                        n2 = (multiply2 & 0xFFFFFFFE);
                    }
                    multiply = this.field.multiply(n, n2);
                }
            }
            array2[i] = this.field.multiply(genericGFPoly.evaluateAt(inverse), this.field.inverse(n));
            if (this.field.getGeneratorBase() != 0) {
                array2[i] = this.field.multiply(array2[i], inverse);
            }
        }
        return array2;
    }
    
    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly addOrSubtract, GenericGFPoly genericGFPoly, int n) throws ReedSolomonException {
        GenericGFPoly genericGFPoly2 = addOrSubtract;
        GenericGFPoly genericGFPoly3 = genericGFPoly;
        if (addOrSubtract.getDegree() < genericGFPoly.getDegree()) {
            genericGFPoly3 = addOrSubtract;
            genericGFPoly2 = genericGFPoly;
        }
        GenericGFPoly zero = this.field.getZero();
        genericGFPoly = this.field.getOne();
        GenericGFPoly genericGFPoly4;
        do {
            final GenericGFPoly genericGFPoly5 = zero;
            if (genericGFPoly3.getDegree() >= n / 2) {
                genericGFPoly4 = genericGFPoly3;
                zero = genericGFPoly;
                if (genericGFPoly4.isZero()) {
                    throw new ReedSolomonException("r_{i-1} was zero");
                }
                addOrSubtract = genericGFPoly2;
                genericGFPoly = this.field.getZero();
                final int inverse = this.field.inverse(genericGFPoly4.getCoefficient(genericGFPoly4.getDegree()));
                while (addOrSubtract.getDegree() >= genericGFPoly4.getDegree() && !addOrSubtract.isZero()) {
                    final int n2 = addOrSubtract.getDegree() - genericGFPoly4.getDegree();
                    final int multiply = this.field.multiply(addOrSubtract.getCoefficient(addOrSubtract.getDegree()), inverse);
                    genericGFPoly = genericGFPoly.addOrSubtract(this.field.buildMonomial(n2, multiply));
                    addOrSubtract = addOrSubtract.addOrSubtract(genericGFPoly4.multiplyByMonomial(n2, multiply));
                }
                genericGFPoly = genericGFPoly.multiply(zero).addOrSubtract(genericGFPoly5);
                genericGFPoly3 = addOrSubtract;
                genericGFPoly2 = genericGFPoly4;
            }
            else {
                n = genericGFPoly.getCoefficient(0);
                if (n == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                n = this.field.inverse(n);
                return new GenericGFPoly[] { genericGFPoly.multiply(n), genericGFPoly3.multiply(n) };
            }
        } while (addOrSubtract.getDegree() < genericGFPoly4.getDegree());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }
    
    public void decode(final int[] array, int i) throws ReedSolomonException {
        final GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, array);
        final int[] array2 = new int[i];
        boolean b = true;
        for (int j = 0; j < i; ++j) {
            if ((array2[i - 1 - j] = genericGFPoly.evaluateAt(this.field.exp(this.field.getGeneratorBase() + j))) != 0) {
                b = false;
            }
        }
        if (!b) {
            final GenericGFPoly[] runEuclideanAlgorithm = this.runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new GenericGFPoly(this.field, array2), i);
            final GenericGFPoly genericGFPoly2 = runEuclideanAlgorithm[0];
            final GenericGFPoly genericGFPoly3 = runEuclideanAlgorithm[1];
            final int[] errorLocations = this.findErrorLocations(genericGFPoly2);
            final int[] errorMagnitudes = this.findErrorMagnitudes(genericGFPoly3, errorLocations);
            int n;
            for (i = 0; i < errorLocations.length; ++i) {
                n = array.length - 1 - this.field.log(errorLocations[i]);
                if (n < 0) {
                    throw new ReedSolomonException("Bad error location");
                }
                array[n] = GenericGF.addOrSubtract(array[n], errorMagnitudes[i]);
            }
        }
    }
}
