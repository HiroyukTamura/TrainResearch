// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly
{
    private final int[] coefficients;
    private final ModulusGF field;
    
    ModulusPoly(final ModulusGF field, final int[] coefficients) {
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
    
    ModulusPoly add(final ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (this.isZero()) {
            return modulusPoly;
        }
        if (modulusPoly.isZero()) {
            return this;
        }
        final int[] coefficients = this.coefficients;
        int[] coefficients2;
        final int[] array = coefficients2 = modulusPoly.coefficients;
        int[] array2 = coefficients;
        if (coefficients.length > array.length) {
            array2 = array;
            coefficients2 = coefficients;
        }
        final int[] array3 = new int[coefficients2.length];
        final int n = coefficients2.length - array2.length;
        System.arraycopy(coefficients2, 0, array3, 0, n);
        for (int i = n; i < coefficients2.length; ++i) {
            array3[i] = this.field.add(array2[i - n], coefficients2[i]);
        }
        return new ModulusPoly(this.field, array3);
    }
    
    int evaluateAt(int add) {
        int n = 0;
        int coefficient;
        if (add == 0) {
            coefficient = this.getCoefficient(0);
        }
        else if (add == 1) {
            add = 0;
            final int[] coefficients = this.coefficients;
            final int length = coefficients.length;
            while (true) {
                coefficient = add;
                if (n >= length) {
                    break;
                }
                add = this.field.add(add, coefficients[n]);
                ++n;
            }
        }
        else {
            int add2 = this.coefficients[0];
            final int length2 = this.coefficients.length;
            int n2 = 1;
            while (true) {
                coefficient = add2;
                if (n2 >= length2) {
                    break;
                }
                add2 = this.field.add(this.field.multiply(add, add2), this.coefficients[n2]);
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
    
    ModulusPoly multiply(final int n) {
        ModulusPoly zero;
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
                return new ModulusPoly(this.field, array);
            }
        }
        return zero;
    }
    
    ModulusPoly multiply(final ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (this.isZero() || modulusPoly.isZero()) {
            return this.field.getZero();
        }
        final int[] coefficients = this.coefficients;
        final int length = coefficients.length;
        final int[] coefficients2 = modulusPoly.coefficients;
        final int length2 = coefficients2.length;
        final int[] array = new int[length + length2 - 1];
        for (int i = 0; i < length; ++i) {
            final int n = coefficients[i];
            for (int j = 0; j < length2; ++j) {
                array[i + j] = this.field.add(array[i + j], this.field.multiply(n, coefficients2[j]));
            }
        }
        return new ModulusPoly(this.field, array);
    }
    
    ModulusPoly multiplyByMonomial(int i, final int n) {
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
        return new ModulusPoly(this.field, array);
    }
    
    ModulusPoly negative() {
        final int length = this.coefficients.length;
        final int[] array = new int[length];
        for (int i = 0; i < length; ++i) {
            array[i] = this.field.subtract(0, this.coefficients[i]);
        }
        return new ModulusPoly(this.field, array);
    }
    
    ModulusPoly subtract(final ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (modulusPoly.isZero()) {
            return this;
        }
        return this.add(modulusPoly.negative());
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getDegree() * 8);
        for (int i = this.getDegree(); i >= 0; --i) {
            final int coefficient = this.getCoefficient(i);
            if (coefficient != 0) {
                int j;
                if (coefficient < 0) {
                    sb.append(" - ");
                    j = -coefficient;
                }
                else {
                    j = coefficient;
                    if (sb.length() > 0) {
                        sb.append(" + ");
                        j = coefficient;
                    }
                }
                if (i == 0 || j != 1) {
                    sb.append(j);
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
