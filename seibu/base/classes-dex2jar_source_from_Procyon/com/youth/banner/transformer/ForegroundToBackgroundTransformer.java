// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class ForegroundToBackgroundTransformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, float translationX) {
        float abs = 1.0f;
        final float n = (float)view.getHeight();
        final float n2 = (float)view.getWidth();
        if (translationX <= 0.0f) {
            abs = Math.abs(1.0f + translationX);
        }
        final float min = ABaseTransformer.min(abs, 0.5f);
        view.setScaleX(min);
        view.setScaleY(min);
        view.setPivotX(n2 * 0.5f);
        view.setPivotY(n * 0.5f);
        if (translationX > 0.0f) {
            translationX *= n2;
        }
        else {
            translationX = -n2 * translationX * 0.25f;
        }
        view.setTranslationX(translationX);
    }
}
