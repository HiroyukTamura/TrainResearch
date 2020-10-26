// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class DepthPageTransformer extends ABaseTransformer
{
    private static final float MIN_SCALE = 0.75f;
    
    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
    
    @Override
    protected void onTransform(final View view, final float a) {
        if (a <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
        else if (a <= 1.0f) {
            final float n = 0.75f + 0.25f * (1.0f - Math.abs(a));
            view.setAlpha(1.0f - a);
            view.setPivotY(0.5f * view.getHeight());
            view.setTranslationX(view.getWidth() * -a);
            view.setScaleX(n);
            view.setScaleY(n);
        }
    }
}
