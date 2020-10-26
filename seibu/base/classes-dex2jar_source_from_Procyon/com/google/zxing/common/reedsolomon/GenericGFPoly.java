// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common.reedsolomon;

final class GenericGFPoly
{
    private final int[] coefficients;
    private final GenericGF field;
    
    GenericGFPoly(final GenericGF field, final int[] coefficients) {
        if (coefficients.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = field;
        final int length = coefficients.length;
        if (length <= 1 || coefficients[0] != 0) {
            this.coefficients = coefficients;
            return;
        }
        int n;
        for (n = 1; n < length && coefficients[n] == 0; ++n) {}
        if (n == length) {
            this.coefficients = new int[] { 0 };
            return;
        }
        System.arraycopy(coefficients, n, this.coefficients = new int[length - n], 0, this.coefficients.length);
    }
    
    GenericGFPoly addOrSubtract(final GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (this.isZero()) {
            return genericGFPoly;
        }
        if (genericGFPoly.isZero()) {
            return this;
        }
        final int[] coefficients = this.coefficients;
        int[] coefficients2;
        final int[] array = coefficients2 = genericGFPoly.coefficients;
        int[] array2 = coefficients;
        if (coefficients.length > array.length) {
            array2 = array;
            coefficients2 = coefficients;
        }
        final int[] array3 = new int[coefficients2.length];
        final int n = coefficients2.length - array2.length;
        System.arraycopy(coefficients2, 0, array3, 0, n);
        for (int i = n; i < coefficients2.length; ++i) {
            array3[i] = GenericGF.addOrSubtract(array2[i - n], coefficients2[i]);
        }
        return new GenericGFPoly(this.field, array3);
    }
    
    GenericGFPoly[] divide(final GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly genericGFPoly2 = this.field.getZero();
        GenericGFPoly addOrSubtract = this;
        final int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
        while (addOrSubtract.getDegree() >= genericGFPoly.getDegree() && !addOrSubtract.isZero()) {
            final int n = addOrSubtract.getDegree() - genericGFPoly.getDegree();
            final int multiply = this.field.multiply(addOrSubtract.getCoefficient(addOrSubtract.getDegree()), inverse);
            final GenericGFPoly multiplyByMonomial = genericGFPoly.multiplyByMonomial(n, multiply);
            genericGFPoly2 = genericGFPoly2.addOrSubtract(this.field.buildMonomial(n, multiply));
            addOrSubtract = addOrSubtract.addOrSubtract(multiplyByMonomial);
        }
        return new GenericGFPoly[] { genericGFPoly2, addOrSubtract };
    }
    
    int evaluateAt(int addOrSubtract) {
        int n = 0;
        int coefficient;
        if (addOrSubtract == 0) {
            coefficient = this.getCoefficient(0);
        }
        else if (addOrSubtract == 1) {
            addOrSubtract = 0;
            final int[] coefficients = this.coefficients;
            final int length = coefficients.length;
            while (true) {
                coefficient = addOrSubtract;
                if (n >= length) {
                    break;
                }
                addOrSubtract = GenericGF.addOrSubtract(addOrSubtract, coefficients[n]);
                ++n;
            }
        }
        else {
            int addOrSubtract2 = this.coefficients[0];
            final int length2 = this.coefficients.length;
            int n2 = 1;
            while (true) {
                coefficient = addOrSubtract2;
                if (n2 >= length2) {
                    break;
                }
                addOrSubtract2 = GenericGF.addOrSubtract(this.field.multiply(addOrSubtract, addOrSubtract2), this.coefficients[n2]);
                ++n2;
            }
        }
        return coefficient;
    }
    
    int getCoefficient(final int n) {
        return this.coefficients[this.coefficients.length - 1 - n];
    }
    
    int[] getCoefficients() {
        return this.coefficients;
    }
    
    int getDegree() {
        return this.coefficients.length - 1;
    }
    
    boolean isZero() {
        boolean b = false;
        if (this.coefficients[0] == 0) {
            b = true;
        }
        return b;
    }
    
    GenericGFPoly multiply(final int n) {
        GenericGFPoly zero;
        if (n == 0) {
            zero = this.field.getZero();
        }
        else {
            zero = this;
            if (n != 1) {
                final int length = this.coefficients.length;
                final int[] array = new int[length];
                for (int i = 0; i < length; ++i) {
                    array[i] = this.field.multiply(this.coefficients[i], n);
                }
                return new GenericGFPoly(this.field, array);
            }
        }
        return zero;
    }
    
    GenericGFPoly multiply(final GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (this.isZero() || genericGFPoly.isZero()) {
            return this.field.getZero();
        }
        final int[] coefficients = this.coefficients;
        final int length = coefficients.length;
        final int[] coefficients2 = genericGFPoly.coefficients;
        final int length2 = coefficients2.length;
        final int[] array = new int[length + length2 - 1];
        for (int i = 0; i < length; ++i) {
            final int n = coefficients[i];
            for (int j = 0; j < length2; ++j) {
                array[i + j] = GenericGF.addOrSubtract(array[i + j], this.field.multiply(n, coefficients2[j]));
            }
        }
        return new GenericGFPoly(this.field, array);
    }
    
    GenericGFPoly multiplyByMonomial(int i, final int n) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return this.field.getZero();
        }
        final int length = this.coefficients.length;
        final int[] array = new int[length + i];
        for (i = 0; i < length; ++i) {
            array[i] = this.field.multiply(this.coefficients[i], n);
        }
        return new GenericGFPoly(this.field, array);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getDegree() * 8);
        for (int i = this.getDegree(); i >= 0; --i) {
            final int coefficient = this.getCoefficient(i);
            if (coefficient != 0) {
                int n;
                if (coefficient < 0) {
                    sb.append(" - ");
                    n = -coefficient;
                }
                else {
                    n = coefficient;
                    if (sb.length() > 0) {
                        sb.append(" + ");
                        n = coefficient;
                    }
                }
                if (i == 0 || n != 1) {
                    final int log = this.field.log(n);
                    if (log == 0) {
                        sb.append('1');
                    }
                    else if (log == 1) {
                        sb.append('a');
                    }
                    else {
                        sb.append("a^");
                        sb.append(log);
                    }
                }
                if (i != 0) {
                    if (i == 1) {
                        sb.append('x');
                    }
                    else {
                        sb.append("x^");
                        sb.append(i);
                    }
                }
            }
        }
        return sb.toString();
    }
}
