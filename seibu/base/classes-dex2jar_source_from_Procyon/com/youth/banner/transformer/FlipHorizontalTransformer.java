// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class FlipHorizontalTransformer extends ABaseTransformer
{
    @Override
    protected void onPostTransform(final View view, final float n) {
        super.onPostTransform(view, n);
        if (n > -0.5f && n < 0.5f) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(4);
    }
    
    @Override
    protected void onTransform(final View view, float alpha) {
        final float rotationY = 180.0f * alpha;
        if (rotationY > 90.0f || rotationY < -90.0f) {
            alpha = 0.0f;
        }
        else {
            alpha = 1.0f;
        }
        view.setAlpha(alpha);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(rotationY);
    }
}
