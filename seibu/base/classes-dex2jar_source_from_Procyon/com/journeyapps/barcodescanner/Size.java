// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import android.support.annotation.NonNull;

public class Size implements Comparable<Size>
{
    public final int height;
    public final int width;
    
    public Size(final int width, final int height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public int compareTo(@NonNull final Size size) {
        final int n = this.height * this.width;
        final int n2 = size.height * size.width;
        if (n2 < n) {
            return 1;
        }
        if (n2 > n) {
            return -1;
        }
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            final Size size = (Size)o;
            if (this.width != size.width || this.height != size.height) {
                return false;
            }
        }
        return true;
    }
    
    public boolean fitsIn(final Size size) {
        return this.width <= size.width && this.height <= size.height;
    }
    
    @Override
    public int hashCode() {
        return this.width * 31 + this.height;
    }
    
    public Size rotate() {
        return new Size(this.height, this.width);
    }
    
    public Size scale(final int n, final int n2) {
        return new Size(this.width * n / n2, this.height * n / n2);
    }
    
    public Size scaleCrop(final Size size) {
        if (this.width * size.height <= size.width * this.height) {
            return new Size(size.width, this.height * size.width / this.width);
        }
        return new Size(this.width * size.height / this.height, size.height);
    }
    
    public Size scaleFit(final Size size) {
        if (this.width * size.height >= size.width * this.height) {
            return new Size(size.width, this.height * size.width / this.width);
        }
        return new Size(this.width * size.height / this.height, size.height);
    }
    
    @Override
    public String toString() {
        return this.width + "x" + this.height;
    }
}
