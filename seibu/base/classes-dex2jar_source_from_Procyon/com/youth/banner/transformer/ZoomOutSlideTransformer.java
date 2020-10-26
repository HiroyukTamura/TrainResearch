// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class ZoomOutSlideTransformer extends ABaseTransformer
{
    private static final float MIN_ALPHA = 0.5f;
    private static final float MIN_SCALE = 0.85f;
    
    @Override
    protected void onTransform(final View view, final float a) {
        if (a >= -1.0f || a <= 1.0f) {
            final float n = (float)view.getHeight();
            final float n2 = (float)view.getWidth();
            final float max = Math.max(0.85f, 1.0f - Math.abs(a));
            final float n3 = (1.0f - max) * n / 2.0f;
            final float n4 = (1.0f - max) * n2 / 2.0f;
            view.setPivotY(0.5f * n);
            view.setPivotX(0.5f * n2);
            if (a < 0.0f) {
                view.setTranslationX(n4 - n3 / 2.0f);
            }
            else {
                view.setTranslationX(-n4 + n3 / 2.0f);
            }
            view.setScaleX(max);
            view.setScaleY(max);
            view.setAlpha((max - 0.85f) / 0.14999998f * 0.5f + 0.5f);
        }
    }
}
