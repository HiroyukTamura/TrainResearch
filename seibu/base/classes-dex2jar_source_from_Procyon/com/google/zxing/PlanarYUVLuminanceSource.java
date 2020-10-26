// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class PlanarYUVLuminanceSource extends LuminanceSource
{
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;
    
    public PlanarYUVLuminanceSource(final byte[] yuvData, final int dataWidth, final int dataHeight, final int left, final int top, final int n, final int n2, final boolean b) {
        super(n, n2);
        if (left + n > dataWidth || top + n2 > dataHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = yuvData;
        this.dataWidth = dataWidth;
        this.dataHeight = dataHeight;
        this.left = left;
        this.top = top;
        if (b) {
            this.reverseHorizontal(n, n2);
        }
    }
    
    private void reverseHorizontal(final int n, final int n2) {
        final byte[] yuvData = this.yuvData;
        for (int i = 0, n3 = this.top * this.dataWidth + this.left; i < n2; ++i, n3 += this.dataWidth) {
            for (int n4 = n / 2, j = n3, n5 = n3 + n - 1; j < n3 + n4; ++j, --n5) {
                final byte b = yuvData[j];
                yuvData[j] = yuvData[n5];
                yuvData[n5] = b;
            }
        }
    }
    
    @Override
    public LuminanceSource crop(final int n, final int n2, final int n3, final int n4) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + n, this.top + n2, n3, n4, false);
    }
    
    @Override
    public byte[] getMatrix() {
        final int width = this.getWidth();
        final int height = this.getHeight();
        byte[] yuvData;
        if (width == this.dataWidth && height == this.dataHeight) {
            yuvData = this.yuvData;
        }
        else {
            final int n = width * height;
            final byte[] array = new byte[n];
            int n2 = this.top * this.dataWidth + this.left;
            if (width == this.dataWidth) {
                System.arraycopy(this.yuvData, n2, array, 0, n);
                return array;
            }
            int n3 = 0;
            while (true) {
                yuvData = array;
                if (n3 >= height) {
                    break;
                }
                System.arraycopy(this.yuvData, n2, array, n3 * width, width);
                n2 += this.dataWidth;
                ++n3;
            }
        }
        return yuvData;
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
        System.arraycopy(this.yuvData, (this.top + i) * this.dataWidth + this.left, array2, 0, width);
        return array2;
    }
    
    public int getThumbnailHeight() {
        return this.getHeight() / 2;
    }
    
    public int getThumbnailWidth() {
        return this.getWidth() / 2;
    }
    
    @Override
    public boolean isCropSupported() {
        return true;
    }
    
    public int[] renderThumbnail() {
        final int n = this.getWidth() / 2;
        final int n2 = this.getHeight() / 2;
        final int[] array = new int[n * n2];
        final byte[] yuvData = this.yuvData;
        int n3 = this.top * this.dataWidth + this.left;
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                array[i * n + j] = (0xFF000000 | 65793 * (yuvData[(j << 1) + n3] & 0xFF));
            }
            n3 += this.dataWidth << 1;
        }
        return array;
    }
}
