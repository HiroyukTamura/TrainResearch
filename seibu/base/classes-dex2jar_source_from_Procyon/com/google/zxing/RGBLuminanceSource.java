// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class RGBLuminanceSource extends LuminanceSource
{
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;
    
    public RGBLuminanceSource(int i, int dataHeight, final int[] array) {
        super(i, dataHeight);
        this.dataWidth = i;
        this.dataHeight = dataHeight;
        this.left = 0;
        this.top = 0;
        dataHeight *= i;
        this.luminances = new byte[dataHeight];
        int n;
        for (i = 0; i < dataHeight; ++i) {
            n = array[i];
            this.luminances[i] = (byte)(((n >> 16 & 0xFF) + (n >> 7 & 0x1FE) + (n & 0xFF)) / 4);
        }
    }
    
    private RGBLuminanceSource(final byte[] luminances, final int dataWidth, final int dataHeight, final int left, final int top, final int n, final int n2) {
        super(n, n2);
        if (left + n > dataWidth || top + n2 > dataHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.luminances = luminances;
        this.dataWidth = dataWidth;
        this.dataHeight = dataHeight;
        this.left = left;
        this.top = top;
    }
    
    @Override
    public LuminanceSource crop(final int n, final int n2, final int n3, final int n4) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + n, this.top + n2, n3, n4);
    }
    
    @Override
    public byte[] getMatrix() {
        final int width = this.getWidth();
        final int height = this.getHeight();
        byte[] luminances;
        if (width == this.dataWidth && height == this.dataHeight) {
            luminances = this.luminances;
        }
        else {
            final int n = width * height;
            final byte[] array = new byte[n];
            int n2 = this.top * this.dataWidth + this.left;
            if (width == this.dataWidth) {
                System.arraycopy(this.luminances, n2, array, 0, n);
                return array;
            }
            int n3 = 0;
            while (true) {
                luminances = array;
                if (n3 >= height) {
                    break;
                }
                System.arraycopy(this.luminances, n2, array, n3 * width, width);
                n2 += this.dataWidth;
                ++n3;
            }
        }
        return luminances;
    }
    
    @Override
    public byte[] getRow(final int i, final byte[] array) {
        if (i < 0 || i >= this.getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        final int width = this.getWidth();
        byte[] array2 = null;
        Label_0059: {
            if (array != null) {
                array2 = array;
                if (array.length >= width) {
                    break Label_0059;
                }
            }
            array2 = new byte[width];
        }
        System.arraycopy(this.luminances, (this.top + i) * this.dataWidth + this.left, array2, 0, width);
        return array2;
    }
    
    @Override
    public boolean isCropSupported() {
        return true;
    }
}
