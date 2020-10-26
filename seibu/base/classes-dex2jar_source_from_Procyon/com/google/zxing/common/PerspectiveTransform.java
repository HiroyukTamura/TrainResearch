// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.common;

public final class PerspectiveTransform
{
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;
    
    private PerspectiveTransform(final float a11, final float a12, final float a13, final float a14, final float a15, final float a16, final float a17, final float a18, final float a19) {
        this.a11 = a11;
        this.a12 = a14;
        this.a13 = a17;
        this.a21 = a12;
        this.a22 = a15;
        this.a23 = a18;
        this.a31 = a13;
        this.a32 = a16;
        this.a33 = a19;
    }
    
    public static PerspectiveTransform quadrilateralToQuadrilateral(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14, final float n15, final float n16) {
        return squareToQuadrilateral(n9, n10, n11, n12, n13, n14, n15, n16).times(quadrilateralToSquare(n, n2, n3, n4, n5, n6, n7, n8));
    }
    
    public static PerspectiveTransform quadrilateralToSquare(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        return squareToQuadrilateral(n, n2, n3, n4, n5, n6, n7, n8).buildAdjoint();
    }
    
    public static PerspectiveTransform squareToQuadrilateral(final float n, final float n2, final float n3, final float n4, float n5, float n6, final float n7, final float n8) {
        final float n9 = n - n3 + n5 - n7;
        final float n10 = n2 - n4 + n6 - n8;
        if (n9 == 0.0f && n10 == 0.0f) {
            return new PerspectiveTransform(n3 - n, n5 - n3, n, n4 - n2, n6 - n4, n2, 0.0f, 0.0f, 1.0f);
        }
        final float n11 = n3 - n5;
        final float n12 = n7 - n5;
        n5 = n4 - n6;
        final float n13 = n8 - n6;
        n6 = n11 * n13 - n12 * n5;
        final float n14 = (n9 * n13 - n12 * n10) / n6;
        n5 = (n11 * n10 - n9 * n5) / n6;
        return new PerspectiveTransform(n3 - n + n14 * n3, n7 - n + n5 * n7, n, n14 * n4 + (n4 - n2), n5 * n8 + (n8 - n2), n2, n14, n5, 1.0f);
    }
    
    PerspectiveTransform buildAdjoint() {
        return new PerspectiveTransform(this.a22 * this.a33 - this.a23 * this.a32, this.a23 * this.a31 - this.a21 * this.a33, this.a21 * this.a32 - this.a22 * this.a31, this.a13 * this.a32 - this.a12 * this.a33, this.a11 * this.a33 - this.a13 * this.a31, this.a12 * this.a31 - this.a11 * this.a32, this.a12 * this.a23 - this.a13 * this.a22, this.a13 * this.a21 - this.a11 * this.a23, this.a11 * this.a22 - this.a12 * this.a21);
    }
    
    PerspectiveTransform times(final PerspectiveTransform perspectiveTransform) {
        return new PerspectiveTransform(this.a11 * perspectiveTransform.a11 + this.a21 * perspectiveTransform.a12 + this.a31 * perspectiveTransform.a13, this.a11 * perspectiveTransform.a21 + this.a21 * perspectiveTransform.a22 + this.a31 * perspectiveTransform.a23, this.a11 * perspectiveTransform.a31 + this.a21 * perspectiveTransform.a32 + this.a31 * perspectiveTransform.a33, this.a12 * perspectiveTransform.a11 + this.a22 * perspectiveTransform.a12 + this.a32 * perspectiveTransform.a13, this.a12 * perspectiveTransform.a21 + this.a22 * perspectiveTransform.a22 + this.a32 * perspectiveTransform.a23, this.a12 * perspectiveTransform.a31 + this.a22 * perspectiveTransform.a32 + this.a32 * perspectiveTransform.a33, this.a13 * perspectiveTransform.a11 + this.a23 * perspectiveTransform.a12 + this.a33 * perspectiveTransform.a13, this.a13 * perspectiveTransform.a21 + this.a23 * perspectiveTransform.a22 + this.a33 * perspectiveTransform.a23, this.a13 * perspectiveTransform.a31 + this.a23 * perspectiveTransform.a32 + this.a33 * perspectiveTransform.a33);
    }
    
    public void transformPoints(final float[] array) {
        final int length = array.length;
        final float a11 = this.a11;
        final float a12 = this.a12;
        final float a13 = this.a13;
        final float a14 = this.a21;
        final float a15 = this.a22;
        final float a16 = this.a23;
        final float a17 = this.a31;
        final float a18 = this.a32;
        final float a19 = this.a33;
        for (int i = 0; i < length; i += 2) {
            final float n = array[i];
            final float n2 = array[i + 1];
            final float n3 = a13 * n + a16 * n2 + a19;
            array[i] = (a11 * n + a14 * n2 + a17) / n3;
            array[i + 1] = (a12 * n + a15 * n2 + a18) / n3;
        }
    }
    
    public void transformPoints(final float[] array, final float[] array2) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final float n = array[i];
            final float n2 = array2[i];
            final float n3 = this.a13 * n + this.a23 * n2 + this.a33;
            array[i] = (this.a11 * n + this.a21 * n2 + this.a31) / n3;
            array2[i] = (this.a12 * n + this.a22 * n2 + this.a32) / n3;
        }
    }
}
