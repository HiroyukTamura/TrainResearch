// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class ZoomInTransformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, final float n) {
        final float n2 = 0.0f;
        float abs;
        if (n < 0.0f) {
            abs = n + 1.0f;
        }
        else {
            abs = Math.abs(1.0f - n);
        }
        view.setScaleX(abs);
        view.setScaleY(abs);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        float alpha = n2;
        if (n >= -1.0f) {
            if (n > 1.0f) {
                alpha = n2;
            }
            else {
                alpha = 1.0f - (abs - 1.0f);
            }
        }
        view.setAlpha(alpha);
    }
}
