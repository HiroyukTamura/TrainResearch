// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class ZoomOutTranformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, final float a) {
        final float n = 1.0f + Math.abs(a);
        view.setScaleX(n);
        view.setScaleY(n);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        float alpha;
        if (a < -1.0f || a > 1.0f) {
            alpha = 0.0f;
        }
        else {
            alpha = 1.0f - (n - 1.0f);
        }
        view.setAlpha(alpha);
        if (a == -1.0f) {
            view.setTranslationX((float)(view.getWidth() * -1));
        }
    }
}
