// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class StackTransformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, float translationX) {
        final float n = 0.0f;
        if (translationX < 0.0f) {
            translationX = n;
        }
        else {
            translationX *= -view.getWidth();
        }
        view.setTranslationX(translationX);
    }
}
