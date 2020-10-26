// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;
import android.graphics.Matrix;
import android.graphics.Camera;

public class TabletTransformer extends ABaseTransformer
{
    private static final Camera OFFSET_CAMERA;
    private static final Matrix OFFSET_MATRIX;
    private static final float[] OFFSET_TEMP_FLOAT;
    
    static {
        OFFSET_MATRIX = new Matrix();
        OFFSET_CAMERA = new Camera();
        OFFSET_TEMP_FLOAT = new float[2];
    }
    
    protected static final float getOffsetXForRotation(float a, final int n, final int n2) {
        TabletTransformer.OFFSET_MATRIX.reset();
        TabletTransformer.OFFSET_CAMERA.save();
        TabletTransformer.OFFSET_CAMERA.rotateY(Math.abs(a));
        TabletTransformer.OFFSET_CAMERA.getMatrix(TabletTransformer.OFFSET_MATRIX);
        TabletTransformer.OFFSET_CAMERA.restore();
        TabletTransformer.OFFSET_MATRIX.preTranslate(-n * 0.5f, -n2 * 0.5f);
        TabletTransformer.OFFSET_MATRIX.postTranslate(n * 0.5f, n2 * 0.5f);
        TabletTransformer.OFFSET_TEMP_FLOAT[0] = (float)n;
        TabletTransformer.OFFSET_TEMP_FLOAT[1] = (float)n2;
        TabletTransformer.OFFSET_MATRIX.mapPoints(TabletTransformer.OFFSET_TEMP_FLOAT);
        final float n3 = (float)n;
        final float n4 = TabletTransformer.OFFSET_TEMP_FLOAT[0];
        if (a > 0.0f) {
            a = 1.0f;
        }
        else {
            a = -1.0f;
        }
        return a * (n3 - n4);
    }
    
    @Override
    protected void onTransform(final View view, float n) {
        float n2;
        if (n < 0.0f) {
            n2 = 30.0f;
        }
        else {
            n2 = -30.0f;
        }
        n = n2 * Math.abs(n);
        view.setTranslationX(getOffsetXForRotation(n, view.getWidth(), view.getHeight()));
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(0.0f);
        view.setRotationY(n);
    }
}
