// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable
{
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;
    
    public BitMatrix(final int n) {
        this(n, n);
    }
    
    public BitMatrix(final int width, final int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = width;
        this.height = height;
        this.rowSize = (width + 31) / 32;
        this.bits = new int[this.rowSize * height];
    }
    
    private BitMatrix(final int width, final int height, final int rowSize, final int[] bits) {
        this.width = width;
        this.height = height;
        this.rowSize = rowSize;
        this.bits = bits;
    }
    
    private String buildToString(final String s, final String s2, final String str) {
        final StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                String str2;
                if (this.get(j, i)) {
                    str2 = s;
                }
                else {
                    str2 = s2;
                }
                sb.append(str2);
            }
            sb.append(str);
        }
        return sb.toString();
    }
    
    public static BitMatrix parse(final String s, final String anObject, final String anObject2) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        final boolean[] array = new boolean[s.length()];
        int n = 0;
        int n2 = 0;
        int n3 = -1;
        int n4 = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '\n' || s.charAt(i) == '\r') {
                int n5 = n4;
                int n6 = n3;
                int n7;
                if (n > (n7 = n2)) {
                    if (n3 == -1) {
                        n6 = n - n2;
                    }
                    else if (n - n2 != (n6 = n3)) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    n7 = n;
                    n5 = n4 + 1;
                }
                ++i;
                n4 = n5;
                n3 = n6;
                n2 = n7;
            }
            else if (s.substring(i, anObject.length() + i).equals(anObject)) {
                i += anObject.length();
                array[n] = true;
                ++n;
            }
            else {
                if (!s.substring(i, anObject2.length() + i).equals(anObject2)) {
                    throw new IllegalArgumentException("illegal character encountered: " + s.substring(i));
                }
                i += anObject2.length();
                array[n] = false;
                ++n;
            }
        }
        int n8 = n4;
        int n9 = n3;
        if (n > n2) {
            if (n3 == -1) {
                n9 = n - n2;
            }
            else if (n - n2 != (n9 = n3)) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            n8 = n4 + 1;
        }
        final BitMatrix bitMatrix = new BitMatrix(n9, n8);
        for (int j = 0; j < n; ++j) {
            if (array[j]) {
                bitMatrix.set(j % n9, j / n9);
            }
        }
        return bitMatrix;
    }
    
    public static BitMatrix parse(final boolean[][] array) {
        final int length = array.length;
        final int length2 = array[0].length;
        final BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i = 0; i < length; ++i) {
            final boolean[] array2 = array[i];
            for (int j = 0; j < length2; ++j) {
                if (array2[j]) {
                    bitMatrix.set(j, i);
                }
            }
        }
        return bitMatrix;
    }
    
    public void clear() {
        for (int length = this.bits.length, i = 0; i < length; ++i) {
            this.bits[i] = 0;
        }
    }
    
    public BitMatrix clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, this.bits.clone());
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof BitMatrix) {
            final BitMatrix bitMatrix = (BitMatrix)o;
            if (this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits)) {
                return true;
            }
        }
        return false;
    }
    
    public void flip(final int n, int n2) {
        n2 = this.rowSize * n2 + n / 32;
        final int[] bits = this.bits;
        bits[n2] ^= 1 << (n & 0x1F);
    }
    
    public boolean get(final int n, final int n2) {
        return (this.bits[this.rowSize * n2 + n / 32] >>> (n & 0x1F) & 0x1) != 0x0;
    }
    
    public int[] getBottomRightOnBit() {
        int n;
        for (n = this.bits.length - 1; n >= 0 && this.bits[n] == 0; --n) {}
        if (n < 0) {
            return null;
        }
        final int n2 = n / this.rowSize;
        final int rowSize = this.rowSize;
        int n3;
        int n4;
        for (n3 = this.bits[n], n4 = 31; n3 >>> n4 == 0; --n4) {}
        return new int[] { (n % rowSize << 5) + n4, n2 };
    }
    
    public int[] getEnclosingRectangle() {
        int width = this.width;
        int height = this.height;
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < this.height; ++i) {
            int n4;
            int n5;
            int n6;
            int n7;
            for (int j = 0; j < this.rowSize; ++j, n2 = n4, width = n5, n = n6, height = n7) {
                final int n3 = this.bits[this.rowSize * i + j];
                n4 = n2;
                n5 = width;
                n6 = n;
                n7 = height;
                if (n3 != 0) {
                    int n8;
                    if (i < (n8 = height)) {
                        n8 = i;
                    }
                    int n9;
                    if (i > (n9 = n2)) {
                        n9 = i;
                    }
                    int n10;
                    if (j << 5 < (n10 = width)) {
                        int n11;
                        for (n11 = 0; n3 << 31 - n11 == 0; ++n11) {}
                        if ((j << 5) + n11 < (n10 = width)) {
                            n10 = (j << 5) + n11;
                        }
                    }
                    n4 = n9;
                    n5 = n10;
                    n6 = n;
                    n7 = n8;
                    if ((j << 5) + 31 > n) {
                        int n12;
                        for (n12 = 31; n3 >>> n12 == 0; --n12) {}
                        n4 = n9;
                        n5 = n10;
                        n6 = n;
                        n7 = n8;
                        if ((j << 5) + n12 > n) {
                            n6 = (j << 5) + n12;
                            n7 = n8;
                            n5 = n10;
                            n4 = n9;
                        }
                    }
                }
            }
        }
        if (n < width || n2 < height) {
            return null;
        }
        return new int[] { width, height, n - width + 1, n2 - height + 1 };
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public BitArray getRow(final int n, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        }
        else {
            bitArray.clear();
        }
        final int rowSize = this.rowSize;
        for (int i = 0; i < this.rowSize; ++i) {
            bitArray.setBulk(i << 5, this.bits[n * rowSize + i]);
        }
        return bitArray;
    }
    
    public int getRowSize() {
        return this.rowSize;
    }
    
    public int[] getTopLeftOnBit() {
        int n;
        for (n = 0; n < this.bits.length && this.bits[n] == 0; ++n) {}
        if (n == this.bits.length) {
            return null;
        }
        final int n2 = n / this.rowSize;
        final int rowSize = this.rowSize;
        int n3;
        int n4;
        for (n3 = this.bits[n], n4 = 0; n3 << 31 - n4 == 0; ++n4) {}
        return new int[] { (n % rowSize << 5) + n4, n2 };
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    public int hashCode() {
        return (((this.width * 31 + this.width) * 31 + this.height) * 31 + this.rowSize) * 31 + Arrays.hashCode(this.bits);
    }
    
    public void rotate180() {
        final int width = this.getWidth();
        final int height = this.getHeight();
        BitArray row = new BitArray(width);
        BitArray row2 = new BitArray(width);
        for (int i = 0; i < (height + 1) / 2; ++i) {
            row = this.getRow(i, row);
            row2 = this.getRow(height - 1 - i, row2);
            row.reverse();
            row2.reverse();
            this.setRow(i, row2);
            this.setRow(height - 1 - i, row);
        }
    }
    
    public void set(final int n, int n2) {
        n2 = this.rowSize * n2 + n / 32;
        final int[] bits = this.bits;
        bits[n2] |= 1 << (n & 0x1F);
    }
    
    public void setRegion(final int n, int i, int j, int n2) {
        if (i < 0 || n < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (n2 <= 0 || j <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        final int n3 = n + j;
        n2 += i;
        if (n2 > this.height || n3 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i < n2) {
            final int rowSize = this.rowSize;
            int[] bits;
            int n4;
            for (j = n; j < n3; ++j) {
                bits = this.bits;
                n4 = j / 32 + i * rowSize;
                bits[n4] |= 1 << (j & 0x1F);
            }
            ++i;
        }
    }
    
    public void setRow(final int n, final BitArray bitArray) {
        System.arraycopy(bitArray.getBitArray(), 0, this.bits, this.rowSize * n, this.rowSize);
    }
    
    @Override
    public String toString() {
        return this.toString("X ", "  ");
    }
    
    public String toString(final String s, final String s2) {
        return this.buildToString(s, s2, "\n");
    }
    
    @Deprecated
    public String toString(final String s, final String s2, final String s3) {
        return this.buildToString(s, s2, s3);
    }
    
    public void unset(final int n, int n2) {
        n2 = this.rowSize * n2 + n / 32;
        final int[] bits = this.bits;
        bits[n2] &= ~(1 << (n & 0x1F));
    }
    
    public void xor(final BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        final BitArray bitArray = new BitArray(this.width / 32 + 1);
        for (int i = 0; i < this.height; ++i) {
            final int rowSize = this.rowSize;
            final int[] bitArray2 = bitMatrix.getRow(i, bitArray).getBitArray();
            for (int j = 0; j < this.rowSize; ++j) {
                final int[] bits = this.bits;
                final int n = i * rowSize + j;
                bits[n] ^= bitArray2[j];
            }
        }
    }
}
